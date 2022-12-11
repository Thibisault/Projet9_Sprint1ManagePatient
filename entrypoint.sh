#!/bin/bash

mysql --user=root --password=thibault -h mysql-patient -e 'create database projet9sprint1managepatient;'


java -jar /home/Sprint1ManagePatient-0.0.1-SNAPSHOT.jar

