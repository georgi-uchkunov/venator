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
            //getAllBookings();
        } else{
            $("#editReservationModal").modal("hide");
        }
    }

    var getReservation = function(){

        var id = $("#reservation-number").val();

        $.ajax({
			method: "GET",
			url: "getSelectedBookingById",
			data: {
				id : id
            }
		}).done(function (response) {
			setTimeout(function () {
				$("#editReservationModal").modal("hide");
				
			}, 800);
			console.log(response);
			console.log(1);
		});
    }
    
    var getAllBookings = function(){
    	
    	$.ajax({
			method: "GET",
			url: "getAllBookings",
		}).done(function (response) {
			console.log(response);
			console.log(2);
		});
    }

	

	

	
})