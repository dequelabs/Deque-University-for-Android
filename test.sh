#!/bin/bash
DEVICE_PORT=38383

RUN_FOREVER=false
RUN_LOOP=true
LOCAL_PORT=38000
DEVICE=""
ONE_DEVICE="SINGLE_DEVICE_MODE"
SCENARIO_TAG="all"
HTML_OUTPUT=true
APK_PATH=app/build/outputs/apk/app-debug.apk

# Usage info
show_help() {
cat << EOF
Usage: ${0##*/} [-h] [-d DEVICE] [-s SCENARIO] 
Runs the calabash-android tests in the current directory.

    -h          display help
    -d DEVICE   Target Device.  Default targets all devices.  No argument runs first device only.
    -s TAG		Scenario tag to run.  Valid: {all, EditText, ContDesc, Labels, TabbedNavigation, AcronymAnnouncement}
    -t 			Enable terminal output instead of HTML Report.
    -r 			Repeat tests forever.

Requirements: 
    calabash-android: sudo gem install calabash-android
    adb in path: export PATH=/Library/Android/sdk/platform-tools/
EOF
}

function ctrl_c() {
	echo "killing $$"
    RUN_FOREVER=false
    pkill -P $$
}
trap ctrl_c INT

run_test () {
	echo "Running test on $1 with tag $2"
	REPORT_DIRECTORY=$(pwd)"/TestResults/"$1
	mkdir -p $REPORT_DIRECTORY

	run_command="DQ_TEST_PORT=$LOCAL_PORT ADB_DEVICE_ARG=$1 SCREENSHOT_PATH=$REPORT_DIRECTORY/ calabash-android run $APK_PATH --tags @$2"

	adb -s $1 forward tcp:$LOCAL_PORT tcp:$DEVICE_PORT 

	if $HTML_OUTPUT; then
		run_command="$run_command --format html --out $REPORT_DIRECTORY/report.html"
	fi

	eval "$run_command"

	if $RUN_FOREVER; then
		run_test "$@"
	fi

}

OPTIND=1 # Reset is necessary if getopts was used previously in the script.  It is a good idea to make this local in a function.
while getopts ":htrd:s:" opt; do
    case "$opt" in
        h)
            show_help
            exit 0
            ;;
        d)  DEVICE=$OPTARG
			;;
		s)  SCENARIO_TAG=$OPTARG
			;;

		t)  HTML_OUTPUT=false
			;;

		r)  RUN_FOREVER=true
			;;

		\?) echo "Invalid option -$OPTARG"
			;;

		:)  if [ $OPTARG == "d" ]; then
				DEVICE=$ONE_DEVICE
			else 
				echo "Option -$OPTARG requires an argument"
			fi
    esac
done


if [ "$DEVICE" == "" ] || [ "$DEVICE" == "$ONE_DEVICE" ]; then

	array=( $(adb devices | awk '{print $1}') )

	if [ "${#array[@]}" -eq "1" ]; then
		echo "No Devices Attached, check that ADB is detecting your device properly"
	else
		for device in ${array[@]:1}; do 
	      	
	      	#When you run terminal output in parrallel it gets all jumbled!  So don't.
	      	if $HTML_OUTPUT; then
	      	  	run_test $device $SCENARIO_TAG &
	      	else
	      		run_test $device $SCENARIO_TAG
	      	fi

	      	((LOCAL_PORT+=1000))

	      	if [ "$DEVICE" == "$ONE_DEVICE" ]; then 
	      		break
	      	fi
		done
	fi
else 
	run_test $DEVICE $SCENARIO_TAG &
fi

wait
