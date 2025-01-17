<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>



<fmt:formatNumber value="12345.6789" />
<!-- 結果: 12,345.679 -->

<br>

<fmt:formatNumber value="12345.6789" type="currency" />
<!-- 結果: $12,345.68 （ロケールに基づく） -->

<br>

<!-- アメリカドル（USD）の表示 -->
    <fmt:setLocale value="en_US" />
    <p>
        USD 表示: 
        <fmt:formatNumber value="12345.6789" type="currency" />
    </p>
    <!-- 結果: $12,345.68 -->

    <!-- 日本円（JPY）の表示 -->
    <fmt:setLocale value="ja_JP" />
    <p>
        JPY 表示: 
        <fmt:formatNumber value="12345.6789" type="currency" />
    </p>
    <!-- 結果: ￥12,346 -->

    <!-- ユーロ（EUR）の表示 -->
    <fmt:setLocale value="de_DE" />
    <p>
        EUR 表示: 
        <fmt:formatNumber value="12345.6789" type="currency" />
    </p>
    <!-- 結果: 12.345,68 € -->

<fmt:formatNumber value="0.875" type="percent" />

<br>
<!-- 結果: 87% -->

<fmt:formatNumber value="12345.6789" maxFractionDigits="2" />

<br>
<!-- 結果: 12,345.68 -->

<fmt:formatNumber value="12345.6789" var="formattedValue" />
<p>フォーマットされた値: ${formattedValue}</p>

<br>



<%
    // 現在の日時を設定
    java.util.Date now = new java.util.Date();
    request.setAttribute("now", now);
%>

<fmt:formatDate value="${now}" />
<!-- 結果: 2024/12/23（ロケールによる） -->

<br>

<fmt:formatDate value="${now}" type="both" />
<!-- 結果: 2024/12/23 10:30:45（ロケールによる） -->

<br>

<fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="short" />
<!-- 結果: 2024年12月23日 月曜日 10:30 -->

<br>

<fmt:formatDate value="${now}" pattern="yyyy-MM-dd HH:mm:ss" />
<!-- 結果: 2024-12-23 10:30:45 -->

<br>

<fmt:formatDate value="${now}" type="both" timeZone="Asia/Tokyo" />
<!-- 結果: タイムゾーンに基づいた日付と時刻 -->

<br>

<fmt:formatDate value="${now}" pattern="yyyy-MM-dd" var="formattedDate" />
<p>フォーマットされた日付: ${formattedDate}</p>

<br>


<c:if test="${fn:contains('hello world', 'world')}">
    <p>含まれています。</p>
</c:if>

<p>文字列の長さ: ${fn:length('abcdef')}</p>

<p>置換後の文字列: ${fn:replace('hello world', 'world', 'JSTL')}</p>

<p>切り出し: ${fn:substring('abcdef', 1, 4)}</p>

<%
String[] fruits = {"りんご", "みかん", "バナナ"};
pageContext.setAttribute("fruits", fruits);
%>

${fn:join(fruits, '、')}


<%@include file="../footer.html" %>
