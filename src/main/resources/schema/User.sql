-- auto Generated on 2018-04-09 09:47:26 
-- DROP TABLE IF EXISTS `user`; 
CREATE TABLE user(
    `id` INTEGER(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
    `user_id` VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'userId',
    `name` VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'name',
    `dep_id` VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'depId',
    `sex` VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'sex',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'user';