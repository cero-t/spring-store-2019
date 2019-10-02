FROM docker.elastic.co/beats/metricbeat:7.3.2

COPY metricbeat.yml /usr/share/metricbeat/metricbeat.yml
COPY modules.d/ /usr/share/metricbeat/modules.d

USER root
RUN chown root:metricbeat /usr/share/metricbeat/metricbeat.yml
RUN chmod 644 /usr/share/metricbeat/metricbeat.yml
RUN chown -R root:metricbeat /usr/share/metricbeat/modules.d
RUN chmod -R 644 /usr/share/metricbeat/modules.d

USER metricbeat
