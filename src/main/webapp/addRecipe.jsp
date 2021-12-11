<%@include file="head.jsp"%>

<header>
    <h1>Add a New Recipe</h1>
</header>

<form action="addRecipe" class="w-75 mx-auto">
    <div class="row m-3">
        <div class="form-group col-6">
            <label for="name">Recipe Name: </label>
            <input type="text" class="form-control" id="name" name="name" class="name" placeholder="Recipe Name">
        </div>
        <div class="form-group col-6">
            <label for="notes">Description: </label>
            <input type="text" class="form-control" id="notes" name="notes" class="notes" maxlength="100"
                   placeholder="Add a short description about your recipe">
        </div>
    </div>

    <div class="row m-3" id="addIngredientDiv">
        <div class="form-group col-6">
            <label for="ingredient0">Ingredient: </label>
            <input type="text" class="form-control" id="ingredient0" name="recipeIngredient" placeholder="Ingredient Name">
        </div>
        <div class="form-group col-6">
            <label for="quantity0">Quantity: </label>
            <input type="text" class="form-control" id="quantity0" name="ingredientQuantity" placeholder="ex. 1/4 tsp">
        </div>
    </div>

    <div class="row m-3">
        <div class="col-12 mt-2">
            <button class="purpleButton text-white font-weight-bold mt-1" type="button" id="addIngredient">Add another ingredient</button>
        </div>
    </div>

    <div class="row m-3" id="addStepDiv">
        <div class="form-group col-sm-1">
            <label for="quantity0">Order #: </label>
            <input type="text" class="form-control" id="order0" name="stepOrder">
        </div>
        <div class="form-group col-sm-11">
            <label for="ingredient0">Step: </label>
            <input type="text" class="form-control" id="step0" name="recipeStep" maxlength="100">
        </div>
    </div>

    <div class="row m-3">
        <div class="col-12 mt-2">
            <button class="purpleButton text-white font-weight-bold mt-1" type="button" id="addStep">Add another step</button>
        </div>

        <div class="col-12 p-2 mt-2">
            <button class="purpleButton text-white font-weight-bold mt-1" type="submit" id="createRecipe" value="createRecipe">Add new recipe</button>
        </div>
    </div>
</form>

<%@include file="footer.jsp"%>