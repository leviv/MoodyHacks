$(document).ready(function(){
    firebase.onAuthStateChanged(user);
});

$(document).ready(function(){

    $('.switcher').click(function(e) {  
        $(".switcher").css({"border-width": "100vh 50vw 0 0"});
    });
});



var provider = new firebase.auth.GoogleAuthProvider();
firebase.auth().languageCode = 'en';

$(".sign-in").click(function() {
	firebase.auth().signInWithPopup(provider).then(function(result) {
	  // This gives you a Google Access Token. You can use it to access the Google API.
	  var token = result.credential.accessToken;
	  // The signed-in user info.
	  var user = result.user;
	  // ...
	}).catch(function(error) {
	  // Handle Errors here.
	  var errorCode = error.code;
	  var errorMessage = error.message;
	  // The email of the user's account used.
	  var email = error.email;
	  // The firebase.auth.AuthCredential type that was used.
	  var credential = error.credential;
	  // ...
	});					
});

var rootRef = firebase.database().ref().child('users');

firebase.auth().onAuthStateChanged(function(user) {
  if (user) {
    // User is signed in.
	  var displayName = user.displayName;
	  document.getElementById("yeetyeet").innerHTML = displayName;
	  if (location.href.split(location.host)[1] !== "/dashboard.html"){
		  rootRef.set({
			  name:user.displayName,
			  username:user.displayName,
			  location: "Richardson, TX",
			  bio:"lfucksdaf"
		  });
	  	  window.location.href = "dashboard.html";
	  }

  } else {
    // No user is signed in.
	  if (location.href.split(location.host)[1] === "/dashboard.html"){
	  	  window.location.href = "index.html";
	  }
  }
});
































function animateWithRandomNumber(myClass, from, to) {
	TweenLite.fromTo(myClass, Math.floor(Math.random() * 20 + 1), { y: from }, { y: to,
																				onComplete: animateWithRandomNumber,
																				onCompleteParams: [myClass, from, to],
																				ease: Linear.easeNone });
}

var itemsDown = [".light4", ".light5", ".light6", ".light7", ".light8", ".light11", ".light12", ".light13", ".light14", ".light15", ".light16"].forEach(function (e) {
	return animateWithRandomNumber(e, -1080, 1080);
});
var itemsUp = [".light1", ".light2", ".light3", ".light9", ".light10", ".light17"].forEach(function (e) {
	return animateWithRandomNumber(e, 1080, -1080);
});


// Bouncing arrow bottom of full screen
// Different arrow choices from Font Awesome
// Fades away as you scroll down

$(window).scroll(function(){
	$(".arrow").css("opacity", 1 - $(window).scrollTop() / 250); 
	//250 is fade pixels
});


jQuery(document).ready(function(){
  $(window).scroll(function(e){
  	parallaxScroll();
	});
	 
	function parallaxScroll(){
		var scrolled = $(window).scrollTop();
		$('#contact').css('top',(0-(scrolled*.25))+'px');
	}
 
 }); 