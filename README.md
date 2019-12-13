# spring-store-2019

## How to Run

1. Install `java11` and `docker`, `docker-compose`

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
curl localhost:5601 -i
```

5. Create Kibana dashboard (only for initialization)
```
cd infra/metricbeat_dashboard
./create_dashboard.sh
```

6. Build and run services
```
cd services
./build.sh
docker-compose up
```

7. Open `http://localhost:8761` in browser and check all services are available

8. Open `http://localhost:8080` in browser
