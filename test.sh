
SCREENSHOT_DIRECTORY=~/Desktop/calabash_screenshots/

if [ "$1" == "install_deps" ]; then
	echo "Installing Dependencies"
	sudo gem install calabash-android
elif [ "$1" == "test" ]; then
	echo "Running Tests"
	export SCREENSHOT_PATH=$SCREENSHOT_DIRECTORY

	mkdir -p $SCREENSHOT_DIRECTORY
	
	calabash-android run app/build/outputs/apk/app-debug.apk 
else 
	echo "Invalid command"	
fi
