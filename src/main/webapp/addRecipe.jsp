<%@include file="head.jsp"%>

<header>
    <h1>Add Recipe</h1>
</header>

<form action="addNewRecipe" class="form-row">
    <div class="form-group col-12">
        <label for="name">Name: </label>
        <input type="text" class="form-control" id="name" name="name" class="name">
    </div>
    <div class="form-group col-12">
        <label for="notes">Notes/Description: </label>
        <input type="text" class="form-control" id="notes" name="notes" class="notes">
    </div>
    <div id="addIngredientDiv">
        <div class="form-group col-12">
            <label for="ingredient0">Ingredient: </label>
            <input type="text" class="form-control" id="ingredient0" name="recipeIngredient">
        </div>
    </div>
    <div class="col-12">
        <button type="button" id="addIngredient">Add another ingredient</button>
        <button type="submit" id="createRecipe" value="createRecipe">Add new recipe</button>
    </div>
</form>




<%@include file="footer.jsp"%>