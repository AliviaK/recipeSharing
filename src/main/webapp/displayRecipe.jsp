<%@include file="taglib.jsp"%>
<%@include file="head.jsp"%>

<header>
    <h1>${recipe.name} </h1>
    <h4>By Author: ${recipe.user.userName}</h4>
</header>

<div class="row">
    <div class="col-12">
        <h3>Ingredients: </h3>
        <ul>
            <c:forEach var="ingredient" items="${recipe.recipeIngredients}">
                <li>${ingredient.amount} ${ingredient.ingredient}</li>
            </c:forEach>
        </ul>

        <h3>Steps:</h3>
        <ul>
            <c:forEach var="step" items="${recipe.recipeSteps}">
                <li>${step.orderNumber} . ${step.direction}</li>
            </c:forEach>
        </ul>
    </div>

    <div class="col-12">
        <c:if test="${!empty userName}">
            <form action="/create-party" method="get">
                <div>
                    <button type="submit" class="blueButton" name="submit" value="${recipe.name}">
                            Create Party With This Recipe
                    </button>
                </div>
            </form>
        </c:if>
    </div>
</div>

<%@include file="footer.jsp"%>