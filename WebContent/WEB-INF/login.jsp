<%@ include file="layouts/header.jsp"%>
<body>
	<section>
	<c:out value="${sessionScope.isLog}">Pas log</c:out>
	<c:if test="${sessionScope.isLog}">${sessionScope.email}
	</c:if>
		<form action="login" method="POST">
			<label for="email">Email </label>
			<input type="text" id="mail" name="email" placeholder="nom@gmail.com">
			<br>
			<label for="pass">Mot de passe </label>
			<input type="password" id="password" name="pass"
				placeholder="Mot de passe"> <br> <input type="submit"
				value="Enregistrer"><br>
		</form>
		<form action="login" method="POST">
		<input type="hidden" name="delog" value="true">
		<input type="submit" Value="Déconnexion">
		</form>
		
	</section>
</body>
<%@ include file="layouts/footer.jsp"%>
</html>