<%@include file="head.jsp"%>
<html>
<body>

<h2>Add Recipe</h2>
<form action="addNewRecipe" class="form-inline">
    <div class="form-group">
        <label for="name">Name: </label>
        <input type="text" class="form-control" id="name" name="name" class="name">
    </div>
    <div class="form-group">
        <label for="notes">Notes/Description: </label>
        <input type="text" class="form-control" id="notes" name="notes" class="notes">
    </div>
    <div class="form-group">
        <label for="ingredient1">Ingredient: </label>
        <input type="text" class="form-control" id="ingredient1" name="recipeIngredient" class="recipeIngredient">
    </div>
    <button type="button" name="addAnother" value="addAnother">Add another ingredient</button>
    <button type="submit" name="submit" value="createRecipe">Add new recipe</button>
</form>
</body>
</html>