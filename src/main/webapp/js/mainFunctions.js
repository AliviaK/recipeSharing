let i = 1;

const init = () => {
    document.querySelector("#addIngredient").addEventListener("click", processClick);
}

const processClick = () => {
    let formDiv = document.createElement('div');
    formDiv.setAttribute("id", "formDiv" + i);
    formDiv.setAttribute("class", "form-group");

    let labelFor = document.createElement('label');
    labelFor.setAttribute("for", "ingredient" + i);
    labelFor.innerText = "Ingredient:";

    let ingredientInput = document.createElement('input');
    ingredientInput.setAttribute("type", "text");
    ingredientInput.setAttribute("id", "ingredient" + i);
    ingredientInput.setAttribute("name", "ingredient");
    ingredientInput.setAttribute("class", "form-control col-12");

    document.getElementById("addIngredientDiv").appendChild(formDiv);
    document.getElementById("formDiv" + i).appendChild(labelFor);
    document.getElementById("formDiv" + i).appendChild(ingredientInput);

    i++;
}

window.onload = init;