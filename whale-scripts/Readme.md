# Instructions for dockerized setup

Instructions to deploy dockerized setup for a local, self-sufficient development/test environment.
Main goal is to provide a full, self-sufficient local environment for testing and test automation development.

## Contents

0. Quick guide (main Readme)


# Quick guide

Fast guide to get started

## Prerequisites

* Add local mapping for DNS name to `hosts` file
  `127.0.0.1   example.test.local`


## Usage

* Update files `docker-composes/docker-compose.yml` and `nginx/nginx.conf.conf`, if you want to use debug logging in nginx
    - Uncomment the commented out lines required for debug logging
* After startup the service can be found in address: `http://example.test.local`


### Start up options

#### Dockerized

* To start the services execute:
    - `./start.sh`
    - `./start.sh -e docker`

#### Local application on Mac or Windows host

* To start the services execute:
    - `./start.sh -e dev-mac`
    - `./start.sh -e dev-win`

#### Local application on Linux host

* To start the services execute:
    - `./start.sh -e dev-linux`
* If the default strategy does not work you must edit `docker-composes/.env_dev_local_linux` file and change `BACKEND_SERVER` variable to another.
    - See the environment file for more instructions
* Resources:
    - Default strategy to use `BACKEND_SERVER=172.17.0.1` see [StackOverflow](https://stackoverflow.com/a/62431165)




