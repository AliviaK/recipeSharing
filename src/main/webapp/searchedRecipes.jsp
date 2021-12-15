<%@include file="taglib.jsp"%>
<%@include file="head.jsp"%>

<header>
    <h1>Search Results: </h1>
</header>

<div class="row">
    <table class="table">
        <thead>
        <th>Name</th>
        <th>Ingredients</th>
        <th>Directions</th>
        </thead>
        <tbody>
        <c:forEach var="recipe" items="${recipes}">
            <tr>
                <td>${recipe.name}</td>
                <td>
                    <c:forEach var="ingredient" items="${recipe.recipeIngredients}">
                        ${ingredient.amount} ${ingredient.ingredient}
                    </c:forEach>
                </td>
                <td>
                    <c:forEach var="step" items="${recipe.recipeSteps}">
                        ${step.orderNumber}. ${step.direction}
                    </c:forEach>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<%@include file="footer.jsp"%>
