$(function(){
	$("#msg").ajaxStart(function(){
		$(this).show();
	})

	$("#msg").ajaxStop(function(){
		$(this).html("ok....").hide();
	})

	$("#button").click(function(){
		var $name = $("#txtName"); //用户名
        var $pass = $("#txtPass"); //密码
        if ($name.val() != "" && $pass.val() != "") {
            UserLogin($name.val(), $pass.val());
        }
        else {
            if ($name.val() == "") {
                alert("用户名不能为空!");
                $name.focus();
                return false;
            } else {
                alert("密码不能为空!");
                $pass.focus();
                return false;
            }
        }
	})
});

function UserLogin(name,pass){
	$.ajax({
		type: "POST",
		url: "DealData.aspx",
		data: "action=Login&d=" + new Date() + "&name=" + name + "&pass=" + pass,
		success: function(data){
			if (data == "True") {
                window.location = "ChatMain.html";
            }
            else {
                alert("用户名或密码错误!");
                return false;
            }
		}
	});

}