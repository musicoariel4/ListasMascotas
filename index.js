const express = require('express')
var app = express()
const path = require('path')
const PORT = process.env.PORT || 5000
app.set('port', (process.env.PORT || 5000));


var bodyParser = require("body-parser");
app.use(bodyParser.json()); //soporte para codificar json
app.use(bodyParser.urlencoded({ extended: true })); //Soporte para decodificar las url

var admin = require('firebase-admin')


var serviceAccount = require("./listamascotasariel-1b73aa26e57c.json")
// Initialize the app with a service account, granting admin privileges
admin.initializeApp({
  credential: admin.credential.cert(serviceAccount),
  databaseURL: "https://listamascotasariel-default-rtdb.firebaseio.com/"
})

app.use(express.static(__dirname + '/public'));
//app.use(express.static(path.join(__dirname, 'public')))

// views is directory for all template files
app.set('views', __dirname + '/views');
//app.set('views', path.join(__dirname, 'views'))
app.set('view engine', 'ejs');

app.get('/android', function(req, res) {
   res.render('pages/index');
});

    
//POST
//https://afternoon-lowlands-49612.herokuapp.com/token-device
//token
//animal
var tokenDevicesURI = "registrar-usuario";
app.post('/' + tokenDevicesURI, function(request, response) {
	var id_dispositivo 	= request.body.id_dispositivo;
	var id_usuario_instagram 	= request.body.id_usuario_instagram;
	var db = admin.database();
	var tokenDevices = db.ref(tokenDevicesURI).push();
	tokenDevices.set({
		id_dispositivo: id_dispositivo,
		id_usuario_instagram: id_usuario_instagram
	});	

	var path = tokenDevices.toString(); //https://project-4284821003924177471.firebaseio.com/token-device/-KJlTaOQPwP-ssImryV1
	var pathSplit = path.split(tokenDevicesURI + "/")
	var idAutoGenerado = pathSplit[1];

	var respuesta = generarRespuestaAToken(db, idAutoGenerado);
	response.setHeader("Content-Type", "application/json");
	response.send(JSON.stringify(respuesta));
});
function generarRespuestaAToken(db, idAutoGenerado) {
	var respuesta = {};
	var id_dispositivo = "";
    var id_usuario_instagram = ""; 
	var ref = db.ref("registrar-usuario");
	ref.on("child_added", function(snapshot, prevChildKey) {
		usuario = snapshot.val();
		respuesta = {
			id: idAutoGenerado,
			id_dispositivo: usuario.id_dispositivo,
			id_usuario_instagram: usuario.id_usuario_instagram
		};id_usuario_instagram
	});
	return respuesta;
}    

app.listen(app.get('port'), function() {
  console.log('Node app is running on port', app.get('port'));
});
  

