FROM amazoncorretto:17.0.7-al2-generic
LABEL org.opencontainers.image.source=https://github.com/nik-sar/telegram-sender-svc
COPY ./build/libs/telegram-sender-svc-0.0.1-SNAPSHOT.jar /usr/app.jar
WORKDIR /usr
EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
