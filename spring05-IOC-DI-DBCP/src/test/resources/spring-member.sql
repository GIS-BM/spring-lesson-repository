create table spring_member(
	id VARCHAR(100) PRIMARY KEY,
	password VARCHAR(20) NOT NULL,
	name VARCHAR(100) NOT NULL,
	address VARCHAR(100)
)
insert INTO spring_member(id,password,name,address)
VALUES('Java','a','손흥민','런던');
commit;
select * from spring_member;