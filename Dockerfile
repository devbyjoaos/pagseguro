FROM openjdk:11
EXPOSE 8080
ADD target/pagseguro.jar pagseguro.jar
ENTRYPOINT ["java", "-jar", "/pagseguro.jar"]