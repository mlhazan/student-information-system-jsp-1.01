CREATE TABLE sisuser(username varchar(50) NOT NULL ,password varchar(255) NOT NULL ,firsName varchar(50) NOT NULL ,lastName varchar(50) NOT NULL ,email varchar(50) NOT NULL ,phone varchar(50) NOT NULL ,street varchar(50) NOT NULL ,city varchar(50) default NULL ,state varchar(50) default NULL ,zip varchar(50) NOT NULL ,country varchar(50) NOT NULL ,id int NOT NULL  PRIMARY KEY);











INSERT INTO sisuser ( username , password , firstName , lastName , email ,phone ,
street,city,state,zip,country, id )
VALUES (
'randy', 'randy'  , 'Randy', 'Fortier', 'fortier@ecommerce.com','5199918007' ,'422 Danforth ave','Toronto','ON', 'M7TH6R','Canada',1
);