create table users (
	userid          varchar2(50)	primary key, 
	username		varchar2(50)	not null,
	userpassword	varchar2(50)	not null,
	userage			number(3)	    not null,
	useremail		varchar2(50)	not null
);
