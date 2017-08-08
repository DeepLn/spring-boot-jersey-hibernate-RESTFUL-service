# spring-boot-jersey-hibernate-RESTFUL-service
pure RESTFUL service with spring-boot and jersey and hibernate,comfortable with seed of your RESTFUL service


1. environment
```
1) JDK1.8 installed
2) maven installed
3) mysql installed
4) curl installed (for test)
```

2. mysql config 
```
mysql -uxxx -pxx ... create database with command "create database database_name"
```

3. package
```
1) cd /tmp
2) git clone https://github.com/DeepLn/spring-boot-jersey-hibernate-RESTFUL-service.git
3) cd spring-boot-jersey-hibernate-RESTFUL-service/
4) config your mysql database_name&&user&&password in the file src/main/resources/application.properties
5) mvn package
```

4. run
```
java -jar target/dou-api-0.0.1-SNAPSHOT.jar
```

5. test
```
1) register a user: curl -l -H "Content-type: application/json" -X POST -d '{"mobile":"17777777777","password":"mypassword"}' http://localhost:8080/user/register
Result: {"code":"200","apiKey":"oK0ULpCs","apiSecret":"Dybmj1qZtWfm0wNh5VS1VYtA","message":"OK"}

2) login: curl -l -H "Content-type: application/json" -X POST -d '{"mobile":"17777777777","password":"mypassword"}' http://localhost:8080/user/login
Result: {"code":"200","apiKey":"oK0ULpCs","apiSecret":"Dybmj1qZtWfm0wNh5VS1VYtA","message":"OK"}

3) add a client(admin only): curl -l -H "Content-type: application/json" -X POST -d '{"clientId":"10001-01-0A-123456789", "topic": "topic","sdkName": "sdk name","sdkVersion": "sdk version"}' -H "apiKey:3Au6Ayp3" -H "apiSecret:QYsmF8C92pvWsJGaHV66fSgikYzHTBhs" http://localhost:8080/client/add

4) query a client(general user): curl -l -H "Content-type: application/json" -X POST -d '{"clientId":"10001-01-0A-123456789"}' -H "apiKey:oK0ULpCs" -H "apiSecret:Dybmj1qZtWfm0wNh5VS1VYtA" http://localhost:8080/client/property
```

5) also you can open your browser and input the url: http://localhost:8080/user/sample
