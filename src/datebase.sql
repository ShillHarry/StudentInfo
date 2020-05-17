create database studentInfo;
use studentInfo;
create table student
(
	ID varchar(20) primary key,
	Name varchar(10) not null,
	Sex boolean,
	Birthday date,
	Age int,
	PhoneNumber char(11)
);