#!/bin/bash

num=$1

if [[ ${num} -lt 100 ]] && [[ ${num} -ge 90 ]]
then
        echo "优"
elif [[ ${num} -lt 90 ]] && [[ ${num} -ge 80 ]]
then
        echo "良"
else
        echo "中"
fi