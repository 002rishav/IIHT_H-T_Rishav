ARG REPO=527488999673.dkr.ecr.us-east-1.amazonaws.com
FROM ${REPO}/openjdk11:11
EXPOSE 8087
ADD target/Product-Service.jar Product-Service.jar
ENTRYPOINT ["java","-jar","/Product-Service.jar"]