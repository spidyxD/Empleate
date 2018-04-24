-- MySQL Workbench Forward Engineering
CREATE DATABASE empleateBETA;
USE empleateBETA ;



-- -----------------------------------------------------
-- Table  login
-- -----------------------------------------------------


CREATE TABLE Login (
  idLogin INT NOT NULL AUTO_INCREMENT,
  username VARCHAR(45) NULL UNIQUE,
  password VARCHAR(45) NULL,
  type_log VARCHAR(45) NULL,
  enable INT,
  PRIMARY KEY (idLogin));

-- -----------------------------------------------------
-- Table manager
-- -----------------------------------------------------


CREATE TABLE Manager (
  idManager INT NOT NULL AUTO_INCREMENT,
  email VARCHAR(45),
  login INT NOT NULL,
  PRIMARY KEY (idManager),
  CONSTRAINT fkManager FOREIGN KEY (login) REFERENCES Login(idLogin));


-- -----------------------------------------------------
-- Table Company
-- -----------------------------------------------------


CREATE TABLE Company (
  idCompany INT NOT NULL  AUTO_INCREMENT,
  name_company VARCHAR(45) NULL,
  email VARCHAR(45) NULL,
  phone VARCHAR(45) NULL,
  description VARCHAR(45) NULL,
  location_X float,
  location_Y float,
  address VARCHAR(45) NULL,
  login INT NOT NULL,
  PRIMARY KEY (idCompany),
  CONSTRAINT fkCompany FOREIGN KEY (login) REFERENCES Login(idLogin));


-- -----------------------------------------------------
-- Table  offerer
-- -----------------------------------------------------


CREATE TABLE Offerer( 
  idOfferer INT NOT NULL AUTO_INCREMENT,
  name_offerer VARCHAR(45) NULL,
  lastname VARCHAR(45) NULL,
  nationality VARCHAR(45) NULL,
  email VARCHAR(45) NULL,
  phone VARCHAR(45) NULL,
  residence VARCHAR(45) NULL,
  login INT NOT NULL,
  PRIMARY KEY (idOfferer),
   CONSTRAINT fkOfferer FOREIGN KEY (login) REFERENCES Login(idLogin));




-- -----------------------------------------------------
-- Table  job
-- -----------------------------------------------------


CREATE TABLE Job (
  idJob INT NOT NULL AUTO_INCREMENT,
  name_Job VARCHAR(45) NULL,
  description_Job VARCHAR(45) NULL,
  salary INT NULL,
  type_Job VARCHAR(45) NULL,
  comp INT NOT NULL,
  status_Job INT NULL,
  PRIMARY KEY (idJob),
  CONSTRAINT fk_Job_Company
    FOREIGN KEY (comp)
    REFERENCES Company(idCompany));


-- -----------------------------------------------------
-- Table category
-- -----------------------------------------------------


CREATE TABLE Category (
  idCategory INT NOT NULL AUTO_INCREMENT,
  name_Category VARCHAR(45) NULL,
  parentCategory INT NULL,
  PRIMARY KEY (idCategory),
  CONSTRAINT fk_Category_Category1
    FOREIGN KEY (parentCategory)
    REFERENCES Category (idCategory));


-- -----------------------------------------------------
-- Table jobCategory
-- -----------------------------------------------------


CREATE TABLE jobCategory (
  percentage INT NULL,
  j INT NOT NULL,
  cat INT NOT NULL,
  PRIMARY KEY (j, cat),
  CONSTRAINT fk_JobCategory_Job1
    FOREIGN KEY (j)
    REFERENCES Job (idJob),
  CONSTRAINT fk_JobCategory_Category1
    FOREIGN KEY (cat)
    REFERENCES Category (idCategory));


-- -----------------------------------------------------
-- Table offerCategory
-- -----------------------------------------------------


CREATE TABLE offerCategory (
  percentage INT NULL,
  offer INT NOT NULL,
  cat INT NOT NULL,
  PRIMARY KEY (offer, cat),
  CONSTRAINT fk_OfferCategory_Offerer1
    FOREIGN KEY (offer)
    REFERENCES Offerer (idOfferer),
  CONSTRAINT fk_OfferCategory_Category1
    FOREIGN KEY (cat)
    REFERENCES Category (idCategory));
	
	-- -----------------------------------------------------
