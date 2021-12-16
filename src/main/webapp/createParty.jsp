<%@include file="head.jsp"%>

<%@include file="sendPartyInvite.jsp"%>

<p>${emailSent}</p>
<c:remove var="emailSent" scope="session" />

<%@include file="footer.jsp"%>
