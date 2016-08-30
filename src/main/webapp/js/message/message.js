var base = "http://" + window.location.host + "/M1";
var message;
avalon.ready(function() {
	message= avalon.define({
		$id : "message",
		messageList : [], //消息集合
		message : {
			id : '', //编号
			message : '', //消息
			time : '' //时间
		}
	});
	initMessage();
	avalon.scan();
});
function initMessage() {
	$.post(base + "/message/getAllMessage.json", function(data) {
		var result=jQuery.parseJSON(data);
		if (result.success) {
			message.messageList = result.results;
		} else {
			alert(data.message);
		}
	});
}