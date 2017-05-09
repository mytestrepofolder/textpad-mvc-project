Online Text Pad App (Read ME)
=====================================================================

Tools Used:
•	Java (1.8.0_91)
•	Spring Tool Suite
•	Maven
•	Spring MVC
•	HSQL Embedded DB
•	Tomcat 7.0.72
•	BootStrap


Solution Outline:.
o	This is an online web app using which allows an user to add/edit text to a persistent store(HSQL). 
o	User can enter a Text Title (Max 50 char) and Description (Max 500) for the text which is saved to the DB by clicking on Save button. This title and text limit can be increased by modifying the insert Basic form validation for "null" check is provided on this fields.
o	This app also calculates difficulty level of the Text entered  in the description field using fog index readability.
o	Added the option to detlete individual texts in the list.

Build and Run Instructions:

•	Using Command Prompt:
o	Download the contents from GitHub.
o	Extract the content into a directory on your machine. This should create a directory named 'textpad-mvc-project
o	Execute following maven command to create an executable WAR `mvn clean install`. 
o	This command will create a WAR with name like “TextPadDemo.war” in $root_dir/company-car-webservices/target directory
o	Deploy this WAR in your TOMCAT. 
o	The application can be accessed at the path : "http://localhost:8080/TextPadDemo/textpadlist"


Build Using Eclipse :

o	If you are building this app from Eclipse then follow these steps : 
o	Install Maven plugin in your Eclipse if not there already.
o	Import the project as an Existing Maven Project
o	Build using Project -> Build Project
o	Then right click on the project -> Run As -> Maven Build (clean install)
