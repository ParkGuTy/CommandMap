<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>corona4</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
<link href="./css/style.css" rel="stylesheet">
</head>
<body>
	<div id="container">
		<header></header>
		<nav>
			<c:import url="menu.jsp"/>
		</nav>
		<main>
			<h1>corona4</h1>
	
			<table>
				<tr>
					<td>seq</td>
					<td>stateTime</td>
					<td>deathCnt</td>
					<td>decideCnt</td>
					<td>stateDt</td>
					<td>updateDt</td>
					<td>createDt</td>
				</tr>
				<c:forEach items="${coronaList }" var="c">
				<tr>
					<td>${c.seq}</td>
					<td>${c.stateDt}</td>
					<td>${c.stateTime}</td>
					<td>${c.deathCnt}</td>
					<td>${c.decideCnt}</td>
					<td>${c.createDt}</td>
					<td>${c.updateDt}</td>
				</tr>
				</c:forEach>
			</table>
		</main>
		<footer></footer>
	</div>
</body>
</html>