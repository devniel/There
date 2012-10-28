
/**
 * Module dependencies.
 */

var express = require('express')
  , routes = require('./routes');

var app = module.exports = express.createServer();

// Configuration

app.configure(function(){
  app.set('views', __dirname + '/views');
  app.set('view engine', 'ejs');
  app.use(express.bodyParser());
  app.use(express.methodOverride());
  app.use(express.cookieParser());
  app.use(express.session({ secret: 'your secret here' }));
  app.use(app.router);
  app.use(express.static(__dirname + '/public'));
});

app.configure('development', function(){
  app.use(express.errorHandler({ dumpExceptions: true, showStack: true }));
});

app.configure('production', function(){
  app.use(express.errorHandler());
});

// Routes

app.get('/', function(req, res){

  if(req.session.user != null){
    res.render('user', {
        layout: false,
        locals:{
        user: req.session.user
      }
    });
  }else{
    res.render('index', {
        layout: false,
        locals:{
        title: 'Express'
      }
    });
  }
});

app.get('/devniel',function(req,res){
  res.render('user.ejs', {
      layout: false,
      locals:{
      title: 'devniel'
    }
  });
});

app.post('/search',function(req,res){

  console.log(req.body);

  var data = {
    users : [
    {
      user:"fyushi",
      name:"Francisco Yushimito",
      picture:"https://fbcdn-profile-a.akamaihd.net/hprofile-ak-snc4/173172_1079936984_379287142_n.jpg",
      location:"Lima",
      country:"Perú"
    },{
      user:"respinoza",
      name:"Roberto Espinoza",
      picture:"https://fbcdn-profile-a.akamaihd.net/hprofile-ak-snc4/211470_1068804334_8357124_n.jpg",
      location:"Lima",
      country:"Perú"
    },{
      user:"devniel",
      name:"Daniel Flores",
      picture:"https://fbcdn-profile-a.akamaihd.net/hprofile-ak-snc4/572890_1440246516_1610901045_n.jpg",
      location:"Lima",
      country:"Perú"
    },{
      user:"mshinno",
      name:"Mitsuo Shinno",
      picture:"https://fbcdn-profile-a.akamaihd.net/hprofile-ak-snc4/161355_100003220056078_220943401_n.jpg",
      location:"Lima",
      country:"Perú"
    },{
      user:"equiroz",
      name:"Estefania Quiroz",
      picture:"https://fbcdn-profile-a.akamaihd.net/hprofile-ak-ash2/371275_1257032201_984465114_n.jpg",
      location:"Lima",
      country:"Perú"
    },{
      user:"pbautista",
      name:"Pedro Bautista",
      picture:"https://fbcdn-profile-a.akamaihd.net/hprofile-ak-snc4/161192_705322460_1830054953_n.jpg",
      location:"Lima",
      country:"Perú"
    },{
      user:"gustavobazo",
      name:"Gustavo San Miguel",
      picture:"https://fbcdn-profile-a.akamaihd.net/hprofile-ak-snc4/369211_1496714512_1150324623_n.jpg",
      location:"Lima",
      country:"Perú"
    },{
      user:"luismi",
      name:"Luis Espinoza",
      picture:"https://fbcdn-profile-a.akamaihd.net/hprofile-ak-ash2/369723_100002474854940_407940724_n.jpg",
      location:"Lima",
      country:"Perú"
    }
  ]};

  res.send(data);

})

// SIGN IN

app.post('/sign-up',function(req,res){
  console.log(req.body);
  var resp = '<input type="text" name="first-name" id="i_first-name" placeholder="Nombres"/><input type="text" name="last-name" id="i_last-name" placeholder="Apellidos"/>';
  res.end(resp);
});



// SIGN UP
app.post('/sign-in',function(req,res){
  console.log(req.body);

  var data = {
      username:"devniel",
      password:"leeroy",
      email:"dnielfs@gmail.com",
      name:"Daniel Flores",
      picture:"https://fbcdn-profile-a.akamaihd.net/hprofile-ak-snc4/572890_1440246516_1610901045_n.jpg",
      location:"Lima",
      country:"Perú"
    };

    req.session.user = data;
    res.redirect("/");
});


app.get('/users/:username',function(req,res,next){
  var profile = req.params.username;
  console.log(profile);
  var data = {
      username:"mitsuo",
      email:"mitsuo@hotmail.com",
      name:"Mitsuo Shinno",
      picture:"https://fbcdn-profile-a.akamaihd.net/hprofile-ak-snc4/161355_100003220056078_220943401_q.jpg",
      location:"Lima",
      country:"Perú"
    };

    res.render('profile.ejs', {
      layout: false,
      locals:{
        title: 'devniel',
        user : req.session.user,
        profile : data
      }
  });
})
app.listen(3000);

//console.log("Express server listening on port %d in %s mode", app.address().port, app.settings.env);
