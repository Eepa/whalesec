#!/bin/bash

help_text=$(cat <<-EOF
	Script for starting docker compose.
	Usage:
	    -h, --help      Print this help message
	    -e              Select environment in which to run the script. Options:
	                      docker      Use dockerized applications (default)
	                      dev-linux   Use local applications on Linux host
	                      dev-mac     Use local applications on Mac host
	                      dev-win     Use local applications on Windows host
	EOF
)
environment=docker
environment_file=.env_dev_docker
docker_compose="docker compose"


while [[ "$#" -gt 0 ]]; do
    case $1 in
        -e) argument=$2
            environment="${argument:-docker}"; shift ;;
        -h|--help) echo "$help_text"; exit 1 ;;
        *) echo "$help_text"; exit 1 ;;
    esac
    shift
done

case $environment in

  dev-linux)
    docker_compose="docker-compose" && \
    # NOTE: if your networking setup differs from default, uncomment these lines to evaluate the IP at runtime
    #DOCKER_HOST_IP=$(ip route | grep 'docker0 proto'| awk '{print $9}') && \
    #export BACKEND_SERVER=$DOCKER_HOST_IP && \
    environment_file=.env_dev_local_linux
    ;;

  dev-mac)
    docker_compose="docker-compose" && \
    environment_file=.env_dev_local_mac_win
    ;;

  dev-win)
    environment_file=.env_dev_local_mac_win
    ;;

  *)
    environment_file=.env_dev_docker
    ;;
esac


(
cd ./docker-composes/ && \
#docker compose --env-file "./$environment_file" config && \
$docker_compose --env-file "./$environment_file" pull && \
$docker_compose --env-file "./$environment_file" up
)

