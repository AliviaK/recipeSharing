<%@include file="head.jsp"%>

<section>
    <h3>Party with ${party.recipe.name}!</h3>
    <h4>Hosted by: ${party.user.userName} </h4>
    <div class="row align-items-center">
        <div class="col-10 p-2 m-2">
            <p>${party.user.userName} says: ${party.details}</p>
        </div>
    </div>
</section>

<article>
    <div class="row p-2 m-2">
        <div class="col-12">
            <p class="fw-bold pb-2">${party.recipe.name}</p>

            <section>
                <h4>Ingredients: </h4>
                <ul>
                    <c:forEach var="ingredient" items="${party.recipe.recipeIngredients}">
                        <li>${ingredient.amount} ${ingredient.ingredient}</li>
                    </c:forEach>
                </ul>
            </section>

            <section>
                <h4>Steps:</h4>
                <ul>
                    <c:forEach var="step" items="${party.recipe.recipeSteps}">
                        <li>${step.orderNumber} . ${step.direction}</li>
                    </c:forEach>
                </ul>
            </section>
        </div>
    </div>
</article>


<%@include file="footer.jsp"%>
