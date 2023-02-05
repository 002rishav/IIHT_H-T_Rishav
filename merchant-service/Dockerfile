ARG REPO=527488999673.dkr.ecr.us-east-1.amazonaws.com
FROM ${REPO}/openjdk11:11
EXPOSE 9090
ADD target/Merchant-Service.jar Merchant-Service.jar
ENTRYPOINT ["java","-jar","/Merchant-Service.jar"]