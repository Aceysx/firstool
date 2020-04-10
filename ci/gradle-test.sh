#!/usr/bin/env sh

set -e

BACKEND_DIR=git-resource/backend

cd $BACKEND_DIR
gradle test -i
cd -




