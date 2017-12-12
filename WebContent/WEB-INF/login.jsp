<%@ include file="layouts/header.jsp"%>
<body>
	<section>
		<form action="login" method="POST">
			<input type="number" id="age" name="age" placeholder="Age">
			<c:choose>
				<c:when test="${age eq null}">Erreur</c:when>
				<c:when test="${age lt 10}">Enfant</c:when>
				<c:when test="${age lt 18}">Ado</c:when>
				<c:when test="${age lt 65}">Adulte</c:when>
				<c:otherwise>Retraité</c:otherwise>
			</c:choose>
			<br>
			<label for="email">Email </label>
			<input type="text" id="mail" name="email" placeholder="nom@gmail.com">
			<br>
			<label for="pass">Mot de passe </label>
			<input type="password" id="password" name="pass"
				placeholder="Mot de passe"> <br> <input type="submit"
				value="Enregistrer"><br>
				<c:forEach var="i" begin="0" end="10" step="1">${i}<br></c:forEach>
				<c:forEach var="nom" items="${requestScope['str']}"> ${nom}</c:forEach>
		</form>
	</section>
</body>
<%@ include file="layouts/footer.jsp"%>
</html>