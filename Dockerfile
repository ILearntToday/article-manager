FROM openjdk:8
EXPOSE 8888
ADD target/article-manager-docker.jar article-manager-docker.jar
ENTRYPOINT ["java","-jar","/article-manager-docker.jar"]

