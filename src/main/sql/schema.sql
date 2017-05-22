#数据库初始化脚本

#创建数据库
CREATE  DATABASE seckill;
#使用数据库
use seckill;
#创建秒杀库存表
CREATE TABLE seckill(
  seckill_id BIGINT NOT NULL AUTO_INCREMENT COMMENT '商品库存ID',
  name VARCHAR (120) NOT NULL COMMENT '商品名称',
  number int NOT NULL COMMENT '库存数量',
  start_time TIMESTAMP NOT NULL COMMENT '秒杀开始时间',
  end_time TIMESTAMP NOT NULL COMMENT '秒杀结束时间',
  create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (seckill_id),
  KEY idx_start_time(start_time),
  KEY idx_end_time(end_time),
  KEY idx_create_time(create_time)
)ENGINE = InnoDB AUTO_INCREMENT = 1000 DEFAULT CHARSET = utf8 COMMENT = '秒杀库存表';

#初始化数据
INSERT INTO
  seckill(name,number,start_time,end_time)
VALUES
  ('1000元秒杀iPhone6',100,'2016-9-9 00:00:00','2016-9-10 00:00:00'),
  ('500元秒杀iPad2',200,'2016-9-9 00:00:00','2016-9-10 00:00:00'),
  ('300元秒杀小米4',300,'2016-9-9 00:00:00','2016-9-10 00:00:00'),
  ('200元秒杀红米note',400,'2016-9-9 00:00:00','2016-9-10 00:00:00');

#秒杀成功明细表
#用户登录明细信息
CREATE TABLE success_killed(
  seckill_id BIGINT NOT NULL COMMENT '秒杀商品ID',
  user_phone BIGINT NOT NULL COMMENT '用户手机号',
  state tinyint NOT NULL DEFAULT -1 COMMENT '状态标志:-1:无效 0:成功 1.已付款 2.已发货',
  create_time TIMESTAMP NOT NULL COMMENT '创建时间' ,
  PRIMARY KEY (seckill_id,user_phone),/*联合主键*/
  KEY idx_create_time(create_time)
)ENGINE = InnoDB CHARSET = utf8 COMMENT = '秒杀成功明细表';

#为什么手写DDL
#记录每次上线的DDL修改
#上线
ALTER TABLE seckill
DROP INDEX idx_create_time
add index idx_c_s(start_time,create_time)


