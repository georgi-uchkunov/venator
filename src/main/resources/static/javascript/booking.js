$(function(){
			
			
	$("#submit-button").on("click", function() {

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

	        console.log(checkInDateReceived, checkOutDateReceived, adults, children, rooms, customerFirstName, customerLastName, customerEmail, customerPhoneNumber, servicePackage, location, nameCard, numberCard);
	        
	        $.ajax({
				method : "POST",
				url : "createBooking",
				data : {
					checkInDateReceived : checkInDateReceived,
					checkOutDateReceived : checkOutDateReceived,
					adults : adults,
					children : children,
					rooms : rooms,
					customerFirstName : customerFirstName,
					customerLastName : customerLastName,
					customerEmail : customerEmail,
					customerPhoneNumber : customerPhoneNumber,
					servicePackage : servicePackage,
					location : location,
					nameCard : nameCard,
					numberCard : numberCard
					
				}
			}).done(function(response) {
				
				console.log(response);
			});
	
	})
})
