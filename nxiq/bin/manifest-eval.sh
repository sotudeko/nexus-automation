#!/bin/bash

applicationId=ecff8217f6ad4962b8e9eba38574da5a

curl -u admin:admin123 -X POST -H "Content-Type: application/json" -d '{"stageId":"build","branchName":"main"}' http://localhost:8070/api/v2/evaluation/applications/${applicationId}/manifestEvaluation


