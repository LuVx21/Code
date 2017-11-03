#!/bin/bash
# filename: cli-test.sh

UPCASE=false
DATE=""

usage() {
    echo "USAGE:"
    echo "cli-test <options>"
    echo "    -h      : print help"
    echo "    -u      : print info upcase"
    echo "    -p <xxx>: print info"
    echo "    -d <xxx>: date in print info"
}

print() {
    if $UPCASE
    then
       echo -n $1 | tr a-z A-Z
    else
        echo -n $1
    fi

    if [ "$DATE" != "" ]
    then
        echo "   date: $DATE"
    else
        echo ""
    fi
}

while getopts "hup:d:" opt; do
    case "$opt" in
        h)
            usage
            exit 0
            ;;
        u)
            UPCASE=true
            ;;
        d)
            DATE=$OPTARG
            ;;
        p)
            print $OPTARG
            ;;
    esac
done