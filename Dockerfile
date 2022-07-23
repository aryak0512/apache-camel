FROM openjdk:11

# this will be the root folder inside the image file system
WORKDIR /spring-boot-camel

# copy local system files to image base directory
COPY . .

EXPOSE 8081

ADD target/*.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]