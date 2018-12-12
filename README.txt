===============================================================================
   Installation and Usage Instructions of the Mini-Patient Registry
===============================================================================

I. Files and Directories

    /mini-pr         : Application source code
    miniPr.sql       : The database schema creation DDL
    miniPr_drop.sql  : DDL to drop the schema tables
    miniPr_data.sql  : Patient data to load into the schema

II. Test patients:
    
    There are are two source systems: ABC, XYZ

    The id relationships are as follows:

    -----------------------------------------------------
    | EID (enterprise) | Source System | MRN (local id) |
    |------------------|---------------|----------------|
    | 10000000001      |  ABC          | ABC1000001     |
    |------------------|---------------|----------------|
    | 10000000001      |  XYYZ         | XYZ1000001     |
    |------------------|---------------|----------------|
    | 10000000002      |  ABC          | ABC1000002     |
    |------------------|---------------|----------------|
    | 10000000002      |  XYYZ         | XYZ1000002     |
    |------------------|---------------|----------------|

III. Database

    The application is configured to use MySQL. The DB properties 
    from application-local.properties include:

        spring.datasource.url = jdbc:mysql://localhost:3306/mini_pr?....
        spring.datasource.username = root
        spring.datasource.password = Pa55word!

IV. Development environment

    This was developed using STS (Spring Tool Suite), but should run
    on any IDE.

    Dependency management is maven.

V. Testing

    The Swagger endpoint is:  http://localhost:8080/mini-pr/swagger-ui.html
        Test parameters:
            sourceSystem:  (see II above)
            mrn:           (see II above)

    There is full bulletproofing so that no exceptions escape outside of
    the controller. An ExceptionHandler captures them and sets the appropriate
    Http Status code with generated error message. A simple test of this
    is to put invalid source system or MRN values in Swagger.

    Debug logging is enabled and there are two sets of output that will
    be printed to the log:
        - The full JSon response payload
        - Begin and end processing timestamps with time differential
