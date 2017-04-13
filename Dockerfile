FROM java:8-alpine
MAINTAINER Your Name <you@example.com>

ADD target/uberjar/quickshare2.jar /quickshare2/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/quickshare2/app.jar"]
