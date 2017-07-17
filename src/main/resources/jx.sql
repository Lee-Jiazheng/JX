# Host: localhost  (Version: 5.5.47)
# Date: 2017-07-17 12:58:01
# Generator: MySQL-Front 5.3  (Build 4.234)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "category"
#

DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL,
  `parent_flag` tinyint(1) DEFAULT NULL,
  `parent_id` int(11) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_scope_idx` (`parent_id`),
  CONSTRAINT `fk_scope` FOREIGN KEY (`parent_id`) REFERENCES `category` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "category"
#


#
# Structure for table "goods"
#

DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL DEFAULT '',
  `quantity` int(10) unsigned NOT NULL DEFAULT '0',
  `category_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '大分类',
  `status` int(11) DEFAULT '0',
  `use_flag` tinyint(1) DEFAULT '1',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `keywords` varchar(45) DEFAULT NULL,
  `original_price` int(10) unsigned NOT NULL,
  `current_price` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Data for table "goods"
#

INSERT INTO `goods` VALUES (1,'haha',0,1,NULL,NULL,NULL,NULL,NULL,NULL,0,0);

#
# Structure for table "promotion"
#

DROP TABLE IF EXISTS `promotion`;
CREATE TABLE `promotion` (
  `id` int(11) unsigned NOT NULL,
  `name` varchar(45) NOT NULL,
  `threshold` int(10) unsigned NOT NULL COMMENT '优惠门槛',
  `deduction` int(10) unsigned NOT NULL COMMENT '减免金额',
  `scope` int(11) unsigned NOT NULL COMMENT '限制商品类别',
  PRIMARY KEY (`id`),
  KEY `fk_scopes_idx` (`scope`),
  CONSTRAINT `fk_scopes` FOREIGN KEY (`scope`) REFERENCES `category` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='优惠活动表';

#
# Data for table "promotion"
#


#
# Structure for table "user"
#

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '每个用户有一个不同的id',
  `nickname` varchar(45) NOT NULL COMMENT '昵称',
  `realname` varchar(45) DEFAULT NULL COMMENT '真实姓名，可不填',
  `create_time` datetime NOT NULL COMMENT '注册时间',
  `email` varchar(45) DEFAULT NULL COMMENT '邮箱地址，可不填',
  `phone` varchar(45) NOT NULL,
  `credit` int(10) unsigned NOT NULL COMMENT '买家信用积分',
  PRIMARY KEY (`id`),
  UNIQUE KEY `nick_name_UNIQUE` (`nickname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='买家表';

#
# Data for table "user"
#


#
# Structure for table "order"
#

DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '流水单号',
  `goods` int(11) unsigned NOT NULL COMMENT '外键，参考商品id',
  `buyer` int(11) unsigned NOT NULL COMMENT '买家id',
  `time` datetime NOT NULL,
  `is_finished` tinyint(1) NOT NULL COMMENT '0代表正在处理，1代表已完成',
  `destiny` varchar(45) NOT NULL COMMENT '收货地址，不得为空',
  `price` int(10) unsigned NOT NULL COMMENT '成交时的价格',
  PRIMARY KEY (`id`),
  KEY `fk_buyer_idx` (`buyer`),
  CONSTRAINT `fk_buyer` FOREIGN KEY (`buyer`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';

#
# Data for table "order"
#


#
# Structure for table "evaluate"
#

DROP TABLE IF EXISTS `evaluate`;
CREATE TABLE `evaluate` (
  `goods_id` int(11) unsigned NOT NULL COMMENT '商品id',
  `evaluation` text,
  `buyer_id` int(11) unsigned NOT NULL COMMENT '买家id，和商品id一起组成一条评价的主键',
  PRIMARY KEY (`buyer_id`,`goods_id`),
  KEY `fk_goods_idx` (`goods_id`),
  CONSTRAINT `fk_goods` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user` FOREIGN KEY (`buyer_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品评价';

#
# Data for table "evaluate"
#

