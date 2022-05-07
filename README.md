# syed_islam_teladoc_challenge

Operating System: Mac

**Basic setup **
Tool: Eclipse
Language: Java, Selenium
Framework:Cucumber
Maven Project
Add depenedencies in pom.xml
And do maven clean build
Install Cucumber plugin from Eclipse market place
Add Selenium libraries 

# To run the script


Intitally it will run on chrome.
If you hav to use firefox driver: Change browser name to firefox in config.properties file under config package.

Step to follow: Go to TestRunner(TestRunner.java) Class, rightclick and go to Run As. 
First it will go to the feature file which is adduser.feature.
Will map with the step definitions file which is addUser.java.
The testbase.java has all the methods which are being called in the step definitions class.
Report is being generated in xml format.
Screenshots are being stored under traget-> screenshot folfer
