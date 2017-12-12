<%@ include file="layouts/header.jsp"%>
<body>
	<c:forEach var="i" items="${html}">
	<article>
		<h4>${i.title}</h4>
		<figure>
			<a href="/ParisVente/article?id=${i.id}">
				<img src=".${i.linkimg}" alt="">
			</a>
			<figcaption>${i.description}</figcaption>
		</figure>
		<span>${i.price}€</span>
	</article>
	</c:forEach>
</body>
<%@ include file="layouts/footer.jsp"%>
</html>