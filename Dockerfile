FROM openjdk:8
ADD target/restApp-0.0.1-SNAPSHOT.jar restApp-0.0.1-SNAPSHOT.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","restApp-0.0.1-SNAPSHOT.jar"]