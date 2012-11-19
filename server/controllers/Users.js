/**
 *	User Controller
 */

var User = require("../models/User");

var mysql      = require('mysql');

var connection = mysql.createConnection({
  host     : 'localhost',
  user     : 'root',
  password : 'M@urici0',
  database : 'there'
});

connection.connect();

var Users = function(){

	/**
	 *
	 */

	var findById = function(id,fn){
		connection.query('select * from user where id = ?', id , function(err, result) {
		  if (err) throw err;
		  return fn(result[0]);
		});
	}

	// CRUD

	this.read = function(req,res,next){

		var id = req.params.id;

		findById(id,function(user){

			console.log(user);
			res.end(JSON.stringify(user));
		});	

	}

	this.delete = function(req,res,next){

	}

	this.create = function(req,res,next){

		console.log(req.body);

		var user = new User();
		user.firstname = req.body.firstname;
		user.email = req.body.email;
		user.username = req.body.username;
		user.password = req.body.password;

		user.save(function(u){
			user.id = u.insertId;
			res.end(JSON.stringify(user));
		});

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
