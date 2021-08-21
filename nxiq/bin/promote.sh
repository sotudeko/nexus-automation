#!/bin/bash

appId=bb5b81a57a0f485f802c1eae2f05fc9d

curl -u admin:admin123 -X POST -H "Content-Type: application/json" -d@promote-data.json  "http://localhost:8070/api/v2/evaluation/applications/${appId}/promoteScan"

