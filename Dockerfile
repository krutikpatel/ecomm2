FROM eclipse-temurin:17-jdk-jammy
COPY target/productsapp-0.0.1-SNAPSHOT.jar productsapp-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/productsapp-0.0.1-SNAPSHOT.jar"]

