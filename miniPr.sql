/*
    Create database schema

    Note: The code is defaulted to DB properties:
          url:  jdbc:mysql://localhost:3306
          user: root
          pswd: Pa55word!
*/
create database mini_pr;

/*
   Create tables
*/

-- ================================================
--    Enterprise patient ID
-- ================================================
create table mini_pr.MINI_PR_ENTERPRISE (
	EID           bigint (15) not null auto_increment primary key
);

-- ================================================
--    Local patient ID (eg., MRN)
-- ================================================
create table mini_pr.MINI_PR_LOCAL (
	MRN           varchar(32) not null,
	SOURCE_SYSTEM varchar(15) not null,
	primary key(MRN, SOURCE_SYSTEM)
);

-- ================================================
--    Relationship between MRN and Enterprise ID
-- ================================================
create table mini_pr.MINI_PR_ID_RELATIONSHIP (
	ID            bigint (15) not null auto_increment primary key,
	EID           bigint (15) not null,
	MRN           varchar(32) not null,
	SOURCE_SYSTEM varchar(15) not null
);

alter table mini_pr.MINI_PR_ID_RELATIONSHIP 
add foreign key fk_id_relationship_eid(EID) 
references mini_pr.MINI_PR_ENTERPRISE(EID) 
on delete no action
on update cascade;

ALTER TABLE mini_pr.MINI_PR_ID_RELATIONSHIP 
ADD CONSTRAINT fk_id_relationship_local 
FOREIGN KEY (MRN, SOURCE_SYSTEM) 
REFERENCES mini_pr.MINI_PR_LOCAL (MRN, SOURCE_SYSTEM);

-- ======================================================
--    Patient name(s): This is at the Enterprise ID level
--
--    Pretending the Use Case is the patient demographics
--    are available at the Enterprise level and not MRN 
-- ======================================================
create table mini_pr.MINI_PR_NAME (
	ID            bigint (15) not null auto_increment primary key,
	EID           bigint (15) not null, 
	LAST_NAME     varchar(30),
	FIRST_NAME    varchar(30),
	MIDDLE_NAME   varchar(30),
	SUFFIX        varchar(10),
	TITLE         varchar(10), 
	TYPE_CODE     varchar(5)   -- L, N, O, etc
);

alter table mini_pr.MINI_PR_NAME
add foreign key fk_name(EID) 
references mini_pr.MINI_PR_ENTERPRISE(EID) 
on delete no action
on update cascade;

-- ==========================================================
--    Patient address(s): This is at the Enterprise ID level
--
--    Pretending the Use Case is the patient demographics
--    are available at the Enterprise level and not MRN 
-- ==========================================================
create table mini_pr.MINI_PR_ADDRESS (
	ID            bigint (15) not null auto_increment primary key,
	EID           bigint (15) not null, 
	ADDRESS_LINE1 varchar(64),
	ADDRESS_LINE2 varchar(64), 
	CITY          varchar(64),
	STATE         varchar(10),
	POSTAL_CODE   varchar(12),
	COUNTRY       char(3),
    TYPE          char(3),     -- P, M, H, etc
    COUNTY        varchar(20) 
);

alter table mini_pr.MINI_PR_ADDRESS
add foreign key fk_address(EID) 
references mini_pr.MINI_PR_ENTERPRISE(EID) 
on delete no action
on update cascade;

-- ==========================================================
--    Patient telecom(s): This is at the Enterprise ID level
--
--    Pretending the Use Case is the patient demographics
--    are available at the Enterprise level and not MRN 
-- ==========================================================
create table mini_pr.MINI_PR_TELECOM (
    ID         bigint(15) not null auto_increment primary key,
	EID        bigint(15) not null, 
    USE_CODE   char(3),     -- PRN, WPN, etc
    TYPE_CODE  varchar(10),  -- PH, FX, Internet, etc
    VALUE      varchar(60) not null
);

alter table mini_pr.MINI_PR_TELECOM
add foreign key fk_telecom(EID) 
references mini_pr.MINI_PR_ENTERPRISE(EID) 
on delete no action
on update cascade;

-- ==========================================================
--    Patient demographics: This is at the Enterprise ID level
--
--    Pretending the Use Case is the patient demographics
--    are available at the Enterprise level and not MRN 
-- ==========================================================
create table mini_pr.MINI_PR_DEMOGRAPHICS (
    ID             bigint(15) not null auto_increment primary key,
	EID            bigint(15) not null, 
	DOB            date,   -- Date of Birth
	GENDER         char(1),
	RACE           varchar(10),
	MARITAL_STATUS char(1),
	RELIGION       varchar(10),
	SSN            varchar(11),
	DEATH_IND      char(1),  -- Y (1) or N / null (0)
	DOD            date      -- Date of Death
);

alter table mini_pr.MINI_PR_DEMOGRAPHICS
add foreign key fk_demographics(EID) 
references mini_pr.MINI_PR_ENTERPRISE(EID) 
on delete no action
on update cascade;