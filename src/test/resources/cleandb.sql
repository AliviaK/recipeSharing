DELETE FROM recipe_ingredient;
DELETE FROM recipe;
DELETE FROM user;
INSERT INTO user VALUES (1, 'Jeff', 'Winger', 'jwinger', 'jwinger@greendale.edu'),
                        (2, 'Britta', 'Perry', 'bperry', 'bperry@greendale.edu'),
                        (3, 'Troy', 'Barnes', 'tbarnes', 'tbarnes@greendale.edu'),
                        (4, 'Abed', 'Nadir', 'anadir', 'anadir@greendale.edu'),
                        (5, 'Shirley', 'Bennett', 'sbennett', 'sbennett@greendale.edu'),
                        (6, 'Annie', 'Edison', 'aedison', 'aedison@greendale.edu');
INSERT INTO recipe VALUES (1, 5, 'Brownies', 'Delicious and chocolatey', true),
                          (2, 5, 'Mini Pie', 'Single serving pie that works with your favorite fruit filling', true),
                          (3, 2, 'Bear Claws', 'Flaky almond dessert croissant', true);
INSERT INTO recipe_ingredient VALUES (1, 1, 'Chocolate Chips', '1/2 cup'),
                                    (2, 1, 'Baking Powder', '1 tsp'),
                                    (3, 2, 'Coconut Oil', '1/2 cup');