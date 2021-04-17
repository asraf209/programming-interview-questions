
# Create a bash like cmd processor

RPT – Command Processor

This exercise simulates a command line shell. It does not actually create any objects on the physical disk. Instead, it maintains objects and state within the context of running application.

## Input:
The main input mechanism of the application is the acceptance of text on the command line. Commands should be read and processed until the [quit] command is found.
If the entered command is not recognized, the Unrecognized command error should be returned. Or if the command has invalid parameters, or any parameter is missing, the Invalid Command error message should be returned.

## Commands
### Quit
Command Name: quit
This command terminates the main application loop.

### Current Directory
Command Name: pwd
This command prints the full path of the current directory.

### List Contents
Command Name: ls
Switches (extra)
[-r] –Recursive. If provided, prints everything in the current directory and all subdirectories.
This command lists the contents (directories and files) of the current directory. It writes a single item per line. If there are no items, print nothing.
If printing recursively, before printing contents, print the full path of the current directory.

### Make Directory
Command Name: mkdir
Parameters:
[dirName] – the name of the directory to create. Character limit of 100.
This command creates a directory entry in the cache. If the directory already exists (by name), a message like “Directory already exists” should be printed.

### Change Directory
Command Name: cd
Parameters:
[dirName] – the name of the sub-directory to change current path to.
This command changes the current path to a sub-directory(by name). If the name does not exist, a message like “Directory not found” should be displayed.
The command should also accept the dirName of “..”, which indicates the current directory should be changed to the parent. If the current directory is “root”, no message should be displayed.

### Create File
Command Name: touch
Parameters:
[fileName] – the name of the file to create. Character limit of 100.
This command created a “file” in the current directory.

### Extras
If time permits, the following additional features could be added:
An optional parameter can be added to the command to accept a multi-faceted path (i.e., subdir1/subdir1-1/subdir3)
[cd] – The directory change should follow the path recursively. If any of the parts do not exist, the command should fail with a message of “Invalid path”.
[ls] –The listing should be of the final node of the supplied path.

The previous state of the application could be loaded from a file on disk. The contents of this file would be a serialized representation of the application context.


## Example

	pwd
	/root
	mkdir abc
	ls
	abc
	touch root.file
	ls
	root.file
	abc
	cd abc
	pwd
	/root/abc
	mkdir abc-sub-folder
	touch abc.file
	ls
	abc-sub-folder
	abc.file
	ls -r
	/root/abc	abc-sub-folder
	/root/abc	abc.file
	cd abc-sub-folder
	pwd
	/root/abc/abc-sub-folder
	touch sub.file
	ls
	sub.file
	cd ..
	pwd
	/root/abc
	cd ..
	pwd
	/root
	ls -r
	/root	root.file
	/root	abc
	/root/abc	abc-sub-folder
	/root/abc	abc.file
	/root/abc/abc-sub-folder	sub.file
	quit
