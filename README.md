# server

docker run -p 8080:8080 ZERL/server

docker build --platform="linux/arm64" --build-arg JAR_FILE=target/*.jar -t myorg/myapp .