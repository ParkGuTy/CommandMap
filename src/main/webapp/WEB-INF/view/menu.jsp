<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
			<div id="hmenu">
				<img src="./img/menu.png">
			</div>
			<div id="menu">
				<div id="menuitem" onclick="location.href='./index.do'">인덱스</div>
				<div id="menuitem" onclick="location.href='./main.do'">메인</div>
				<div id="menuitem" onclick="location.href='./login.do'">게시판3</div>
				<div id="menuitem" onclick="location.href='./corona.do'">코로나</div>
				<div id="menuitem" onclick="location.href='./corona4.do'">코로나4</div>
				<div id="menuitem" onclick="location.href='./board2.do'">보드2</div>
				<div id="menuitem" onclick="location.href='./board.do'">보드</div>
			</div>
			<div id="mobileMenu">
				<div id="menuitem" onclick="location.href='./index.do'">인덱스</div>
				<div id="menuitem" onclick="location.href='./main.do'">메인</div>
				<div id="menuitem" onclick="location.href='./login.do'">게시판3</div>
				<div id="menuitem" onclick="location.href='./corona.do'">코로나</div>
				<div id="menuitem" onclick="location.href='./corona4.do'">코로나4</div>
				<div id="menuitem" onclick="location.href='./board2.do'">보드2</div>
				<div id="menuitem" onclick="location.href='./board.do'">보드</div>
			</div>
<script type="text/javascript">
$(document).ready(function(){
	$("#mobileMenu").hide();
	$("#hmenu").on("click", function(){
		$("#mobileMenu").slideToggle(500);
	});
});
</script>