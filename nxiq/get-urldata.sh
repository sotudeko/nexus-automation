#!/bin/bash

uri=$1

curl -u admin:admin123 -X GET http://localhost:8070/${uri} | python -m json.tool

