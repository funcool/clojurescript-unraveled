#!/bin/sh

while true; do
    inotifywait -e close_write,moved_to \
                --excludei ".git/.*$" -r .
    make;
done;
