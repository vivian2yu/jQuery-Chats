$(function(){
	$("#divMsg").ajaxStart(function(){
		$(this).show();
	});
	
	$("#divMsg").ajaxStop(function(){
		$(this).html("Done").hide();
	});
	
	InitFace();
	GetMessageList();
	GetOnlineList();
	
	$("#button").click(function(){
		var $content = $("#txtContent");
		if($content.val()!=""){
			SendMessage($content.val());
		}else{
			alert("发送内容不能为空！");
			$content.focus();
			return false;
		}
	});
	
	$("table tr td img").click(function(){
		var strContent = $("#divContent").val() + "<:" + this.id + ":>";
		$("#divContent").val(strContent);
	});
});

function InitFace(){
	var strHtml = "";
	for(var i = 1;i<11;i++){
		strHtml += "<img src='face/" + i + ".gif' id='"+ i +"'/>";
	}
	$("#divFace").html(strHtml);
}

function GetMessageList(){
	$.ajax({
		type: "POST",
		url: "Main",
		data: "action=chatList&date=" + new Date(),
		success: function(data){
			$("#divContent").html(data);
		}
		
	});
}

function GetOnlineList(){
	$.ajax({
		type: "POST",
		url: "Main",
		data: "action=onlineList&date=" + new Date(),
		success: function(data){
			$("#divOnline").html(data);
		}
	});
}
function SendMessage(content){
	$.ajax({
		type: "POST",
		url: "Main",
		data: "action=sendContent&date=" + new Date(),
		success: function(data){
			if(data == "true"){
				GetMessageList();
				$("#txtContent").val("");
			}else{
				alert("发送失败！");
				return false;
			}
		}
	});
}