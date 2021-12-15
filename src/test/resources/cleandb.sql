DELETE FROM party_user;
DELETE FROM party;
DELETE FROM recipe_step;
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
                          (3, 2, 'Bear Claws', 'Flaky almond dessert croissant', true),
                          (4, 2, 'Cookies', 'Classic chocolate chip', true);
INSERT INTO recipe_ingredient VALUES (1, 'Chocolate Chips', 1, '1/2 cup'),
                                    (2, 'Baking Powder', 1, '1 tsp '),
                                    (3, 'Coconut Oil', 2, '1 cup '),
                                     (4, 'Chocolate Chips', 4, '1/2 cup'),
                                     (5, 'Baking Powder', 4, '1 tsp '),
                                     (6, 'Coconut Oil', 4, '1 cup ');
INSERT INTO recipe_step VALUES (1, 1, 'Mix flour, cinnamon, and cocoa powder in large bowl', 1),
                                 (2, 2, 'Combine eggs and sugar in medium bowl', 1),
                                 (3, 3, 'Add wet ingredients to dry', 1),
                                 (4, 1, 'Place crust in pie pan', 2),
                                 (5, 2, 'Add canned cherries to crust', 2),
                                 (6, 1, 'Mix dough in large bowl', 4),
                                 (7, 2, 'Add chips in medium bowl', 4),
                                 (8, 3, 'Bake for 40 minutes', 4);
INSERT INTO party VALUES (1, 1, 1, '1995-12-20 12:30:00', 'Baking cookies'),
                         (2, 1, 3, '1996-04-18 02:30:00', 'Baking pie'),
                         (3, 2, 2, '2010-02-24 18:20:00', 'Baking brownies');
INSERT INTO party_user VALUES (1, 1),
                              (1, 2),
                              (1, 3),
                              (2, 2),
                              (2, 3);