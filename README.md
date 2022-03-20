# Coin Analyst
Flink based coin analysis

# How to Run?

## Flink application
### Build fink application
```sh
cd coinanalyst
mvn clean install -DskipTests
cp coinanalyst/target/coinanalyst-1.0-SNAPSHOT.jar ./ 
```

## Flink cluster
### Build docker & run
```sh
docker build -t flink .
docker run -it -p 8081:8081 flink /bin/bash
```
You have to bind port on 8081 for flink web ui

### Start flink cluster
```sh
# This is a flink container 
./bin/start-cluster.sh
```

### Submit flink job
```sh
# This is a flink container
./bin/flink run coinanalyst-1.0-SNAPSHOT.jar
```

### Access web UI
You can access flink [web UI](http://127.0.0.1:8081/)

# Reference
[Arache Flink Documentation](https://nightlies.apache.org/flink/flink-docs-release-1.14/)
