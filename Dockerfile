FROM bellsoft/liberica-openjdk-debian:17.0.8
ADD target/StocksFeedAPI-1.0.jar StocksFeedAPI-1.0.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "StocksFeedAPI-1.0.jar"]
