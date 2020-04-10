#!/usr/bin/env sh

set -e

cd web
npm i
npm run test:coverage
npm run sonarqube