/*
    In case the schema needs to be recreated...
*/


/*
   Drop FK indexes
*/

alter table mini_pr.MINI_PR_ID_RELATIONSHIP 
drop foreign key fk_id_relationship_eid;

alter table mini_pr.MINI_PR_ID_RELATIONSHIP 
drop foreign key fk_id_relationship_local;

alter table mini_pr.MINI_PR_NAME
drop foreign key fk_name;

alter table mini_pr.MINI_PR_ADDRESS
drop foreign key fk_address;

alter table mini_pr.MINI_PR_TELECOM
drop foreign key fk_telecom;

alter table mini_pr.MINI_PR_DEMOGRAPHICS
drop foreign key fk_demographics; 

/*
   Drop tables
*/

drop table mini_pr.MINI_PR_ENTERPRISE;
drop table mini_pr.MINI_PR_LOCAL;
drop table mini_pr.MINI_PR_ID_RELATIONSHIP;
drop table mini_pr.MINI_PR_NAME;
drop table mini_pr.MINI_PR_ADDRESS;
drop table mini_pr.MINI_PR_TELECOM;
drop table mini_pr.MINI_PR_DEMOGRAPHICS;