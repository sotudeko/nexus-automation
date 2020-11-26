#!/bin/bash

filename=$1
version=$2
repoId=$3
team=$4

repo="staging-development"
groupId=org/demo
artifactId=webgoat

curl -v -u admin:admin123 --upload-file ${filename} http://localhost:8081/repository/${repo}/${groupId}/${version}/${filename}

