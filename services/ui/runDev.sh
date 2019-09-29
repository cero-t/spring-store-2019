docker build --target=base -t store-ui/base .
docker run --rm -p 8000:8000 store-ui/base
