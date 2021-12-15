<%@include file="head.jsp"%>

<header>
    <h1>Popular Recipes: </h1>
</header>

<form method="get" action="searchRecipe" class="form-inline">
    <div class="row align-items-end">
        <div class="col form-group font-weight-bold">
            <label for="searchTermRecipe">Search</label>
            <input type="text" class="form-control" id="searchTermRecipe" name="searchTermRecipe" class="searchTermRecipe">
        </div>
        <div class="col">
            <button class="purpleButton btn text-white font-weight-bold me-1" type="submit" name="submit" value="searchRecipe">Search by Recipe Name</button>
            <button class="purpleButton btn text-white font-weight-bold" type="submit" name="submit" value="searchAll">Search All Recipes</button>
        </div>
        <div>

        </div>
    </div>
</form>

<c:if test="${!empty recipes}">
    <%@include file="searchedRecipes.jsp"%>
</c:if>

<%@include file="footer.jsp"%>
