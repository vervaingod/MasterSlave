--init t_user
TRUNCATE TABLE `t_user`;
INSERT INTO `t_user` VALUES ('1', 'zzz', '123', '18600000000');
INSERT INTO `t_user` VALUES ('2', 'aaa', '123', '13900000000');
INSERT INTO `t_user` VALUES ('3', 'bbb', '123', '13800000000');
INSERT INTO `t_user` VALUES ('4', 'ccc', '123', '13700000000');
INSERT INTO `t_user` VALUES ('5', 'ddd', '123', '13600000000');
INSERT INTO `t_user` VALUES ('6', 'eee', '123', '13500000000');
INSERT INTO `t_user` VALUES ('7', 'fff', '123', '13400000000');
INSERT INTO `t_user` VALUES ('8', 'ggg', '123', '13300000000');
INSERT INTO `t_user` VALUES ('9', 'hhh', '123', '13200000000');
INSERT INTO `t_user` VALUES ('10', 'xxx', '123', '13100000000');
INSERT INTO `t_user` VALUES ('11', 'yyy', '123', '13000000000');

--init t_articles
TRUNCATE TABLE `t_article`;
INSERT INTO `t_article` (`id`,`create_date`,`creator`,`head_img`,`text`,`title`,`update_date`)
VALUES
(1,'2017-12-12 12:00:00','admn','/temp/img','main-text','title1','2017-12-12 12:00:00'),
(2,'2017-12-12 12:00:00','admn','/temp/img','main-text','title2','2017-12-12 12:00:00'),
(3,'2017-12-12 12:00:00','admn','/temp/img','main-text','title3','2017-12-12 12:00:00'),
(4,'2017-12-12 12:00:00','admn','/temp/img','main-text','title4','2017-12-12 12:00:00'),
(5,'2017-12-12 12:00:00','admn','/temp/img','main-text','title5','2017-12-12 12:00:00'),
(6,'2017-12-12 12:00:00','admn','/temp/img','main-text','title6','2017-12-12 12:00:00');