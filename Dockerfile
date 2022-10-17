FROM mcr.microsoft.com/java/jdk:11-zulu-ubuntu
CMD  java ${JAVA_OPTS} -jar myTraining-0.1-all.jar
COPY build/libs/*-all.jar myTraining-0.1-all.jar