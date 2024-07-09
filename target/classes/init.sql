DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` VARCHAR(50) NOT NULL COMMENT 'ID',
  `name` VARCHAR(50) NOT NULL COMMENT '姓名',
  `username` VARCHAR(50) NOT NULL COMMENT '用户名',
  `password` VARCHAR(30) NOT NULL COMMENT '密码',
  `gender` INTEGER DEFAULT NULL COMMENT '性别。1：男；2：女',
  `age` INTEGER DEFAULT NULL COMMENT '年龄',
  `address` VARCHAR(100) DEFAULT NULL COMMENT '住址',
  `qq` VARCHAR(30) DEFAULT NULL COMMENT 'QQ',
  `email` VARCHAR(50) DEFAULT NULL COMMENT '邮箱',
  `is_deleted` INTEGER DEFAULT 0 COMMENT '是否删除。0：否；1：是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户';
INSERT INTO user(id, name, username, password, gender, age, address, qq, email, is_deleted) VALUES
('1', '管理员', 'admin', '123456', 1, NULL, NULL, NULL, NULL, 0),
('2', '张三', '1', '1', 1, NULL, NULL, NULL, NULL, 0);
