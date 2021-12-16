<%@include file="head.jsp"%>

<header>
    <h2>Profile Information:</h2>
</header>
<div>
    <p>My Name: ${user.firstName}</p>
    <p>My Username: ${user.userName}</p>
</div>
<div class="row p-1">
    <h4 class="ms-2 p-2">My Recipes</h4>
    <form action="/display-recipe-details" method="get">
        <ul class="col-12 p-1">
            <c:forEach var="recipe" items="${user.recipes}">
                <li>
                    <button type="submit" class="purpleButton text-white" name="submit" value="${recipe.name}">
                        ${recipe.name}
                    </button>
                </li>
            </c:forEach>
        </ul>
    </form>

    <div class="row p-1">
        <div class="col-4 ms-2 p-2">
            <a href="addRecipe.jsp" class="blueButton text-black text-decoration-none p-1 m-2">Add Recipe</a>
        </div>
    </div>
</div>

<%@include file="viewParties.jsp"%>

<%@include file="footer.jsp"%>