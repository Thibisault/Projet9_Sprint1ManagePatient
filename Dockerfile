#
# Build stage
#
FROM maven:3.8.5-openjdk-17-slim AS build
WORKDIR /home
COPY src /home/src
COPY target/ /home/target
# COPY /home/app/target/projet9sprint1managepatient-0.0.1-SNAPSHOT.jar /
# COPY Sprint1ManagePatient-0.0.1-SNAPSHOT.jar /
COPY pom.xml /home
RUN mvn clean -B package
# RUN mvn surefire-report:report


#
# Package stage
#
# FROM openjdk:17-jdk-slim-buster
# WORKDIR src /home/app
# COPY --from=build /home/app/target/projet9sprint1managepatient-0.0.1-SNAPSHOT.jar .
# COPY /home/app/target/projet9sprint1managepatient-0.0.1-SNAPSHOT.jar ./projet9sprint1managepatient
EXPOSE 8080
# ENTRYPOINT ["java","-jar","/projet9sprint1managepatient.jar"]
ENTRYPOINT ["/bin/bash"]