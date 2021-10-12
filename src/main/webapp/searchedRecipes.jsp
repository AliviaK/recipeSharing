<%@include file="taglib.jsp"%>
<%@include file="head.jsp"%>

<html><body>

<div class="container-fluid">
    <h2>Search Results: </h2>
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
                        ${step.orderNumber}. ${step.direction};
                    </c:forEach>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
