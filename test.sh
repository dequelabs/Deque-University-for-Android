#!/bin/bash

# Usage info
show_help() {
cat << EOF
Usage: ${0##*/} [-h] [-d DEVICE] [-s SCENARIO] 
Runs the calabash-android tests in the current directory.

    -h          display help
    -d DEVICE   Target Device.  Default targets all devices.  No argument runs first device only.
    -t TAG		Scenario tag to run.  Valid: {all, EditText, ContDesc, Labels}

Requirements: 
    calabash-android: sudo gem install calabash-android
    adb in path: export PATH=/Path/To/Android/sdk/platform-tools
EOF
}

run_test () {
	echo "Running test on $1 with tag $2"
	adb -s $1 forward tcp:$DEVICE_PORT tcp:$LOCAL_PORT
	ADB_DEVICE_ARG=$1 calabash-android run app/build/outputs/apk/app-debug.apk --tags @$2
}

DEVICE_PORT=38383
LOCAL_PORT=38383
DEVICE=""
ONE_DEVICE="SINGLE_DEVICE_MODE"
SCENARIO_TAG="all"

OPTIND=1 # Reset is necessary if getopts was used previously in the script.  It is a good idea to make this local in a function.
while getopts ":hd:t:" opt; do
    case "$opt" in
        h)
            show_help
            exit 0
            ;;
        d)  DEVICE=$OPTARG
			;;
		t)  SCENARIO_TAG=$OPTARG
			;;

		\?) echo "Invalid option -$OPTARG"
			;;

		:) 
		if [ $OPTARG == "d" ]; then
			DEVICE=$ONE_DEVICE
		else 
			echo "Option -$OPTARG requires an argument"
		fi
    esac
done

if [ "$DEVICE" == "" ] || [ "$DEVICE" == "$ONE_DEVICE" ]; then

	adb devices | while read line; do
		if [ ! "$line" == "" ] && [ `echo $line | awk '{print $2}'` == "device" ]
	    then
	      	device=`echo $line | awk '{print $1}'`
	      	run_test $device $SCENARIO_TAG

	      	if [ "$DEVICE" == "$ONE_DEVICE" ]; 
	      		then exit 0 
	      	fi
	    fi
	done
else 
	run_test $DEVICE
fi
	

