docker run \
  --volume="$(pwd)/kibana:/usr/share/metricbeat/kibana:ro" \
  --net="host" \
  docker.elastic.co/beats/metricbeat:7.3.2 setup --dashboards
