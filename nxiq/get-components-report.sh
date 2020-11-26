#!/bin/bash

appPublicId=$1
reportId=$2

curl -u admin:admin123 -X GET http://localhost:8070/api/v2/applications/${appPublicId}/reports/${reportId}/policy | python -m json.tool



