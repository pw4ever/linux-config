#! /bin/bash
SSH_SERVER=$1
REPORT_INTERVAL=${2:-60}
REPORT_PATH=${3:-~}
NAME=$(uname -n)

usage () {
    echo "$0 SSH_SERVER [REPORT_INTERVAL|60] [REPORT_PATH|~]"
}

if [[ -z ${SSH_SERVER} ]]; then
    usage
    exit 1
fi

MIN_REPORT_INTERVAL=5
if [[ $REPORT_INTERVAL < $MIN_REPORT_INTERVAL ]]; then
    echo report interval should be at least $MIN_REPORT_INTERVAL
    exit 1
fi

while :; do
    ip addr | ssh ${SSH_SERVER} "cat - > ${REPORT_PATH}/${NAME}"
    sleep $REPORT_INTERVAL 
done
