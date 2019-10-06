

INSERT INTO `companies` VALUES (1,'test-company-1','Test Firma 1',1,1,'2019-06-07 05:23:30.474205','2019-06-07 05:23:30.474205');

INSERT INTO `users` VALUES (1,1,'admin@iflow.de','1977-01-01','admin','Admin','Admin',1,1,1,'2019-05-24 07:59:38.703057','2019-05-24 07:59:38.703057'),(2,1,'user@iflow.de','1980-02-03','user','User','User',5,1,1,'2019-05-24 08:00:15.854422','2019-05-24 08:00:15.854422'),(3,1,'user2@iflow.de','2000-05-12','user','User 2','User 2',5,1,1,'2019-06-14 05:45:49.062034','2019-06-14 05:45:49.062034'),(4,1,'user3@iflow.de','1991-11-23','user','User 3','User 3',5,1,1,'2019-06-14 05:46:12.789077','2019-06-14 05:46:12.789077');

INSERT INTO `departments`(id, company_id, title) VALUES (1,1,'Dep 1'),(2,1,'Dep 2'),(3,1,'Dep 3');

INSERT INTO `departments_group`(id, department_id, title) VALUES (1,1,'Dep1 Group 1'),(2,1,'Dep1 Group 2'),(3,1,'Dep1 Group 3'),(4,2,'Dep2 Group 1'),(5,2,'Dep2 Group 2');

INSERT INTO `user_departments` VALUES (1,1,'2019-06-14 08:03:17.213536'),(1,2,'2019-06-14 08:03:17.222388');

INSERT INTO `user_deputy`(user_id, deputy_id) VALUES (1,2),(1,3),(1,4);

INSERT INTO `user_group`(id, title, company_id) VALUES (1,'Group 1',1),(2,'Group 2',1),(3,'Group 3',1);

INSERT INTO `user_usergroup` VALUES (1,1,'2019-06-14 08:01:51.738670'),(1,2,'2019-06-14 08:01:51.740144');

