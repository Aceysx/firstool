#!/usr/bin/env sh

set -e

genImage() {
    IMAGE=52.80.132.54/tws/$2:2.0.$BUILD_NUMBER

    cd $1
    docker build . -t $IMAGE
    docker login 52.80.132.54  -u $USERNAME -p $PASSWORD
    docker push $IMAGE
    docker rmi $IMAGE
    cd -
}


genImage 'build-api' 'tws-notification-api'
genImage 'build-web' 'tws-notification-web'

