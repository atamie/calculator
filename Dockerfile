FROM openjdk:11
COPY ./target/calculator-0.0.1-SNAPSHOT.jar /usr/local/src/calculator/ 
WORKDIR /usr/local/src/calculator
EXPOSE 8080
CMD ["java", "-jar", "calculator-0.0.1-SNAPSHOT.jar"]


