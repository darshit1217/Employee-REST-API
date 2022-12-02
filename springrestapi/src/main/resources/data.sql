drop table employee;
create table employee(
id int not null auto_increment primary key,
name varchar(255) ,
age int ,
location varchar(255),
email varchar(255) ,
department varchar(255),
created_at timestamp DEFAULT CURRENT_TIMESTAMP(3),
update_at timestamp DEFAULT CURRENT_TIMESTAMP(3)
);
insert into employee(NAME,AGE,LOCATION,EMAIL,DEPARTMENT)
values('Saumya',23,'Bhopal','saumyachaturvedi@gmail.com','Civil');
insert into employee(NAME,AGE,LOCATION,EMAIL,DEPARTMENT)
values('Palash',24,'Mumbai','palash@gmail.com','Mech');
insert into employee(NAME,AGE,LOCATION,EMAIL,DEPARTMENT)
values('Ram',75,'Lucknow','ram@gmail.com','EI');
insert into employee(NAME,AGE,LOCATION,EMAIL,DEPARTMENT)
values('Shyam',73,'Gandhinagar','shyam@gamil.com','BBA');
insert into employee(NAME,AGE,LOCATION,EMAIL,DEPARTMENT)
values('Harsha',34,'Indore','harsha@gmail.com','Pharmacy');
insert into employee(NAME,AGE,LOCATION,EMAIL,DEPARTMENT)
values('Trisha',45,'Chennai','trisha@gmail.com','Acting');
insert into employee(NAME,AGE,LOCATION,EMAIL,DEPARTMENT)
values('Atishay',26,'Indore','atishay@gmail.com','EC');
insert into employee(NAME,AGE,LOCATION,EMAIL,DEPARTMENT)
values('Devansh',25,'Rajkot','devansh@gmail.com','LLB');
insert into employee(NAME,AGE,LOCATION,EMAIL,DEPARTMENT)
values('Saumya',55,'Bangalore','saumyagupta@gmail.com','IT');
