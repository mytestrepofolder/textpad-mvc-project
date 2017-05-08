Online TextPad App (Read ME)
=====================================================================

Tools Used:
�	1. Java (1.8.0_91)
�	2. Spring Tool Suite
�	3. Maven
�	4. Spring MVC
�	5. HSQL Embedded DB
�	6. Tomcat 7
�	7. BootStrap


Solution Outline:.
�	This is an online web app using which allows an user to add/edit text to a persistant store(HSQL). 
�	User can enter a Text Title (Max 50 char) and Description (Max 500) for the text which is saved to the DB by cliking on Save button. This title and text limit can be increased by modifying the insert Basic form validation for "null" check is provided on this fields.
�   This app also calculates diffictulty level of the Text entereted in the description field using fog index readability.

Build and Run Instructions :

Using Command Prompt :
�	Download the contents from GitHub  (This already contains the executable WAR available)
�	Extract the content into a directory on your machine. This should create a directory named 'textpad-mvc-project�`
�	Execute following maven command to create an executable WAR `mvn clean install`. This command will create a WAR with name like  �TextPadDemo.war� in $root_dir/company-car-webservices/target directory
�	Deploy this WAR in your TOMCAT. 
�	The application can be accessed at the path : "http://localhost:8080/TextPadDemo/textpadlist"


Build Using Eclipse :

�	If you are building this app from Eclipse then follow these steps : 
o	Install Maven plugin in your Eclipse if not there already.
o	Import the project as an Existing Maven Project
o	Build using Project -> Build Project
o	Then right click on the project -> Run As -> Maven Build (clean install)
