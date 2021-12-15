<%@include file="taglib.jsp"%>
<%@include file="head.jsp"%>

<header>
    <h1>${recipe.name} </h1>
</header>

<div class="row">
    <div class="col-12">
        <p>Ingredients: </p>
        <ul>
            <c:forEach var="ingredient" items="${recipe.recipeIngredients}">
                <li>${ingredient.amount} ${ingredient.ingredient}</li>
            </c:forEach>
        </ul>

        <p>Steps:</p>
        <ul>
            <c:forEach var="step" items="${recipe.recipeSteps}">
                <li>${step.orderNumber} . ${step.direction}</li>
            </c:forEach>
        </ul>
    </div>

</div>

<%@include file="footer.jsp"%>