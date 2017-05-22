--秒杀存储过程
DELIMITER $$ --console ; 转化为 $$
--定义存储过程
--参数: in:输入参数  out:输出参数
--count_count():返回上一条修改类型sql(delete,insert,update)的影响行数
--row_count: 0:未修改数据; >0:修改数据行数; <0:sql错误/未执行修改sql
--重复秒杀
CREATE PROCEDURE seckill.execute_seckill
(in v_seckill_id bigint, in v_phone bigint,
  in v_kill_time TIMESTAMP ,out r_result int)
BEGIN
  DECLARE insert_count int DEFAULT 0;
  START TRANSACTION ;
  insert ignore into success_killed
  (seckill_id,user_phone,create_time)
values (v_seckill_id,v_phone,v_kill_time);
  select ROW_COUNT() into insert_count;
  IF (insert_count = 0) THEN
  ROLLBACK;
  set r_result = -1;
  ELSEIF(insert_count < 0) THEN
  ROLLBACK;
  SET R_RESULT = -2;
  ELSE
  UPDATE seckill
  set number = number - 1
  where seckill_id = v_seckill_id
    and end_time >v_kill_time
    and start_time < v_kill_time
    and number > 0;
    select ROW_COUNT() into insert_count;
    IF (insert_count = 0) THEN
    ROLLBACK;
    set r_result = 0;
    ELSEIF(insert_count < 0) THEN
    ROLLBACK ;
    set r_result = -2;
    ELSE
    COMMIT ;
    SET r_result = 1;
    END IF;
  END IF;
END
$$
--存储过程定义结束
--show create procedure  execute_seckill\G
--取出的过程
DELIMITER ;
set @r_result = -3;
--执行存储过程
call execute_seckill (1003,17778923411,now(),@r_result);
--取出结果
select @r_result;

--存储过程
--1.存储过程优化:事务行级锁持有的时间
--2.不要过度依赖存储过程
--3.简单的逻辑使用存储过程
--4.QPS: 一个秒杀单:6000