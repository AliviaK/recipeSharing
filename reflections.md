# Weekly Reflections

### Week 1 
#### Week of 8/30: 4 hours

Tasks Accomplished:
+ Update IntelliJ IDEA
+ Write first draft of Independent Project problem statement
+ Create first user stories

Since this is my second time taking this course, I had much of the required software downloaded and configured, so this 
week was spent updating IntelliJ, reviewing Git/GitHub and the command line, reviewing the course site, and introducing 
myself to my classmates. I made some progress on the planning portion of my independent project, which included writing
my first draft of my problem statement and MVP, and writing some user stories. I had issues loading the quizzes for the
two activities this week.

### Week 2
#### Week of 9/6: 7 hours

Tasks Accomplished:
+ Create indie project repository
+ Begin project README
+ Create and begin user stories and project plan documentation
+ Download TogglTrack

This week I worked along with the videos to create my project repository in IntelliJ and GitHub. Although I don't have 
much of the documentation planned, I started by creating the README and laying out the structure, and created the user 
stories and project plan files, and inserted the stories and MVP drafts I'd written last week. I forgot exactly how much 
planning goes into a project before any code is written! I'm still thinking out the MVP because I don't want to get in 
way over my head with features, but I have a good idea of all that I want to create. I've been looking at other recipe 
apps out there to get ideas of features I'd like and how to set my app apart from the rest. I've also looked at some API
ideas, but not positive yet on what I'd like to use or how the screen or database design will go. I signed up for 
TogglTrack to keep a more accurate account of my time spent and will begin using it next week, because the time flies 
much faster than I can keep track of on my own.

### Week 3
#### Week of 9/13: 6.5 hours

Tasks Accomplished:
+ Add Log4J2 & JUnit to project
+ Finish User Stories/MVP documentation
+ Begin project plan mapping
+ Begin screen design
+ Begin user flow

This week I spent several hours working to finish writing and sorting the user stories, and denoting which will be part
of the project MVP. After completing the weekly work regarding JUnit and Log4J2 I added the dependencies for both into 
the project pom.xml and added the log4j2.properties into the resources, and assured it was configured properly. I 
continued working on the plan mapping and began playing around with screen design and user flow, which I plan to 
complete early this coming week to complete my Checkpoint 1 requirements. On Sunday I started working on the screen 
design and completed a mockup of the homepage.

### Week 4
#### Week of 9/20: 6 hrs

Tasks Accomplished:
+ Create recipesAmongFriends database
+ Create User table and add fake data
+ Create UserDao
+ Configure Hibernate to User class & User table
+ Create SessionFactoryProvider
+ Get user info to show on basic user search jsp
+ Achieve full CRUD coverage with DAO
+ Set up test database schema

This week's first focus was to prepare for Checkpoint 1, which included finalizing my project plan, screen design, user
stories, MVP, and application flow. With the feedback I received I plan to revise my MVP to make sure it isn't too 
ambitious for the time I have left this semester, and select one big feature to focus on while marking some other
planned features as additional goals I will add if time permits. I will also continue to work on the designs for the 
other MVP screens before creating them, so I will be readjusting my project plan to reflect these changes. 
After submitting my Checkpoint 1 documentation I began working on the Hibernate configuration and created a User class,
a UserDao, a SessionFactoryProvider, and a hibernate.cfg.xml file. I then created the recipesAmongFriends database and 
its first table, the User table. I annotated the User class to connect to the User table in the database, and borrowing
the jsps and SearchUser class from the user search assignment I conducted a successful search of the fake data I plugged
into my table, and confirmed that the dao is working properly. I finished the week with creating a test database so that
I was no longer messing with the data in my regular schema. I achieved full CRUD coverage for User.

### Week 5
#### Week of 9/27: 6 hours

Tasks Accomplished:
+ Change Log4J2 output location
+ Create all tables in database and test database
+ Create Recipe and RecipeIngredient classes
+ Create passing tests for User, Recipe, and Recipe Ingredient
+ Create GenericDao

