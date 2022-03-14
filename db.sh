#!/bin/sh

sudo docker run \
    --name mariadb \
    --rm --detach \
    --env MARIADB_DATABASE=vepick \
    --env MARIADB_USER=admin \
    --env MARIADB_PASSWORD=admin \
    --env MARIADB_ROOT_PASSWORD=admin  \
    -p 6306:3306 \
    mariadb