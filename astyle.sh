#!/usr/bin/env bash

astyle --recursive 'src/main/java/frc/robot/*.java' \
    --style=java \
    --indent=spaces=4 \
    --indent-switches \
    --indent-col1-comments \
    --break-blocks \
    --pad-oper \
    --pad-comma \

find . -name "*.orig" -delete
