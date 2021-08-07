$(function () {

	$("#reservation-number").on('change', function () {
		var $reservationNumber = $("#reservation-number");
		var $reservationNumberFeedback = $("#reservation-number-feedback");
        var reservationNumber = $reservationNumber.val();
        var validation = /^[a-z0-9]+$/;
		if (validation.test(reservationNumber) && reservationNumber.length == 6) {
			$reservationNumber[0].classList.remove('is-invalid');
			$reservationNumber[0].classList.add('is-valid');
			$reservationNumberFeedback[0].css({
				'display': 'none'
			})
		} else {
			$reservationNumber[0].classList.remove('is-valid');
			$reservationNumber[0].classList.add('is-invalid');
			$reservationNumberFeedback[0].css({
				'display': 'block'
			})
		}
	})

    $("#search-button").on("click", function () {

		reservationNumberValidation();

	})

    var reservationNumberValidation = function(){

        var $reservationNumber = $("#reservation-number");
        var reservationNumberStatus = $reservationNumber[0].classList[2];

        if(reservationNumberStatus == "is-valid"){
            $("#editReservationModal").modal("hide");
            getReservation();
        } else{
            $("#editReservationModal").modal("hide");
        }
    }

    var getReservation = function(){

        var id = $("#reservation-number").val();

        $.ajax({
			method: "GET",
			url: "v1/booking/get_selected_booking_by_id",
			data: {
				id : id
            }
		}).done(function (response) {
			setTimeout(function () {
				$("#editReservationModal").modal("hide");
				showReservation(response, id);
			}, 800);
			console.log(response);
		});
    }
    
    var showReservation = function(response, id){
    	
    	$(".reservation-number").text(id);
    	$(".reservation-check-in").text(response.checkInDate);
    	$(".reservation-check-out").text(response.checkOutDate);
    	$(".reservation-adults").text(response.adults);
    	$(".reservation-children").text(response.children);
    	$(".reservation-rooms").text(response.rooms);
    	$(".reservation-service-package").text(response.servicePackage);
    	$(".reservation-first-name").text(response.customerFirstName);
    	$(".reservation-last-name").text(response.customerLastName);
    	$(".reservation-location").text(response.location);
    	
    	$("#successful-search-modal").modal("show");
    	
    }
    
    var getAllBookings = function(){
    	
    	$.ajax({
			method: "GET",
			url: "v1/booking/get_all_bookings"
		}).done(function (response) {
		});
    }

	

	

	
})