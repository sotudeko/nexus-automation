#!/bin/bash

endpoint=$1
url=http://localhost:8070/$endpoint

curl -u admin:admin123 -X GET -H "Content-Type: application/json" $url


