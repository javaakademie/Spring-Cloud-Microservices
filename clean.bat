@echo.
@REM Discovery/Eureka-Server
@cd ./discovery-service
@echo Clean Discovery Service...
@call mvn -q clean

@REM Comic-Service
@echo Clean Comic Service...
@cd ../comic-service
@call mvn -q clean

@REM User-Service
@echo Clean User Service...
@cd ../user-service
@call mvn -q clean

@REM Gateway/Edge-Service
@echo Clean Gateway Service...
@cd ../gateway-service
@call mvn -q clean

@REM Zipkin-Service
@echo Clean Zipkin Service...
@cd ../zipkin-service
@call mvn -q clean

@cd ..
@echo.
@echo DONE!
@echo.

