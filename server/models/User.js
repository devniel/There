// User

var os = require("os");

var mysql      = require('mysql');

var connection = mysql.createConnection({
  host     : 'localhost',
  user     : 'root',
  password : 'root',
  database : 'there'
});

connection.connect();



/*
 * Models
 */

var User = function(){

	this.id = null;
	this.username = null;
	this.firstname = null;
	this.lastname = null;
	this.facebook = null;
	this.gender = null;
	this.timezone = null;
	this.locale = null;
	this.email = null;
	this.password = null;
	this.picture = null;
	this.fid = null;


	this.save = function(fn){

		var self = this;

		// MYSQL

		connection.query('insert into user (firstname,lastname,email,username,password) values (?,?,?,?,?)', [
			self.firstname,
			self.lastname,
			self.email,
			self.username,
			self.password
		], function(err, result) {
		  if (err) throw err;
		  return fn(result);
		});
	}

	this.findById = function(id){

	}

	this.findAll = function(){

	}


}


//connection.end();

module.exports = User;