#!/bin/bash
# for

for command in `cat /etc/passwd`
do
        echo $command
done