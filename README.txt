===============================================================================
          Mini-Patient Registry
===============================================================================

The Mini-Patient Registry is a demonstration of a simple patient cache using
the following technologies:
    Spring Boot
    JPA / Hibernate
    Sl4j
    JUnit and Mockito
    MySQL

I. Installation and Configuration

    1. Download the project from github: https://github.com/niuhuskies91/mini-pr
       This creates the following directory structure:
         <git project root>/
             /mini-pr/       ==> The application source code
             miniPr.sql      ==> Data schema creation DDL
             miniPr_drop.sql ==> Data schema drop DDL
             miniPr_data.sql ==> DDL to populate the schema with data
             README.txt      ==> This file
             settings.xml    ==> maven configuration file

    2. Install and configure MySQL (version 8.0.13+) with the 
       following credentials:
            user:     root
            password: Pa55word!
        Make sure MySQL is running locally

    3. Create the DB schema and seed the database with the DDL 
       provided in the github repo.
         a) run the DDL in miniPr.sql to create the schema
         b) run the DDL in miniPr_data.sql to seed the data

    4. Install the Java IDE of your choice. This project was created using
       STS (Spring Tool Suite). Make sure you are using JDK 1.8

    5. Please note the application project was created using maven so
       ensure your IDE has the maven plugin installed

    6. Crete the following under your file systems /Users/<your user>/
          directory:  /.m2

    7. Copy the settings.xml file (downloaded from the github repo)
       and place into: /Users/<your user>/.m2/

    *** Note: Steps 8 and 9 assume the IDE used is STS

    8. Import the mini-pr project into the IDE and do the following:
        a) right click on the mini-pr project
        b) select "Maven" ==> "Update Project..."
       This will download all of the maven dependencies and build the app

    9. Prepare the Boot Dashboard server
        a) Open the "Boot Dashboard" tab
        b) Under "local" locate "mini-pr"
        c) Right click on "mini-pr" ==> "Open Config"
        d) On the "Spring Boot" tab, select:
                Profile: "local"
            Click "Apply"

            This will tell STS boot dashboard to use the local profile
            configurations located in the project under:

            /src/main/resources/application-local.properties

            Note 1: if you change the RDBMS from MySQL or you change the
                    user credential you must modify this file.
            Note 2: if you change the RDBMS from MySQL you must
                    change the dependency in the pom.xml

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

III. Testing

    The Swagger endpoint is:  http://localhost:8080/mini-pr/swagger-ui.html

    Available services include:

        Get: /retrieval/sourceSystem/{sourceSystem}/mrn/{mrn} 

            where:
                {sourceSystem}:  (see II above)
                {mrn}:           (see II above)

            This endpoint performs a basic patient retrieval based on
            source system and mrn (eg., a PDQ). The result is a fully
            populated patient demographics response in JSon format.

IV. Appendices

    A. JUnit testing

        The Repository JUnit tests are integration and tied to the
        MySQL database being active. I did not have time to finish research
        mocking out the DB with XML data.

        Full code coverage scenarios have been provided for:

          1) Utility classes
          2) Mapper classes
          3) Service classes
          4) Jpa Repository classes
          5) Controller and ExceptionHandler classes

        The gap in in test coverage lies in areas:

          6) DTO and Model classes. Most of the code coverage gaps
             are the hashCode() and equals() methods generated in STS.
             There was just not enough time to provide full code and 
             scenario coverage for these.
       
    B. Notes of interest

      There is full bulletproofing so that no exceptions escape outside of
      the controller. An ExceptionHandler captures them and sets the appropriate
      Http Status code with generated error message. A simple test of this
      is to put invalid source system or MRN values in Swagger.

      Debug logging is enabled and there are two sets of output that will
      be printed to the log:
        - The full JSon response payload
        - Begin and end processing timestamps with time differential

      Hibernate is configured to log SQL to standard output.

    C. Wish list:

        Create an MLLP endpoint to accept an HL7 QBP^Q22 message.

        