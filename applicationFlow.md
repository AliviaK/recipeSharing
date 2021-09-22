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
3. Servlet uses recipe DAO to select recipes according to search criteria if included, else selects all recipes
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
1. If user logged in, user selects uploaded recipe to share and selects share button
2. If user has correct permissions for recipe, server updates database entry from private to public and recipe is now
searchable

## Host Recipe Party
1. If user logged in, user selects Host Party link and fills out party information, including invited users
2. Party information is sent to CreatParty servlet
3. Servlet creates party object
4. Servlet sends party object to DAO
5. DAO adds party info to database
6. Servlet sends confirmation to recipe page confirming addition to database
7. Using Javamail (likely), party information is emailed to users with invite permissions

## Review/Rate Recipe
1. If user logged in, user selects rating out of 5 stars, writes review of recipe, and/or selects photo
2. Review information is sent to AddRecipe servlet
3. If photo is uploaded, Amazon Rekognition (likely) confirms photo is of food
4. If photo uploaded and is not food, error message shown
5. Servlet creates review object
6. Servlet sends review object to DAO
7. DAO adds review to database
8. Servlet sends confirmation to review page confirming addition to database

