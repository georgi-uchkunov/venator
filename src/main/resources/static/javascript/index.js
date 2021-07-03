const tl = gsap.timeline({
	defaults: {
		ease: "power1.out"
	}
});

tl.to(".text", {
	y: "0%",
	duration: 1,
	stagger: 0.25
});
tl.to(".slider", {
	y: "-100%",
	duration: 1.5,
	delay: 0.5
});
tl.to(".intro", {
	y: "-92%",
	duration: 1
}, "-=1");
tl.fromTo("nav", {
	opacity: 0
}, {
	opacity: 1,
	duration: 1
});
tl.fromTo(".big-text", {
	opacity: 0
}, {
	opacity: 1,
	duration: 1
}, "-=1");
tl.fromTo(".big-text-two", {
	opacity: 0
}, {
	opacity: 1,
	duration: 1
}, "-=1");
tl.fromTo(".focus-images-box", {
	opacity: 0
}, {
	opacity: 1,
	duration: 1
}, "-=1");
tl.fromTo(".reservation-row", {
	opacity : 0
}, {
	opacity : 1,
	duration : 1
}, "-=1");
tl.fromTo(".swiper-container", {
	opacity: 0
}, {
	opacity: 1,
	duration: 1
});
tl.fromTo(".testimonials-container", {
	opacity: 0
}, {
	opacity: 1,
	duration: 1
});

$(document).ready(function () {
	$("a").on('click', function (event) {
		if (this.hash !== "") {
			event.preventDefault();
			var hash = this.hash;
			$('html, body').animate({
				scrollTop: $(hash).offset().top
			}, 800, function () {
				window.location.hash = hash;
			});
		}
	});
});

AOS.init({
	duration: 2300,
})


$("#focus-image-one").hover(
	function () {
		$("#focus-title-one").css({
			'color': 'white',
			'opacity': '1',
			'border-bottom': '4px solid white',
			'transition': '0.5s',
			'display': 'inline-block',
			'position': 'absolute',
			'top': '127%',
			'left': '41%',
			'-webkit-text-stroke': '0.5px #1a1a1a'
		});
	},
	function(){
		$("#focus-title-one").css({
			'color': 'white',
			'opacity': '0',
			'border-bottom': '4px solid white',
			'transition': '0.5s',
			'display': 'inline-block',
			'position': 'absolute',
			'top': '127%',
			'left': '41%',
			'-webkit-text-stroke': '0.5px #1a1a1a'
		});
	});

$("#focus-image-two").hover(
	function () {
		$("#focus-title-two").css({
			'color': 'white',
			'opacity': '1',
			'border-bottom': '4px solid white',
			'transition': '0.5s',
			'display': 'inline-block',
			'position': 'absolute',
			'top': '127%',
			'left': '38%',
			'-webkit-text-stroke': '0.5px #1a1a1a'
		});
	},
	function(){
		$("#focus-title-two").css({
			'color': 'white',
			'opacity': '0',
			'border-bottom': '4px solid white',
			'transition': '0.5s',
			'display': 'inline-block',
			'position': 'absolute',
			'top': '127%',
			'left': '38%',
			'-webkit-text-stroke': '0.5px #1a1a1a'
		});
	});

$("#focus-image-three").hover(
	function () {
		$("#focus-title-three").css({
			'color': 'white',
			'opacity': '1',
			'border-bottom': '4px solid white',
			'transition': '0.5s',
			'display': 'inline-block',
			'position': 'absolute',
			'top': '127%',
			'left': '35%',
			'-webkit-text-stroke': '0.5px #1a1a1a'
		});
	},
	function(){
		$("#focus-title-three").css({
			'color': 'white',
			'opacity': '0',
			'border-bottom': '4px solid white',
			'transition': '0.5s',
			'display': 'inline-block',
			'position': 'absolute',
			'top': '127%',
			'left': '35%',
			'-webkit-text-stroke': '0.5px #1a1a1a'
		});
	});

$("#focus-image-four").hover(
	function () {
		$("#focus-title-four").css({
			'color': 'white',
			'opacity': '1',
			'border-bottom': '4px solid white',
			'transition': '0.5s',
			'display': 'inline-block',
			'position': 'absolute',
			'top': '127%',
			'left': '32%',
			'-webkit-text-stroke': '0.5px #1a1a1a'
		});
	},
	function(){
		$("#focus-title-four").css({
			'color': 'white',
			'opacity': '0',
			'border-bottom': '4px solid white',
			'transition': '0.5s',
			'display': 'inline-block',
			'position': 'absolute',
			'top': '127%',
			'left': '32%',
			'-webkit-text-stroke': '0.5px #1a1a1a'
		});
	});

var swiper = new Swiper('.swiper-container', {
	effect: 'coverflow',
	grabCursor: true,
	centeredSlides: true,
	slidesPerView: 'auto',
	coverflowEffect: {
		rotate: 20,
		stretch: 0,
		depth: 200,
		modifier: 1,
		slideShadows: true,
	},
	loop: true
});

var swiperTestimonials = new Swiper('.testimonials-container', {
	effect: 'coverflow',
	grabCursor: true,
	centeredSlides: true,
	slidesPerView: 'auto',
	coverflowEffect: {
		rotate: 20,
		stretch: 0,
		depth: 100,
		modifier: 1,
		slideShadows: true,
	},
	initialSlide: 3,
});

$('.modal.draggable>.modal-dialog').draggable({
	cursor : 'move',
	handle : '.modal-header'
});

$('.modal.draggable>.modal-dialog>.modal-content>.modal-header').css(
		'cursor', 'move');

$("#name").on('change', function () {
	var $name = $("#name");
	var $nameFeedback = $("#name-feedback");
	var name = $name.val();
	if (name.length > 3 && name != 'name') {
		$name[0].classList.remove('is-invalid');
		$name[0].classList.add('is-valid');
		$nameFeedback[0].css({
			'display': 'none'
		})
	} else {
		$name[0].classList.remove('is-valid');
		$name[0].classList.add('is-invalid');
		$nameFeedback[0].css({
			'display': 'block'
		})

	}
})

$("#email").on('change', function () {
	var $email = $("#email");
	var $emailFeedback = $("#email-feedback");
	var email = $email.val();
	var validation = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/g;
	if (validation.test(email)) {
		$email[0].classList.remove('is-invalid');
		$email[0].classList.add('is-valid');
		$emailFeedback[0].css({
			'display': 'none'
		})
	} else {
		$email[0].classList.remove('is-valid');
		$email[0].classList.add('is-invalid');
		$emailFeedback[0].css({
			'display': 'block'
		})
	}
})

$("#comment").on('change', function () {
	var $comment = $("#comment");
	var $commentFeedback = $("#comment-feedback");
	var comment = $comment.val();
	if (comment.length > 3 && comment.length < 255) {
		$comment[0].classList.remove('is-invalid');
		$comment[0].classList.add('is-valid');
		$commentFeedback[0].css({
			'display': 'none'
		})
	} else {
		$comment[0].classList.remove('is-valid');
		$comment[0].classList.add('is-invalid');
		$commentFeedback[0].css({
			'display': 'block'
		})
	}
	
	$("close").on("click", function () {
		event.preventDefault()
	})
})