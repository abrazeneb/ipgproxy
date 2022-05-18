FROM adoptopenjdk/openjdk14 AS build
MAINTAINER Henok Solomon Sebsibe "h.sebeside@sepa-cyber.com"
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY build.gradle settings.gradle gradlew $APP_HOME
COPY gradle $APP_HOME/gradle
COPY src $APP_HOME/src
RUN chmod +x gradlew
RUN ls -la
RUN ./gradlew clean && ./gradlew build || return 0


FROM adoptopenjdk/openjdk14
COPY --from=build /usr/app/build/libs/*.jar /usr/app/

# The microservice name OR k8s pod id  where this sidecar services will be deployed
ENV SERVICE_NAME=test_microservice
# Postgres SQL server IP or Host
ENV DB_HOST=127.0.0.1
# Postgres SQL server port
ENV DB_PORT=5432
# Postgres SQL Database Name (Note that the specified database needs to be created before running any image of this docker file
ENV DB_NAME=tenant_manager
#Postgres SQL connection username
# (Note that the specified DB user needs to be created before running any image of this docker file
ENV DB_USERNAME=tenant_manager
#Postgres SQL connection password
ENV DB_PASSWORD=password
# Redis Server IP or Host
ENV REDIS_HOST=127.0.0.1
# Redis Server Port
ENV REDIS_PORT=6379


EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/app/config-sidecar.jar"]
