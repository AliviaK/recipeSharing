em## Current Ideas:
### User Table:
- UserID(int autoincrement)* not null
- Username(varchar) not null
- Password(varchar) not null
- EmailAddress(varchar) not null

### Recipe Table
- RecipeID(int autoincrement)* not null
- UserID(int)! not null
- RecipeName(varchar) not null
- IsPublic(boolean) not null
- Description(varchar)

## RecipeIngredients Table
- RecipeID(int)!* not null
- IngredientName(varchar)* not null
- Measurement(varchar) not null

## RecipeSteps Table
- RecipeID(int)!* not null
- StepOrder(int)* not null
- Direction(varchar) not null

### Party Table
- PartyID(int autoincrement)* not null
- HostID (int)! not null
- RecipeID(int)! not null
- Date (DateTime) not null
- Details (varchar) null

### PartyUsers Table
- PartyID(int)*! not null
- UserID(int)*! not null



#### * denotes Primary Key
#### ! denotes Foreign Key