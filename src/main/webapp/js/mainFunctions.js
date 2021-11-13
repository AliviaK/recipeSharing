let i = 1;

const init = () => {
    document.querySelector("#addIngredient").addEventListener("click", processClick);
}

const processClick = () => {
    // Create div to store ingredient at quantity
    let ingredientDiv = document.createElement('div');
    ingredientDiv.setAttribute("id", "ingredientDiv" + i);
    ingredientDiv.setAttribute("class", "form-group");

    let labelFor = document.createElement('label');
    labelFor.setAttribute("for", "ingredient" + i);
    labelFor.innerText = "Ingredient:";

    let ingredientInput = document.createElement('input');
    ingredientInput.setAttribute("type", "text");
    ingredientInput.setAttribute("id", "ingredient" + i);
    ingredientInput.setAttribute("name", "ingredient");
    ingredientInput.setAttribute("class", "form-control col-12");

    document.getElementById("addIngredientDiv").appendChild(ingredientDiv);
    document.getElementById("ingredientDiv" + i).appendChild(labelFor);
    document.getElementById("ingredientDiv" + i).appendChild(ingredientInput);

    i++;
}

window.onload = init;