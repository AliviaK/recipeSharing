<h3>
    <h1>Search Results: </h1>
</h3>

<div class="row">
    <table class="table p-2">
        <thead>
        <th>Name</th>
        <th>Author</th>
        </thead>
        <tbody>
        <form action="/display-recipe-details" method="get">
            <c:forEach var="recipe" items="${recipes}">
                <tr>
                    <td>
                           <button type="submit" class="purpleButton text-white" name="submit" value="${recipe.name}">
                                   ${recipe.name} </button>
                    </td>
                    <td>
                        ${recipe.user.userName}
                    </td>
                </tr>
            </c:forEach>
        </form>
        </tbody>
    </table>
</div>
