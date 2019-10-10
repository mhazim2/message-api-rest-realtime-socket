# Readme

### How to Run
Requirements:
* Java 11

Command to run, (move to root project directory):
* Linux: `./gradlew bootRun`
* Windows: `gradlew.bat bootRun`

Application run on http://localhost:8080/

Endpoint:
* [POST] http://localhost:8080/api/message
  Body: `{"message": "Your Message"}`
* [GET] http://localhost:8080/api/message
