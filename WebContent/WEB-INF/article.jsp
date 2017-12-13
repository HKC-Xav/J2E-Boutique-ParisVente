<%@ include file="layouts/header.jsp"%>
<body>
		<article>
			<h4><c:out value="${html.title}"></c:out></h4>
			<figure>
				<a href=#>
					<img src=".${html.linkimg}" alt="">
				</a>
				<figcaption>${html.description}</figcaption>
			</figure>
			<span><c:out value="${html.price}"></c:out> $euro; </span>
		</article>

</body>
<%@ include file="layouts/footer.jsp"%>
</html>