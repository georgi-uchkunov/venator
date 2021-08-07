$(function () {

	$("#submit-comment").on("click", function () {
		var $name = $("#name")
        var nameStatus = $name[0].classList[2];
        var $email = $("#email")
        var emailStatus = $email[0].classList[2];
        var $comment = $("#comment")
        var commentStatus = $comment[0].classList[3];
        
		if(nameStatus == "is-valid" && emailStatus == "is-valid" && commentStatus == "is-valid"){
			submitComment();
		}
		
	})
	
	var submitComment = function(){
		var email = $("#email").val();
		var name = $("#name").val();
		var comment = $("#comment").val();
		console.log(email);

		$.ajax({
			method : "POST",
			url : "v1/comment/post_comment",
			data : {

				commenterEmail : email,
				commenterName : name,
				commenterComment : comment
			}
		}).done(function(response) {
			console.log(response)
			$("#successful-feedback-modal").modal("show");
			$("#email").val("");
			$("#name").val("");
			$("#comment").val("");
		});
	}

	

	
})