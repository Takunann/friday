<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<p>検索キーワードを入力してください。</p>
<form action="search2" method="post" id="searchForm">
	<input type="text" name="keyword" id="keyword">
	<select type="text" name="keyword" id="keyword">
		<option value="100-200">100-200円</option>
		<option value="201-300">201-300円</option>
		<option value="301-400">301-400円</option>
		<option value="400-10000">401円～</option>
	</select>
	<input type="submit" value="検索">
</form>

<script>
document.getElementById('searchForm').addEventListener('submit',function(event){
	var keyword = document.getElementById('keyword').value;
	if (keyword.trim().length > 10) {
		alert('キーワードは10文字以内で入力してください。');
		event.preventDefault();
	}
});
</script>

<%@include file="../footer.html" %>
