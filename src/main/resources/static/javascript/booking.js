$(function(){

    $("#submit-button").on("click", function(){

        var checkInDate = $("#checkin-date").val();
        var checkOutDate = $("#checkout-date").val();
        var adults = $("#adult").val();
        var children = $("#children").val();
        var rooms = $("#rooms").val();

        console.log(checkInDate, checkOutDate, adults, children, rooms);

    })
})
