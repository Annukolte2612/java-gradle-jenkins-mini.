# Mini Task Tracker (Java + Gradle + Git + Jenkins)

A small in-memory command-line task tracker for learning Java builds, Git and Jenkins CI. The Gradle 8.14.3 Wrapper is included, so a separate Gradle installation is not required. A JDK 17+ is required. The project compiles Java 17-compatible bytecode.

## Build and run on Windows

Open Command Prompt or PowerShell in this project folder and run:

```cmd
gradlew.bat --version
gradlew.bat clean build
gradlew.bat run --args="demo"
```

The first command downloads Gradle 8.14.3 into the Gradle user cache. The demo adds two tasks, completes one, and prints them. Tasks are stored in memory and reset when the program exits.

On Linux or macOS, run `./gradlew --version`, `./gradlew clean build`, and `./gradlew run --args="demo"`.

## Git

```sh
git init
git add .
git commit -m "Create Gradle task tracker"
```

Push the repository to your Git server, then create a Jenkins Pipeline job configured to use that repository and its `Jenkinsfile`.

## Jenkins

Configure a JDK 17+ on the Jenkins agent. The Jenkinsfile uses the included Gradle Wrapper on Windows, Linux, or macOS and archives the generated JAR from `build/libs/`.
