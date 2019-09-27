docker build --target=base -t store-ui/base .
docker run --rm -p 8080:8000 store-ui/base
