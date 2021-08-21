#!/bin/bash

statusUrl=$1
url=http://localhost:8070/${statusUrl}

curl -u admin:admin123 -X GET -H "Content-Type: application/json" $url | python -m json.tool



