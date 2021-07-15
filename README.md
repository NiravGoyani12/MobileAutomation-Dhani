# dhani-qa-app
Test project with automated tests for the Dhani mobile application

#Test project repository :
https://github.com/TSVPRDREPO/dhani-qa-app

#Software Stacks to automate application for both Windows and Mac: 

- System under testing: stable version
- Intellij
- Android Studio 
- ADB Device or Physical Android Device
- [Appium](https://appium.io/)
- Jdk - 1.8+
- Maven-2.3+
- Git
- [Vysor](https://www.vysor.io/)
- node
- Appium via Node (node install -g appium)


# One-time configuration for Windows
1. Clone the project using above git url provided.
2. Set the jdk for the application .
3. Build the project using Maven locally for dependency management\
4. Set Appium Server path and Node.exe path in AppiumServer class as installed on local system  
   Appium Server Path -> .withLogFile(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\logs\\log.txt"))
   Node.exe Path -> new AppiumServiceBuilder().usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
5. Set the environment variables
    - Set ANDROID_HOME, MAVEN_HOME and JAVA_HOME environment variables according to OS availability
6. Set the Device capabilities in Android_dhaniApp.properties files for below variables
   Update operating.system=windows
   platform.name= ?
   device.name=Redmi ?
   platform.version= ?
7. Start ADB device locally or connect physical device using vysor.
8. Run RunSanityTest cukes to start running test cases.


# One-time configuration for Mac
1. Clone the project using above git url provided.
2. Set the jdk for the application .
3. Build the project using Maven locally for dependency management
4. Set Appium Server path and Node.exe path in AppiumServer class as installed on local system  
   .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
   Node.exe Path -> new AppiumServiceBuilder().usingDriverExecutable(new File("/usr/local/bin/node")
5. Set the environment variables
   - Set ANDROID_HOME and JAVA_HOME environment variables like
     1. vi ~/.zshrc
     2. press i and copy below contents into that file
     export JAVA_HOME=$(/usr/libexec/java_home -v 1.8)
     export ANDROID_HOME=~/Library/Android/sdk
     export PATH=$PATH:$ANDROID_HOME/tools:$ANDROID_HOME/platform-tools
     3. press esc wq!
     4. press enter
     5. source ~/.zshrc
6. Set the Device capabilities in Android_dhaniApp.properties files for below variables
   Update operating.system=mac
   platform.name= ?
   device.name=Redmi ?
   platform.version= ?
7. Start ADB device locally or connect physical device using vysor.
8. Run RunSanityTest cukes to start running test cases.

# Report Generation InteliJ
Run main class RunSanityTest or other test runner file.
   - After test run completion, the report can be found under the `target\cucumber-reports` folder.
   - Application level logging can be found under the `resources\logs` folder.
   
## Run tests via Command Line with Maven for both OS
mvn test 



