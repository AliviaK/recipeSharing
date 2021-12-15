<%@include file="head.jsp"%>

<header>
    <h1>Profile Information:</h1>
</header>

<div class="row">
    <h3 class="col-12">My Recipes</h3>
    <ul class="col-12">
        <c:forEach var="recipe" items="${user.recipes}">
            <li>${recipe.id} ${recipe.name}</li>
        </c:forEach>
    </ul>
</div>

<div class="row">
    <h3 class="col-12">My Hosted Parties</h3>
    <ul class="col-12">
        <c:forEach var="party" items="${user.partiesHosting}">
            <li>${party.id} ${party.details}</li>
        </c:forEach>
    </ul>
</div>

<%@include file="footer.jsp"%>