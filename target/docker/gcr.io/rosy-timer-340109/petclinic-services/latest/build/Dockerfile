FROM docker.io/library/adoptopenjdk:11-jre-hotspot
EXPOSE 8080
COPY maven /maven/
ENTRYPOINT ["java","-jar","/maven/petclinic-services-1.0-SNAPSHOT.jar"]
