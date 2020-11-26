#!/bin/bash

cid=$1
name=$2

repoUrl=http://localhost:8081
username=admin
passwd=admin123

endPoint='service/rest/v1/components'

echo "Get Nexus Repository Manager component\n"
echo

#curl -v -s -u ${username}:${passwd} -X GET ${repoUrl}/${endPoint}/${componentId}

curl -s -u ${username}:${passwd} -o ${fname} -X GET ${cid}

echo

exit 0




