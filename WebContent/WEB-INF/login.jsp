<%@ include file="layouts/header.jsp"%>
<body>
	<section>
		<form action="login" method="POST">
			<label for="email">Email </label>
			<input type="text" id="mail" name="email" placeholder="nom@gmail.com"> <br>
			<label for="pass">Mot de passe </label>
			<input type="password" id="password" name="pass" placeholder="Mot de passe"> <br>
			<input type="submit" value="Connecter"><br>
			<a href="/ParisVente/logout">D�connecter</a>
		</form>
		<c:if test="${isLog}"> Connect� en tant que ${user.firstname} ${user.lastname}
		</c:if>
	</section>
</body>
<%@ include file="layouts/footer.jsp"%>
</html>