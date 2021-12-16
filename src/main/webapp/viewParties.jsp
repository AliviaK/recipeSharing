<section>
    <h4 class="ms-2 p-2">My Hosted Parties:</h4>
    <ul class="col-12 p-2">
        <form action="/view-party" method="get">
            <div>
                <c:forEach var="party" items="${user.partiesHosting}">
                    <li>
                        <button type="submit" class="blueButton" name="submit" value="${party.id}">
                            Party with ${party.recipe.name}
                        </button>
                    </li>
                </c:forEach>
            </div>
        </form>
    </ul>
</section>

