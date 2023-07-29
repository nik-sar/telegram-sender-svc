FROM amazoncorretto:17.0.7-al2-generic

COPY ./build/libs/telegram-sender-svc-0.0.1-SNAPSHOT-plain.jar /usr/app.jar
WORKDIR /usr
EXPOSE 8080

CMD ["java", "-jar", "app.jar"]