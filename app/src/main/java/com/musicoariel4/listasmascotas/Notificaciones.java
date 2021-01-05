package com.musicoariel4.listasmascotas;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.musicoariel4.listasmascotas.pojo.UsuarioRespond;
import com.musicoariel4.listasmascotas.restApi.IEndpointsApi;
import com.musicoariel4.listasmascotas.restApi.adapter.RestApiAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Notificaciones extends AppCompatActivity {

  private static final String TAG = "MyFirebaseMsgService";
  int duration = Toast.LENGTH_LONG;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificaciones);

     }

   public void lanzarNotificacion(View v){
        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "Fetching FCM registration token failed", task.getException());
                            return;
                        }

                        // Get new FCM registration token
                        String token = task.getResult();
                        enviarTokenRegistro(token,"instagram");
                        // Log and toast
                        String msg = getString(R.string.msg_token_fmt, token);
                        Log.d(TAG, msg);
                        //  Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
                    }
                });
        FirebaseMessaging.getInstance().subscribeToTopic("tutorial");
    }

    private void enviarTokenRegistro(String token, String inst){
        // Log.d("TOKEN en enviar", token);
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        IEndpointsApi endponits = restApiAdapter.establecerConexionRestAPI();
        Call<UsuarioRespond> usuarioResponseCall = endponits.registrarToken(token,inst);

        usuarioResponseCall.enqueue(new Callback<UsuarioRespond>() {
            @Override
            public void onResponse(Call<UsuarioRespond> call, Response<UsuarioRespond> response) {
                UsuarioRespond usuarioResponse = response.body();


                // Context context2 = getApplicationContext();
                // CharSequence text = usuarioResponse.getId();
                //CharSequence text2= usuarioResponse.getToken();
                // Toast toast1 = Toast.makeText(context2, text, duration);
                // Toast toast2 = Toast.makeText(context2, text2, duration);
                //  toast1.show();
                //  toast2.show();
                Log.d("ID_FIREBASE", usuarioResponse.getId());
                Log.d("ID_DISPOSIVO", usuarioResponse.getId_dispositivo());
                Log.d("ID_INSTAGRAM", usuarioResponse.getId_usuario_instagram());


            }

            @Override
            public void onFailure(Call<UsuarioRespond> call, Throwable t) {

            }
        });
    }
    }
