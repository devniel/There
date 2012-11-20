
/**
 * Module dependencies.
 */

var express = require('express')
  , routes = require('./routes')
  , user = require('./routes/user')
  , http = require('http')
  , path = require('path');


var Users = require("./controllers/Users");

var app = module.exports = express();

app.configure(function(){
  app.set('port', process.env.PORT || 3000);
  app.set('views', __dirname + '/views');
  app.set('view engine', 'ejs');
  app.use(express.favicon());
  app.use(express.logger('dev'));
  app.use(express.bodyParser());
  app.use(express.methodOverride());
  app.use(express.cookieParser('your secret here'));
  app.use(express.session());
  app.use(app.router);
  app.use(require('stylus').middleware(__dirname + '/public'));
  app.use(express.static(path.join(__dirname, 'public')));
});

app.configure('development', function(){
  app.use(express.errorHandler());
});

app.configure('production',function(){
	app.use(express.logger());
	app.use(express.errorHandler());
});

app.configure('test', function(){
	app.use(express.errorHandler({dumpExceptions: true, showStack:true}));
});

app.get('/', routes.index);

app.get('/users', function(req,res,next){
	res.end("Bienvenido"); 
});

app.post('/users/create', Users.create);
app.post('/users/:id', Users.read);

/*
http.createServer(app).listen(app.get('port'), function(){
  console.log("Express server listening on port " + app.get('port'));
});
*/

//if(!module.parent){
	app.listen(3000);
	
//}
