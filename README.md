# spring-store-2019

## How to Run

1. Install `docker`

2. create docker network
```
docker network create demo
```

3. Run infrastructures
```
cd infra
docker-compose up
```

4. Confirm infrastructures are up
```
curl localhost:9200
curl localhost:5601
```

5. Build and run services
```
cd services
./build.sh
docker-compose up
```

6. Open `http://localhost:8080` in browser
