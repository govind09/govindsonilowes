create table operation_table(
id int PRIMARY KEY AUTO_INCREMENT,
VALUE_FIRST DECIMAL(65,30) ,
VALUE_SECOND DECIMAL(65,30) ,
OPERATION char(3),
RESULT DECIMAL(65,30)
);

select * from operation_table;