#!/bin/bash


if docker info 2>&1 | grep -q "ERROR"
then

# for windows, simply put your path to docker desktop, the default is the following:
"C:\Program Files\Docker\Docker\Docker Desktop.exe"

# for mac
# open -a Docker

fi


# wait for docker to start

# for windows
while :
do

    if ! docker info 2>&1 | grep -q "ERROR"
    then
        break
    else
        sleep 1
    fi
done

# for mac
# while [ ! "$(ps aux | grep -v grep | grep -c $PROCESS)" -gt 0 ]
# do
#     sleep 1
# done


# spin up db container (and app if uncommented in docker-compose.yaml, also comment out last line if so)
docker-compose up -d


# start app
./mvnw spring-boot:run