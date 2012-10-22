/**
 *	User Controller
 */

var User = require("../models/User");


var Users = function(){

	// CRUD

	this.read = function(req,res,next){

	}

	this.delete = function(req,res,next){

	}

	this.create = function(req,res,next){

		var user = new User();
		/*user.firstname = "Daniel Mauricio";
		user.lastname = "Flores Sánchez";
		user.facebook = null;
		user.gender = "male";
		user.timezone = -5;
		user.locale = "es";
		user.email = "dnielfs@gmail.com";
		user.username = "devniel";
		user.password = "dni007";
		user.picture = null;*/

		console.log(req.body);

		/*user.save(function(rows){
			console.log("FILA 0 ---> : " , rows[0]);
			res.end("HOLA");
		});*/

		res.end("HOLA");

		// Determinar si está invitado
		/*if(req.body.email == "dnielfs@gmail.com"){
			var user = new User();
		  	user.name.first = req.body.first_name;
		    user.name.last = req.body.last_name;
		    user.email = req.body.email;
		    user.password = req.body.password;
		    user.picture = "#";
		   
		   	user.save(function(err){
		      if(err)
		      	req.flash("error","Error desconocido");
		      else
		      	req.session.user = user;
		      res.redirect("/");          
		    })
        }else{
			req.flash("error","No estás invitado");
			res.redirect("/");
		}*/



	}

	this.update = function(req,res,next){

	}

	this.all = function(req,res,next){
		return User.findAll();
	}
}

module.exports = new Users();
