<h3>
    <h1>Search Results: </h1>
</h3>

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
