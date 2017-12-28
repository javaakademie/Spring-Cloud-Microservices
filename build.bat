@echo.
@REM Discovery/Eureka-Server
@cd ./discovery-service
@echo Build Discovery Service...
@call mvn -q clean install -DskipTests 

@REM Comic-Service
@echo Build Comic Service...
@cd ../comic-service
@call mvn -q clean install -DskipTests 

@REM User-Service
@echo Build User Service...
@cd ../user-service
@call mvn -q clean install -DskipTests

@REM Gateway/Edge-Service
@echo Build Gateway Service...
@cd ../gateway-service
@call mvn -q clean install -DskipTests

@REM Zipkin-Service
@echo Build Zipkin Service...
@cd ../zipkin-service
@call mvn -q clean install -DskipTests

@cd ..
@echo.
@echo DONE!
@echo.

