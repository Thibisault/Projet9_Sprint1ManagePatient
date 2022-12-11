#
# Build stage
#
FROM maven:3.8.5-openjdk-17-slim AS build
WORKDIR /home
COPY src /home/src
COPY target/ /home/target
COPY pom.xml /home
RUN \
   sed -i -e 's/localhost:3306/mysql-patient:3306/g'\
    /home/src/main/resources/application.properties
RUN mvn clean -B package -D maven.test.skip=true

# RUN mvn surefire-report:report


#
# Package stage
#
FROM openjdk:17-jdk-slim-buster
WORKDIR /home
COPY --from=build /home/target/Sprint1ManagePatient-0.0.1-SNAPSHOT.jar /home
COPY entrypoint.sh /
RUN \
    apt-get update -y;\
    apt-get install -y default-mysql-client;\
    chmod ugo+rx /entrypoint.sh
EXPOSE 8081
ENTRYPOINT ["/entrypoint.sh"]