This week I created the Recipe class to coincide with the Recipe table and got the one-to-many hibernate relationship
working between Recipe and User. I also created the RecipeIngredient table and the one-to-many between it and Recipe.
I created passing unit tests for all three of these classes, and converted to a GenericDao. I created all tables
I will be needing for this project in both the production and test databases, and will be adding the classes and unit 
tests for the rest of these tables in the coming week. I practiced making my first branch for the generic dao and merged
it with the main on gitHub.

### Week 6
#### Week of 10/4: 5 hours

Tasks Accomplished:
+ Sign up for AWS
+ Create first environment in Amazon Beanstalk
+ Deploy project
+ Complete peer reviews

This week I signed up for AWS and after some trial and error with database issues, I got my project deployed via Amazon
Beanstalk. After that I finished creating the POJO classes for all remaining tables aside from the Party_User
table. I ran into some issues while trying to figure out the relationship, whether it was one-to-many or many-to-many 
between party and user, because party has one user as "host", but also has many attendees per party and users can attend
many parties. I consulted these two articles while trying out both options:   
https://www.baeldung.com/hibernate-many-to-many
https://stackoverflow.com/questions/3585034/how-to-map-a-composite-key-with-jpa-and-hibernate
I will be continuing next week to solve this issue so I can move forward with creating the servlets to create and upload
this data. 

### Week 7
#### Week of 10/11: 6.5 hours

Tasks Accomplished:
+ Set up AWS Cognito
+ Create tests for PartyDao/RecipeDao/RecipeIngredientDao/RecipeStepDao
+ Finish database design
+ Complete checkpoint 2
+ Add Cognito
+ Begin creating form and JavaScript for inserting new recipe

This week I added signup and authentication using AWS Cognito. I prepared for checkpoint 2 by finalizing my database 
design, and I determined I would make party_users a many-to-many table. I also finalized my database by adding a recipe
review table to hold ratings and reviews by users. I've made entities for 5 of the tables so far and created unit tests
for all of them, and by the end of next week I plan to have all 7 entities created and tested.

I looked ahead and began doing research on javamail, and found this
tutorial to reference at a later date: https://www.tutorialspoint.com/javamail_api/javamail_api_quick_guide.htm
I also reviewed the FAQs on Javamail's github which I am pasting here since it will definitely come in handy: 
https://javaee.github.io/javamail/FAQ.html#1

I began fixing up the layout of my jsps and Bootstrap errors, so that I am better set up when I work further on the 
design aspect. I created a jsp and servlet for inserting a new recipe, which I haven't completed yet but spent time 
creating the form and making it look nice with Bootstrap. It is a dynamic form so that users can click a button to add 
additional ingredients as needed, so I created a JavaScript file to generate a new input when clicked. I will do the 
same for steps, and next I will get to work on processing the form itself in the servlet.

### Week 8
#### Week of 10/18: 2.5 hours

Tasks Accomplished:
+ Set up SendGrid API key and send successful email via SoapUI
+ Finish all page mockups

Most of this week I was out of town and was unable to bring anything beside my laptop, so unfortunately aside from 
getting the weekly assignment done I was not able to accomplish much and fell a bit behind. I was able to finish mockups
of all pages and did some research on which API to use, which I decided on SendGrid instead of JavaMail on a
recommendation by my manager. I signed up for an API key and spent some time getting it configured to my project, which 
I plan this week to write tests and send my first email through the app. I successfully sent an email through SoapUI.

### Week 9
#### Week of 10/26: 12 hours (4 hours on Indie Project) (8 hours on Research Project)

Tasks Accomplished:
+ Troubleshoot SendGrid
+ Deploy to AWS with Cognito Sign-in
+ Finish research on Amazon Rekognition

This week I returned home late so my week was cut a bit short, and I also had to dedicate most of my work time to
putting together my research project demo and video, which I did on Amazon Rekognition. I was able to put a few hours in
after completing my research project and getting caught up on weekly work. I configured my app for deployment to AWS
with Amazon Cognito and got the elastic IP set up, so I was able to see my app deployed without having to run through
localhost. I spent several hours troubleshooting SendGrid and sadly my account was suspended, likely because I was 
sending and successfully delivering emails to and from my own email addresses. I will be switching back to JavaMail as 
originally planned, which puts me a bit further behind where I planned and hoped to be. I also met with my team for the
team project and my next weeks will be dedicated to getting back on track in my project and completing the team work. 