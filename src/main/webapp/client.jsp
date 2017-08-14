<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>多人聊天室</title>
</head>
<body>
<h1>欢迎来到本聊天室 - enjoy</h1> <br/>
昵称：<input type="text" id="nick"> <br>
你说：<input type="text" id="context">
<input id="send" type="button" value="发送" >
<input id="disconn" type="button" value="断开连接" onclick="disconn()" >
<hr/>
<div id="msg" ></div>
</body>
<script type="text/javascript">
	var ws = new WebSocket("ws://localhost:8080/wserver");
	ws.onopen = function(e) {
		showToDiv("连接服务器成功...");
	} 
	
	//接收到消息的回调方法  
    ws.onmessage = function (event) {  
    	showToDiv(event.data);  
    }  
	
    //连接关闭的回调方法  
    ws.onclose = function () {  
    	showToDiv("WebSocket连接关闭");  
    }  
    //连接发生错误的回调方法  
    ws.onerror = function () {  
        setMessageInnerHTML("WebSocket连接发生错误");  
    };  
  
	function showToDiv(str) {
		var inn = document.createElement("p");
		inn.innerHTML = str;
		msgDiv = document.getElementById("msg");
		msgDiv.appendChild(inn);
	}
	
	document.getElementById("send").onclick = function() {
		var nickname = document.getElementById("nick").value;
		var txt = document.getElementById("context").value ;
		showToDiv("我说：" + txt);
		ws.send(nickname + ":" + txt);  // 发送给ws服务器
		document.getElementById("context").value = "";
	}
	
	function disconn() {
		ws.close();
	}
</script>
</html>