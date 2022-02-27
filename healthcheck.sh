#!/usr/bin/env bash
# Environment Variables
# HUB_HOST
# BROWSER
# MODULE

echo "Checking if hub is ready - http://192.168.0.101:4444/wd/hub"

while [ "$( curl -s http://192.168.0.101:4444/wd/hub | jq -r .value.ready )" != "true" ]
do
	sleep 1
done