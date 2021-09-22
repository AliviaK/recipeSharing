# Coming Soon :)

## Current Ideas:
### User Table:
- UserID(int autoincrement)* not null
- Username(varchar) not null
- Password(varchar) not null
- EmailAddress(varchar) not null

### Recipe Table
- RecipeID(int autoincrement)* not null
- Ingredients(varchar) not null (Probably create separate RecipeIngredients table)
- Directions(varchar) not null
- UserID(int)! not null
- IsPublic(boolean) not null

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