<%@page cotentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<%-- リストの出力。JSTLの<c:forEach>タグを使って、リクエスト属性に保存されたリストを処理し、商品Beanのプロパティを取得 --%>
<c:forEach var="p" items="${list}">
	${p.id}:${p.name}:{p.price}<br>
</c:forEach>

<%@include file="../hooter.html" %>