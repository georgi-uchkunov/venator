$(function () {


	$("#submit-button").on("click", function () {

		clientValidation();

	})

	var clientValidation = function () {
		var $givenName = $("#given-name");
		var $familyName = $("#family-name");
		var $email = $("#reservation-email");
		var $phoneNumber = $("#phone-number");
		var $nameCard = $("#name-card");
		var $cardNumber = $("#card-number");

		var givenNameStatus = $givenName[0].classList[2];
		var familyNameStatus = $familyName[0].classList[2];
		var emailStatus = $email[0].classList[2];
		var phoneNumberStatus = $phoneNumber[0].classList[2];
		var nameCardStatus = $nameCard[0].classList[2];
		var cardNumberStatus = $cardNumber[0].classList[2];

		var checkInDateReceived = $("#checkin-date").val();
		var checkOutDateReceived = $("#checkout-date").val();

		if (givenNameStatus == "is-valid" && familyNameStatus == "is-valid" && emailStatus == "is-valid" &&
			phoneNumberStatus == "is-valid" && nameCardStatus == "is-valid" && cardNumberStatus == "is-valid" && checkInDateReceived != "" && checkOutDateReceived != "") {
			createBooking();
		} else {
			$("#reservationModalOne").modal("hide");
			$("#reservationModalTwo").modal("show");
		}

	}

	$(".alert-close").on("click", function () {
		$("#reservationModalOne").modal("show");
	})

	var createBooking = function () {
		var checkInDateReceived = $("#checkin-date").val();
		var checkOutDateReceived = $("#checkout-date").val();
		var adults = $("#adult").val();
		var children = $("#children").val();
		var rooms = $("#rooms").val();

		var customerFirstName = $("#given-name").val();
		var customerLastName = $("#family-name").val();
		var customerEmail = $("#reservation-email").val();
		var countryCode = $("#country-code").val();
		var phoneNumber = $("#phone-number").val();
		var customerPhoneNumber = countryCode + phoneNumber;
		var servicePackage = $("#service-select").val();
		var location = $("#location-select").val();
		var nameCard = $("#name-card").val();
		var numberCard = $("#card-number").val();

		$.ajax({
			method: "POST",
			url: "createBooking",
			data: {
				checkInDateReceived: checkInDateReceived,
				checkOutDateReceived: checkOutDateReceived,
				adults: adults,
				children: children,
				rooms: rooms,
				customerFirstName: customerFirstName,
				customerLastName: customerLastName,
				customerEmail: customerEmail,
				customerPhoneNumber: customerPhoneNumber,
				servicePackage: servicePackage,
				location: location,
				nameCard: nameCard,
				numberCard: numberCard

			}
		}).done(function (response) {
			if(response.nameCard == nameCard){
				setTimeout(function () {
					$("#reservationModalOne").modal("hide");
					showReservationID(response);
				}, 800);
			} else {
				$("#reservationModalOne").modal("hide");
				seeReasonForDeniedBooking(location);
			}
			
		});
	}

	var showReservationID = function(response){
		var id = response.id;
		var reservationID =id.slice(id.length-6);
		$("#booking-id").text(reservationID);
		$("#reservationModalThree").modal("show");
		
	}
	
	$(".success-close").on("click", function () {

		window.location.reload();

	})
	
	var seeReasonForDeniedBooking = function(location){
		$.ajax({
			method: "POST",
			url: "seeReasonForDeniedBooking",
			data: {
				location : location
			}
		}).done(function (response) {
			$(".reservation-unavailable-message").text(response);
			$("#reservation-unavailable-modal").modal("show");
		});
	}
	
	var resetData = function(){
		$("#checkin-date").reset();
		$("#checkout-date").reset();
		$("#adult").reset();
		$("#children").reset();
		$("#rooms").reset();
		
		
		$("#given-name").reset();
		$("#family-name").reset();
		$("#reservation-email").reset();
		$("#country-code").reset();
		$("#phone-number").reset();
		$("#service-select").reset();
		$("#location-select").reset();
		$("#name-card").reset();
		$("#card-number").reset();
		
	}

	$("#given-name").on('change', function () {
		var $givenName = $("#given-name");
		var $givenNameFeedback = $("#given-name-feedback");
		var givenName = $givenName.val();
		if (givenName.length > 0 && givenName != 'name') {
			$givenName[0].classList.remove('is-invalid');
			$givenName[0].classList.add('is-valid');
			$givenNameFeedback[0].css({
				'display': 'none'
			})
		} else {
			$givenName[0].classList.remove('is-valid');
			$givenName[0].classList.add('is-invalid');
			$givenNameFeedback[0].css({
				'display': 'block'
			})

		}
	})

	$("#family-name").on('change', function () {
		var $familyName = $("#family-name");
		var $familyNameFeedback = $("#family-name-feedback");
		var familyName = $familyName.val();
		if (familyName.length > 0 && familyName != 'name') {
			$familyName[0].classList.remove('is-invalid');
			$familyName[0].classList.add('is-valid');
			$familyNameFeedback[0].css({
				'display': 'none'
			})
		} else {
			$familyName[0].classList.remove('is-valid');
			$familyName[0].classList.add('is-invalid');
			$familyNameFeedback[0].css({
				'display': 'block'
			})

		}
	})

	$("#reservation-email").on('change', function () {
		var $email = $("#reservation-email");
		var $emailFeedback = $("#reservation-email-feedback");
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

	$("#phone-number").on('change', function () {
		var $countryCode = $("#country-code");
		var $phoneNumber = $("#phone-number");
		var fullNumber = $countryCode.val() + $phoneNumber.val();
		var $phoneNumberFeedback = $("#phone-number-feedback");
		var validation = /^\d{12}$/;
		if (validation.test(fullNumber)) {
			$phoneNumber[0].classList.remove('is-invalid');
			$phoneNumber[0].classList.add('is-valid');
			$phoneNumberFeedback[0].css({
				'display': 'none'
			})
		} else {
			$phoneNumber[0].classList.remove('is-valid');
			$phoneNumber[0].classList.add('is-invalid');
			$phoneNumberFeedback[0].css({
				'display': 'block'
			})
		}
	})

	$("#name-card").on('change', function () {
		var $nameCard = $("#name-card");
		var $nameCardFeedback = $("#name-card-feedback");
		var nameCard = $nameCard.val();
		if (nameCard.length > 0 && nameCard != 'name') {
			$nameCard[0].classList.remove('is-invalid');
			$nameCard[0].classList.add('is-valid');
			$nameCardFeedback[0].css({
				'display': 'none'
			})
		} else {
			$nameCard[0].classList.remove('is-valid');
			$nameCard[0].classList.add('is-invalid');
			$nameCardFeedback[0].css({
				'display': 'block'
			})

		}
	})

	$("#card-number").on('change', function () {
		
		var $cardNumber = $("#card-number");
		var cardNumberValue = $cardNumber.val();
		var cardNumber = cardNumberValue.replace(/-|\s/g,"");
		var $cardNumberFeedback = $("#card-number-feedback");
	
		var mastercardValidation = /^5[1-5][0-9]{14}$|^2(?:2(?:2[1-9]|[3-9][0-9])|[3-6][0-9][0-9]|7(?:[01][0-9]|20))[0-9]{12}$/;
		var americanExpressValidation = /^3[47][0-9]{13}$/;
		var visaValidation = /^4[0-9]{12}(?:[0-9]{3})?$/;
		var discoverValidation = /^65[4-9][0-9]{13}|64[4-9][0-9]{13}|6011[0-9]{12}|(622(?:12[6-9]|1[3-9][0-9]|[2-8][0-9][0-9]|9[01][0-9]|92[0-5])[0-9]{10})$/;
		var maestroValidation = /^(5018|5081|5044|5020|5038|603845|6304|6759|676[1-3]|6799|6220|504834|504817|504645)[0-9]{8,15}$/;
		var jcbValidation = /^(?:2131|1800|35[0-9]{3})[0-9]{11}$/;
		var dinersClubValidation = /^3(?:0[0-5]|[68][0-9])[0-9]{11}$/;
		if (mastercardValidation.test(cardNumber) || americanExpressValidation.test(cardNumber) || visaValidation.test(cardNumber)
			|| discoverValidation.test(cardNumber) || maestroValidation.test(cardNumber) || jcbValidation.test(cardNumber)
			|| dinersClubValidation.test(cardNumber)) {
			$cardNumber[0].classList.remove('is-invalid');
			$cardNumber[0].classList.add('is-valid');
			$cardNumberFeedback[0].css({
				'display': 'none'
			})
		} else {
			$cardNumber[0].classList.remove('is-valid');
			$cardNumber[0].classList.add('is-invalid');
			$cardNumberFeedback[0].css({
				'display': 'block'
			})
		}
	})
})
