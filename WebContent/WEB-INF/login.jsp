<%@ include file="layouts/header.jsp"%>
<body>
	<section>
		<form action="login" method="POST">
			<label for="email">Email </label>
			<input type="text" id="mail" name="email" placeholder="nom@gmail.com"> <br>
			<label for="pass">Mot de passe </label>
			<input type="password" id="password" name="pass" placeholder="Mot de passe"> <br>
			<input type="submit" value="Connecter"><br>
		</form>
		<c:if test="${isLog}"> Connecté en tant que ${user.firstname} ${user.lastname} <a href="/ParisVente/logout">Déconnecter</a>
		</c:if>
	</section>
</body>
<%@ include file="layouts/footer.jsp"%>
</html>