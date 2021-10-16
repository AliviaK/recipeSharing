<%@include file="taglib.jsp"%>
<%@include file="head.jsp"%>

<header>
    <h1>Search Results: </h1>
</header>

<div class="container-fluid">
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

<%@include file="footer.jsp"%>