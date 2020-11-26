#!/bin/bash

playbook=blobstore-file-create

ansible-playbook ../playbooks/${playbook}.yml --extra-vars @data/blobstore-file-cocoapods.json
ansible-playbook ../playbooks/${playbook}.yml --extra-vars @data/blobstore-file-conan.json
ansible-playbook ../playbooks/${playbook}.yml --extra-vars @data/blobstore-file-conda.json
ansible-playbook ../playbooks/${playbook}.yml --extra-vars @data/blobstore-file-docker.json
ansible-playbook ../playbooks/${playbook}.yml --extra-vars @data/blobstore-file-go.json
ansible-playbook ../playbooks/${playbook}.yml --extra-vars @data/blobstore-file-helm.json
ansible-playbook ../playbooks/${playbook}.yml --extra-vars @data/blobstore-file-maven.json
ansible-playbook ../playbooks/${playbook}.yml --extra-vars @data/blobstore-file-npm.json
ansible-playbook ../playbooks/${playbook}.yml --extra-vars @data/blobstore-file-nuget.json
ansible-playbook ../playbooks/${playbook}.yml --extra-vars @data/blobstore-file-pypi.json
ansible-playbook ../playbooks/${playbook}.yml --extra-vars @data/blobstore-file-raw.json