CREATE TABLE phone (
  `phone_id`      BIGINT(20)   NOT NULL AUTO_INCREMENT
  COMMENT '手机ID',
  `phone_name`    VARCHAR(120) NOT NULL
  COMMENT '手机名称',
  `phone_price`   BIGINT(20)   NOT NULL
  COMMENT '手机价格',
  `phone_brand`   VARCHAR(120) NOT NULL
  COMMENT '手机品牌',
  `phone_type`    VARCHAR(120) NOT NULL
  COMMENT '手机型号',
  `net_type`      VARCHAR(120) NOT NULL
  COMMENT '入网型号',
  `appear_time`   TIMESTAMP    NOT NULL DEFAULT '0000-00-00 00:00:00'
  COMMENT '上市时间',
  `phone_color`   VARCHAR(120) NOT NULL
  COMMENT '手机颜色',
  `phone_long`    INT(20)      NOT NULL
  COMMENT '机身长度',
  `phone_width`   INT(20)      NOT NULL
  COMMENT '机身宽度',
  `phone_thick`   INT(20)      NOT NULL
  COMMENT '机身厚度',
  `phone_weight`  INT(20)      NOT NULL
  COMMENT '机身重量',
  `phone_texture` VARCHAR(120) NOT NULL
  COMMENT '机身材质分类',
  `phone_system`  VARCHAR(120) NOT NULL
  COMMENT '操作系统',
  `cpu_brand`     VARCHAR(120) NOT NULL
  COMMENT 'CPU品牌',
  `cpu_rate`      VARCHAR(120) NOT NULL
  COMMENT 'CPU频率',
  `cpu_number`    VARCHAR(120) NOT NULL
  COMMENT 'CPU核数',
  `cpu_type`      VARCHAR(120) NOT NULL
  COMMENT 'CPU型号',
  `double_type`   VARCHAR(120) NOT NULL
  COMMENT '双卡机类型',
  `max_suppot`    INT(20)      NOT NULL
  COMMENT '最大支持SIM个数',
  `card_type`     VARCHAR(120) NOT NULL
  COMMENT 'SIM卡类型',
  `fourG_ynet`       VARCHAR(120) NOT NULL
  COMMENT '4G网络',
  `fourG_lnet`       VARCHAR(120) NOT NULL
  COMMENT '4G网络',
  `fourG_dnet`       VARCHAR(120) NOT NULL
  COMMENT '4G网络',
  `rom`           VARCHAR(120) NOT NULL
  COMMENT 'ROM',
  `RAM`           VARCHAR(120) NOT NULL
  COMMENT 'RAM',
  `card`          VARCHAR(120) NOT NULL
  COMMENT '存储卡',
  `camera_num`    VARCHAR(120) NOT NULL
  COMMENT '摄像头数量',
  `h_camera`      VARCHAR(120) NOT NULL
  COMMENT '后置摄像头',
  `create_time`   TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  PRIMARY KEY (`phone_id`),
  KEY `idx_phone_name` (`phone_name`),
  KEY `idx_phone_price` (`phone_price`),
  KEY `idx_phone_brand` (`phone_brand`),
  KEY `idx_phone_type` (`phone_type`),
  KEY `idx_phone_color` (`phone_color`),
  KEY `idx_create_time` (`create_time`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8
  COMMENT = '手机信息表';
INSERT INTO phone (
  phone_name, phone_price, phone_brand, phone_type, net_type, appear_time,
  phone_color, phone_long, phone_width, phone_thick, phone_weight, phone_texture,
  phone_system, cpu_brand, cpu_rate, cpu_number, cpu_type, double_type, max_suppot,
  card_type, `4G_ynet`, `4G_lnet`, `4G_dnet`, rom, RAM, card, camera_num, h_camera
) VALUES (
  '苹果6s', 3888, '苹果（Apple）', '苹果（Apple）', 'A1700', '2015-9-1 00:00:00', '玫瑰金', 138.3,
   67.1, 7.1, 143, '其他', 'ios', '以官网信息为准', '以官网信息为准', '其他', '其他', '单卡', '1', 'Nano SIM',
   '4G：移动（TD-LTE)', '4G：联通(TD-LTE)', '4G：电信(FDD-LTE)', '16GB', '其他', '不支持', 1,
  '1200万像素'
),
(
  '小米4', 2000, '小米（MI）', '小米（MI）', '-', '2015-3-1 00:00:00', '白色', 155.1,
   77.6, 6.95, 161, '金属边框', 'Android', '骁龙（Snapdragon)', '2.5GHz', '四核', '骁龙801', '双卡双待单通', '2', 'Micro SIM',
                            '4G：移动（TD-LTE)', '4G：联通(TD-LTE)', '4G：电信(FDD-LTE)', '16GB', '3GB', '不支持', 1,
    '1300万像素'
  ),
  (
    '小米NOTE', 1000, '小米（MI）', '小米（MI）', '-', '2015-3-1 00:00:00', '白色', 155.1,
              77.6, 6.95, 161, '金属边框', 'Android', '骁龙（Snapdragon)', '2.5GHz', '四核', '骁龙801', '双卡双待单通', '2', 'Micro SIM',
                               '4G：移动（TD-LTE)', '4G：联通(TD-LTE)', '4G：电信(FDD-LTE)', '16GB', '3GB', '不支持', 1,
    '1300万像素'
  ),
  (
    '小米2S', 500, '小米（MI）', '小米（MI）', '-', '2015-3-1 00:00:00', '白色', 155.1,
            77.6, 6.95, 161, '金属边框', 'Android', '骁龙（Snapdragon)', '2.5GHz', '四核', '骁龙801', '双卡双待单通', '2', 'Micro SIM',
                             '4G：移动（TD-LTE)', '4G：联通(TD-LTE)', '4G：电信(FDD-LTE)', '16GB', '3GB', '不支持', 1,
    '1300万像素'
  ),
  (
    '红米', 1000, '小米（MI）', '小米（MI）', '-', '2015-3-1 00:00:00', '白色', 155.1,
          77.6, 6.95, 161, '金属边框', 'Android', '骁龙（Snapdragon)', '2.5GHz', '四核', '骁龙801', '双卡双待单通', '2', 'Micro SIM',
                           '4G：移动（TD-LTE)', '4G：联通(TD-LTE)', '4G：电信(FDD-LTE)', '16GB', '3GB', '不支持', 1,
    '1300万像素'
  );
