#!/usr/bin/env bash

docker run -it --rm \
-e JPDA_ADDRESS=8000 \
-e JPDA_TRANSPORT=dt_socket \
-p 8080:8080 -p 8000:8000 \
-v `pwd`/../target:/usr/local/tomcat/webapps/ \
tomcat:8.0 \
/usr/local/tomcat/bin/catalina.sh jpda run
