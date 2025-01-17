<%@page cotentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<p>検索キーワードを入力してください。</p>
<!-- このフォームの転送先は「P_SearchAction」とする -->
<form action="P_Search.action" method="post">
<input type="text" name="keyword>">
<input type="submit" value="検索">
</form>

<%@include file="../footer.jsp"%>