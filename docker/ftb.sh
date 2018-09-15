#!/bin/bash

# Set up color constants
YELLOW='\033[1;33m'
NOCOLOR='\033[0m'

printf "${YELLOW}Run this script from a docker machine${NOCOLOR}\n"

# Ensure running from script folder
SCRIPTDIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null && pwd )"
pushd . > /dev/null
cd $SCRIPTDIR

# Get IP address of docker machine
DOCKER_IP="$(docker-machine ip default)"

# Build docker box, including ftb.jar
docker build -t tomcat_ftb .

# Let user know address to browse to
printf "Browse to: ${YELLOW}http://$DOCKER_IP:8888/ftb/ ${NOCOLOR}\n"

# Run tomcat in docker (until CTRL+C is pressed)
docker run -ti --rm -p 8888:8080 tomcat_ftb

# Restore enviroment
popd > /dev/null