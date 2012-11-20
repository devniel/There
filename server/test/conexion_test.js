process.env.NODE_ENV = "test";

var request = require("supertest");
var app = require("../app");
var assert = require("assert");
var Users = require("../controllers/Users");
var User = require("../models/User");
describe("GET /users", function(){
	it("Should return Bienvenido", function(done){
	request(app)
		.get("/users/")
		.expect(200)
		.expect("Bienvenido")
		.end(function(err,res){
			if(err) throw err;
			done();
		});
	});
});

describe("POST /users/create",function(){
	it("Should return JSON", function(done){
		request(app)
			.post("/users/create")
			.expect(200)
			.end(function(err,res){
				if(err) throw err;
				done();
			});
	});
});

describe("Creating an user", function(){
	it("Should return the JSON of the user",function(){
		var newUser = new User();
		newUser.firstname = "Daniel";
		newUser.email = "machazo@gmail.com";
		newUser.username = "mark";
		newUser.password = "markito";
		newUser.save(function(u){
			newUser.id = u.insertId;
			done();
		});
			
	});
});
