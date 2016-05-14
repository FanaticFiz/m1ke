@ECHO OFF

SET argument=%1
SET basedir=%~dp0

IF "%argument%"=="init" (
    java -jar "%basedir%m1ke.jar" "%argument%"
) ELSE (
	ECHO command not found
)