# Spring Boot Microservices

Dieses Beispiel zeigt eine Microservices-Architektur auf Basis von Spring Boot und Spring Cloud. Für detaillierte Erklärungen sei auf den Blog-Eintrag  [Microservices-Architektur mit Spring Boot](http://Java-Akademie.de/blog/spring-cloud-microservices) verwiesen.

## Bauen und Starten der Anwendung

Alle Microservices sind als Maven-Projekte angelegt und können wie folgt gebaut und gestartet werden.

### Eureka-Server
```
cd discovery-service
mvn -q clean install spring-boot:run
```

### Comic-Service
```
cd comic-service
mvn -q clean install spring-boot:run
```

### User-Service
```
cd user-service
mvn -q clean install spring-boot:run
```

### Edge-Service
```
cd gateway-service
mvn -q clean install spring-boot:run
```

### Zipkin-Service
```
cd zipkin-service
mvn -q clean install spring-boot:run
```

## Aufruf der Anwendung

### Eureka-Server
http://localhost:8761/

### Comic-Service
http://localhost:2222
http://localhost:2222/comics
http://localhost:2222/comics/{id}

### User-Service
http://localhost:3333
http://localhost:3333/users
http://localhost:3333/users/{id}

### Edge-Service
http://localhost:8765/api/comicsrv
http://localhost:8765/api/comicsrv/comics
http://localhost:8765/api/comicsrv/comics/{id}
http://localhost:8765/api/usersrv/users
http://localhost:8765/api/usersrv/users/{id}

### Zipkin-Service
http://localhost:9411

## Links

* [Blog zum Code](http://Java-Akademie.de/blog/spring-cloud-microservices)



