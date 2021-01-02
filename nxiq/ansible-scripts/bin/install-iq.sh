#!/bin/bash

ansible-playbook -vv -K ../playbooks/install-iq.yml --extra-vars "install_mode=install"


