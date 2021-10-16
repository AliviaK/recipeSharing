<%@include file="head.jsp"%>

<h2>Search Recipes</h2>
<form action="searchRecipe" class="form-inline">
    <div class="form-group">
        <label for="searchTerm">Search</label>
        <input type="text" class="form-control" id="searchTerm" name="searchTerm" class="searchTerm">
    </div>
    <button type="submit" name="submit" value="searchName">Search by name</button>
    <button type="submit" name="submit" value="searchAll">See All Recipes</button>
</form>

<%@include file="footer.jsp"%>