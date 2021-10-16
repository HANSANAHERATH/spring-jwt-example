FROM java:8
WORKDIR /

ADD ./target/spring-jwt-example-0.0.1-SNAPSHOT.jar spring-jwt-example-0.0.1-SNAPSHOT.jar

EXPOSE 8085

ENTRYPOINT ["java","-jar","/spring-jwt-example-0.0.1-SNAPSHOT.jar"]
