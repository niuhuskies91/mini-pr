/*
    Create sample data
*/


-- ================================================
--    Enterprise patient ID
-- ================================================

insert into mini_pr.MINI_PR_ENTERPRISE 
	(EID)
values (10000000001);

insert into mini_pr.MINI_PR_ENTERPRISE 
	(EID)
values (10000000002);

-- ================================================
--    Local patient ID (eg., MRN)
-- ================================================

insert into mini_pr.MINI_PR_LOCAL
	(MRN, SOURCE_SYSTEM)
values ('ABC1000001', 'ABC');

insert into mini_pr.MINI_PR_LOCAL
	(MRN, SOURCE_SYSTEM)
values ('ABC1000002', 'ABC');

insert into mini_pr.MINI_PR_LOCAL
	(MRN, SOURCE_SYSTEM)
values ('XYZ1000001', 'XYZ');

insert into mini_pr.MINI_PR_LOCAL
	(MRN, SOURCE_SYSTEM)
values ('XYZ1000002', 'XYZ');

-- ================================================
--    Relationship between MRN and Enterprise ID
-- ================================================

insert into mini_pr.MINI_PR_ID_RELATIONSHIP
	(EID, MRN, SOURCE_SYSTEM) 
values (10000000001, 'ABC1000001', 'ABC');

insert into mini_pr.MINI_PR_ID_RELATIONSHIP
	(EID, MRN, SOURCE_SYSTEM) 
values (10000000001, 'XYZ1000001', 'XYZ');

insert into mini_pr.MINI_PR_ID_RELATIONSHIP
	(EID, MRN, SOURCE_SYSTEM) 
values (10000000002, 'ABC1000002', 'ABC');

insert into mini_pr.MINI_PR_ID_RELATIONSHIP
	(EID, MRN, SOURCE_SYSTEM) 
values (10000000002, 'XYZ1000002', 'XYZ');


-- ======================================================
--    Patient name(s): This is at the Enterprise ID level
--
--    Pretending the Use Case is the patient demographics
--    are available at the Enterprise level and not MRN 
-- ======================================================

insert into mini_pr.MINI_PR_NAME 
	(EID, LAST_NAME, FIRST_NAME, MIDDLE_NAME, SUFFIX, TITLE, TYPE_CODE) 
values (10000000001, 'Doe', 'John', 'C', 'Jr', 'Mr', 'L');

insert into mini_pr.MINI_PR_NAME 
	(EID, LAST_NAME, FIRST_NAME, TYPE_CODE) 
values (10000000002, 'Doe', 'Jane', 'L');

-- ==========================================================
--    Patient address(s): This is at the Enterprise ID level
--
--    Pretending the Use Case is the patient demographics
--    are available at the Enterprise level and not MRN 
-- ==========================================================

insert into mini_pr.MINI_PR_ADDRESS 
	(EID, ADDRESS_LINE1, ADDRESS_LINE2, CITY, STATE, POSTAL_CODE, COUNTRY, TYPE, COUNTY) 
values (10000000001, '1060 W Addison St', 'Suite 100', 'Chicago', 'IL', '60613', 'USA', 'H', 'Cook');

insert into mini_pr.MINI_PR_ADDRESS 
	(EID, ADDRESS_LINE1, ADDRESS_LINE2, CITY, STATE, POSTAL_CODE, COUNTRY, TYPE) 
values (10000000002, '1600 Pennsylvania Ave', 'Oval Office', 'Washington', 'DC', '20500', 'USA', 'H');

-- ==========================================================
--    Patient telecom(s): This is at the Enterprise ID level
--
--    Pretending the Use Case is the patient demographics
--    are available at the Enterprise level and not MRN 
-- ==========================================================

insert into mini_pr.MINI_PR_TELECOM 
	(EID, USE_CODE, TYPE_CODE, VALUE) 
values(10000000001, 'PRN', 'PH', '5555551001');

insert into mini_pr.MINI_PR_TELECOM 
	(EID, USE_CODE, TYPE_CODE, VALUE) 
values(10000000001, 'PRN', 'Internet', 'john.doe@whoami.net');

insert into mini_pr.MINI_PR_TELECOM 
	(EID, USE_CODE, TYPE_CODE, VALUE) 
values(10000000002, 'PRN', 'PH', '5555555555');

insert into mini_pr.MINI_PR_TELECOM 
	(EID, USE_CODE, TYPE_CODE, VALUE) 
values(10000000002, 'PRN', 'Internet', 'jane.doe@whitehouse.gov');

-- ==========================================================
--    Patient demographics: This is at the Enterprise ID level
--
--    Pretending the Use Case is the patient demographics
--    are available at the Enterprise level and not MRN 
-- ==========================================================

insert into mini_pr.MINI_PR_DEMOGRAPHICS 
	(EID, DOB, GENDER, RACE, MARITAL_STATUS, RELIGION, SSN, DEATH_IND, DOD) 
values(10000000001, str_to_date('06/04/1969', '%m/%d/%Y'), 'M', '2106-3',
       'M', 'ATH', '999-99-9999', 'Y', str_to_date('06/04/2009', '%m/%d/%Y'));

insert into mini_pr.MINI_PR_DEMOGRAPHICS 
	(EID, DOB, GENDER, RACE, MARITAL_STATUS, RELIGION, SSN, DEATH_IND) 
values(10000000002, str_to_date('07/09/1999', '%m/%d/%Y'), 'F', '2106-3',
       'S', 'ATH', '999-99-9999', 'N');

