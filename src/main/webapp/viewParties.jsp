<%@include file="head.jsp"%>

<section>
    <h2>Your Hosted Parties:</h2>
    <div>
        <h3>Upcoming:</h3>
        <ul>
            <li>Party Name (in foreach) button</li>
        </ul>
    </div>
    <div>
        <h3>Past:</h3>
        <ul>
            <li>Party Name (in foreach)</li>
        </ul>
    </div>
</section>

<section>
    <h2>Your Attended Parties:</h2>
    <div>
        <h3>Upcoming:</h3>
        <ul>
            <li>Party Name (in foreach)</li>
        </ul>
    </div>
    <div>
        <h3>Past:</h3>
        <ul>
            <li>Party Name (in foreach)</li>
        </ul>
    </div>
</section>

<p>${emailSent}</p>
<c:remove var="emailSent" scope="session" />

<%@include file="sendPartyInvite.jsp"%>

<%@include file="footer.jsp"%>
