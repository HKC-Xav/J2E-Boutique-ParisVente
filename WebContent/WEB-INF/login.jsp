<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<%@ include file="layouts/header.jsp" %>
<body>
	<section>
	<form action="login" method="POST">
	<label for="email">Email </label><input type="text" id="mail" name="email" placeholder="nom@gmail.com"> <br>
	<label for="pass">Mot de passe </label><input type="password" id="password" name="pass" placeholder = "Mot de passe"> <br>
	<input type="submit" value="Enregistrer">
	</form>
	</section>
</body>
	<%@ include file="layouts/footer.jsp" %>
</html>