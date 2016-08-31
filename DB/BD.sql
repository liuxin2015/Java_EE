/**创建notebook的数据库*/
create database notebook;
/**选择notebook数据库*/
use notebook;
/**分配用户*/
GRANT SELECT,INSERT,UPDATE,DELETE,CREATE,DROP,ALTER ON notebook TO notebook@localhost IDENTIFIED BY '12345';
/**为notebook数据库设置密码*/
SET PASSWORD FOR 'notebook'@'localhost' = OLD_PASSWORD('12345');
/**创建用户表*/
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userNo` char(36) NOT NULL COMMENT '课例主键',
  `nickName` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '登录名',
  `password` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '密码',
  `userType` char(2) DEFAULT '1' COMMENT '用户类型',
  `sex` boolean DEFAULT TRUE COMMENT '性别', /*性别:TRUE=女，FALSE=男*/
  `fullName` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '用户名',
  `memo` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  `createDate` datetime DEFAULT NULL COMMENT '创建日期',
  `updateDate` datetime DEFAULT NULL COMMENT '更新日期',
  PRIMARY KEY (`userNo`),
  UNIQUE KEY `nickName` (`nickName`) USING BTREE       /**防止重复*/
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;