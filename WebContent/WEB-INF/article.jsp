<%@ include file="layouts/header.jsp"%>
<body>
		<article>
			<h4>${html.title}</h4>
			<figure>
				<a href=#>
					<img src=".${html.linkimg}" alt="">
				</a>
				<figcaption>${html.description}</figcaption>
			</figure>
			<span>${html.price}€</span>
		</article>

</body>
<%@ include file="layouts/footer.jsp"%>
</html>