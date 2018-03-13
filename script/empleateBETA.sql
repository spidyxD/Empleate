-- MySQL Workbench Forward Engineering

DROP IF EXISTS DATABASE empleateBETA;
CREATE DATABASE empleateBETA;
USE empleateBETA ;

DROP TABLE jobCategory;
DROP TABLE offerCategory;
DROP TABLE Job;
DROP TABLE Login;
DROP TABLE Category;
DROP TABLE Manager ;
DROP TABLE Company;
DROP TABLE Offerer;


-- -----------------------------------------------------
-- Table manager
-- -----------------------------------------------------


CREATE TABLE Manager (
  email VARCHAR(45) NULL,
  idManager INT NOT NULL,
  PRIMARY KEY ( idManager));


-- -----------------------------------------------------
-- Table Company
-- -----------------------------------------------------


CREATE TABLE Company (
  idCompany INT NOT NULL,
  name_company VARCHAR(45) NULL,
  email VARCHAR(45) NULL,
  phone VARCHAR(45) NULL,
  description VARCHAR(45) NULL,
  location POINT NULL,
  address VARCHAR(45) NULL,
  PRIMARY KEY (idCompany));


-- -----------------------------------------------------
-- Table  offerer
-- -----------------------------------------------------


CREATE TABLE Offerer( 
  idOfferer INT NOT NULL,
  name_offerer VARCHAR(45) NULL,
  lastname VARCHAR(45) NULL,
  nationality VARCHAR(45) NULL,
  email VARCHAR(45) NULL,
  phone VARCHAR(45) NULL,
  residence VARCHAR(45) NULL,
  PRIMARY KEY (idOfferer));


-- -----------------------------------------------------
-- Table  login
-- -----------------------------------------------------


CREATE TABLE Login (
  idLogin INT NOT NULL,
  username VARCHAR(45) NULL,
  password_log VARCHAR(45) NULL,
  type_Log VARCHAR(45) NULL,
  manag INT NOT NULL,
  comp INT NOT NULL,
  offer INT NOT NULL,
  PRIMARY KEY (idLogin),
  CONSTRAINT fk_Login_Manager1
    FOREIGN KEY (manag)
    REFERENCES  manager (idManager),
  CONSTRAINT fk_Login_Company1
    FOREIGN KEY (comp)
    REFERENCES  company (idCompany),
  CONSTRAINT fk_Login_Offerer1
    FOREIGN KEY (offer)
    REFERENCES  offerer (idOfferer));

-- -----------------------------------------------------
-- Table  job
-- -----------------------------------------------------


CREATE TABLE Job (
  idJob INT NOT NULL,
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
  idCategory INT NOT NULL,
  name_Category VARCHAR(45) NULL,
  categ INT NULL,
  PRIMARY KEY (idCategory),
  CONSTRAINT fk_Category_Category1
    FOREIGN KEY (categ)
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


 insert into Manager (idManager,email) values (001,'BDA@system.com');
 insert into Manager (idManager,email) values(002, 'm@gmail.com');
 
 insert into Company (idCompany,name_company,email,phone,description) values(006,'ICODER','ICODER.COM','123456','KKKJJJJ');
 insert into Company (idCompany,name_company,email,phone,description) values(005,'ICAFE','ICAFE.COM','2651556','CVDVEDVF');
 insert into Company (idCompany,name_company,email,phone,description) values(003,'INTEL','INTEL.COM','1274513456','CDVGFD');
 insert into Company (idCompany,name_company,email,phone,description) values(004,'HP','HP.COM','51165151','ERFVVD');
 insert into Company (idCompany,name_company,email,phone,description) values (001,'ICAFE','icafe@gmail.com','123456','Instituto del Cafe') ;
 insert into Company (idCompany,name_company,email,phone,description) values (002,'Municipalidad','muni@gmail.com','789456','MunicipalidadHeredia') ;
 
update Company set address ='SABANA' where idCompany = 006;
update Company set address ='SANTA BARBARA' where idCompany = 005;
update Company set address ='LAGUNILLA' where idCompany = 003;
update Company set address ='SANTA CECILIA' where idCompany = 004;
update Company set address ='HEREDIA' where idCompany = 002;

insert into Job (idJob, name_Job, description_Job,salary, type_Job, comp, status_Job) values(561,'Designer','Designing is life',350000,'private',001, 0); 
insert into Job (idJob, name_Job, description_Job,salary, type_Job, comp, status_Job) values(255,'Programmer','Junior Java',250000,'public',001,1);
insert into Job (idJob, name_Job, description_Job,salary, type_Job, comp, status_Job) values(124,'DBA','Do not touch my data base',450000,'pubic',002, 1); 
insert into Job (idJob, name_Job, description_Job,salary, type_Job, comp, status_Job) values(962,'Tecnical support','I can fix but is not free',550000,'private',002, 0); 
insert into Job (idJob, name_Job, description_Job,salary, type_Job, comp, status_Job) values(586,'Developer','Junior Java',3750000,'public',003,1);

insert into Offerer (idOfferer, name_offerer, lastname, nationality, phone, email, residence) values (111,'Andres','Gutierrez','CR','61688613','a@gmail.com','Heredia');
insert into Offerer (idOfferer, name_offerer, lastname, nationality, phone, email, residence) values (222,'Roger','Amador','CR','83656107','r@gmail.com','Desamparados');

insert into Category (idCategory, name_Category) values('506','JAVA');
insert into Category (idCategory, name_Category) values('896','BOOTSTRAP');

insert into jobCategory (j, cat, percentage)values(255,506,85);
insert into jobCategory (j, cat, percentage)values(561,896,90);

insert into offerCategory (offer, cat, percentage)values(111,506,90);
insert into offerCategory (offer, cat, percentage)values(222,896,90);