-- TValores para las tablas
-- -----------------------------------------------------
insert into Login(username,password,type_log,enable) values ('SYS_BDA','adm001','manager',1);
insert into Login(username,password,type_log,enable) values ('ICODER_CR','comp001','company',1);
insert into Login(username,password,type_log,enable) values ('ICAFE_CR','comp002','company',1);
insert into Login(username,password,type_log,enable) values ('INTEL_CO','comp003','company',1);
insert into Login(username,password,type_log,enable) values ('HP_INC','comp004','company',1);
insert into Login(username,password,type_log,enable) values ('SAMSUNG_INC','comp005','company',1);
insert into Login(username,password,type_log,enable) values ('MUNI_HERED','comp006','company',1);
insert into Login(username,password,type_log,enable) values ('andres_G','user001','offerer',1);
insert into Login(username,password,type_log,enable) values ('spidyxD','user002','offerer',1);
 
 insert into Manager (email,login) values ('BDA@system.com',1);
 
 insert into Company (name_company,email,phone,description,location_X,location_Y,address,login) values('ICODER','ICODER.COM','123456','KKKJJJJ',100.96,93.58,'',2);
 insert into Company (name_company,email,phone,description,location_X,location_Y,address,login) values('ICAFE','ICAFE.COM','2651556','CVDVEDVF',58.15,74.26,'',3);
 insert into Company (name_company,email,phone,description,location_X,location_Y,address,login) values('INTEL','INTEL.COM','1274513456','CDVGFD',89.25,24.36,'',4);
 insert into Company (name_company,email,phone,description,location_X,location_Y,address,login) values('HP','HP.COM','51165151','ERFVVD',561.58,15.36,'',5);
 insert into Company (name_company,email,phone,description,location_X,location_Y,address,login) values ('SAMSUNG','samsung.com','123456','Instituto del Cafe',835.36,58.12,'',6) ;
 insert into Company (name_company,email,phone,description,location_X,location_Y,address,login) values ('Municipalidad','muni@gmail.com','789456','MunicipalidadHeredia',45.36,12.45,'',7) ;
 
update Company set address ='SABANA' where idCompany = 6;
update Company set address ='SANTA BARBARA' where idCompany = 5;
update Company set address ='LAGUNILLA' where idCompany = 3;
update Company set address ='SANTA CECILIA' where idCompany = 4;
update Company set address ='HEREDIA' where idCompany = 2;
update Company set address ='BARVA' where idCompany = 1;

insert into Job (name_Job, description_Job,salary, type_Job, comp, status_Job) values('Designer','Designing is life',350000,'public',1, 1); 
insert into Job (name_Job, description_Job,salary, type_Job, comp, status_Job) values('Programmer','Junior Java',250000,'public',1,1);
insert into Job (name_Job, description_Job,salary, type_Job, comp, status_Job) values('DBA','Do not touch my data base',450000,'public',2, 1); 
insert into Job (name_Job, description_Job,salary, type_Job, comp, status_Job) values('Tecnical support','I can fix but is not free',550000,'public',2, 1); 
insert into Job (name_Job, description_Job,salary, type_Job, comp, status_Job) values('Developer','Junior Java',3750000,'public',3,1);

insert into Offerer (name_offerer, lastname, nationality, phone, email, residence,login) values ('Andres','Gutierrez','CR','61688613','a@gmail.com','Heredia',8);
insert into Offerer (name_offerer, lastname, nationality, phone, email, residence,login) values ('Roger','Amador','CR','83656107','r@gmail.com','Desamparados',9);

insert into Category (parentCategory,name_Category) values(null,'PROGRAMACION');-- 1
insert into Category (parentCategory,name_Category) values(null,'Diseño WEB');  -- 2
insert into Category (parentCategory,name_Category) values(null,'REDES'); -- 3 
insert into Category (parentCategory,name_Category) values(1,'JAVA');-- 4
insert into Category (parentCategory,name_Category) values(1,'C++');-- 5 
insert into Category (parentCategory,name_Category) values(2,'CSS');-- 6
insert into Category (parentCategory,name_Category) values(3,'CISCO');-- 7

insert into Category (parentCategory,name_Category) values(4,'JSON');-- 8
insert into Category (parentCategory,name_Category) values(6,'BOOTSTRAP');-- 9
insert into Category (parentCategory,name_Category) values(6,'MATERIALIZE');-- 10


insert into jobCategory (j, cat, percentage)values(1,5,85);
insert into jobCategory (j, cat, percentage)values(2,4,90);

insert into offerCategory (offer, cat, percentage)values(1,2,90);
insert into offerCategory (offer, cat, percentage)values(2,1,90);
