
/*
 * GET home page.
 */

exports.index = function(req, res){
  res.render('index', {
	  	layout: false,
	  	locals:{
	  	title: 'Express'
	  }
	});
};