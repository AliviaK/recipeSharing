<%@include file="taglib.jsp"%>
<%@include file="head.jsp"%>

<html><body>

<div class="container-fluid">
    <h2>Search Results: </h2>
    <table class="table">
        <thead>
        <th>Name</th>
        <th>Username</th>
        <th>Recipes</th>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.firstName} ${user.lastName} </td>
                <td>${user.userName}</td>
                <td>
                    <c:forEach var="recipe" items="${user.recipes}">
                       ${recipe.id} ${recipe.name}
                    </c:forEach>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
