## Sign Up
1. If user not signed in, user clicks sign-up link from any page
2. User fills out account information and submits
3. Signup request sent to Sign Up servlet
4. Servlet creates user object and user in database
5. Response to user via JSP that user was created

## Sign In
1. If not logged in, user clicks login link from any page
2. User fills in account name and password on form and submits
3. If information is correct, server allows access to account info, recipe
creation page, and specified roles
4. If info incorrect, show error messge

## Browse/Search Recipes
1. User clicks "Search Recipes" link
2. Page sends request to view recipes servlet with keyword or tag if included
3. Servlet uses recipe DAO to select recipes according to search criteria
if included, else selects all recipes
4. DAO returns list of recipes following criteria to servlet
5. Servlet sends list to RecipeDisplay JSP
6. RecipeDisplay JSP displays recipes

## Upload Recipe
1. If user logged in, user enters recipe ingredients and instructions
2. Recipe information is sent to AddRecipe servlet
3. Servlet creates recipe object
4. Servlet sends recipe object to DAO
5. DAO adds recipe to database
6. Servlet sends confirmation to recipe page confirming addition to database

## Share Recipe

## Host Recipe Party

## Review/Rate Recipe