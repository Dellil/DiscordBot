@REM ----------------------------------------------------------------------------
@REM Copyright 2001-2004 The Apache Software Foundation.
@REM
@REM Licensed under the Apache License, Version 2.0 (the "License");
@REM you may not use this file except in compliance with the License.
@REM You may obtain a copy of the License at
@REM
@REM      http://www.apache.org/licenses/LICENSE-2.0
@REM
@REM Unless required by applicable law or agreed to in writing, software
@REM distributed under the License is distributed on an "AS IS" BASIS,
@REM WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@REM See the License for the specific language governing permissions and
@REM limitations under the License.
@REM ----------------------------------------------------------------------------
@REM

@echo off

set ERROR_CODE=0

:init
@REM Decide how to startup depending on the version of windows

@REM -- Win98ME
if NOT "%OS%"=="Windows_NT" goto Win9xArg

@REM set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" @setlocal

@REM -- 4NT shell
if "%eval[2+2]" == "4" goto 4NTArgs

@REM -- Regular WinNT shell
set CMD_LINE_ARGS=%*
goto WinNTGetScriptDir

@REM The 4NT Shell from jp software
:4NTArgs
set CMD_LINE_ARGS=%$
goto WinNTGetScriptDir

:Win9xArg
@REM Slurp the command line arguments.  This loop allows for an unlimited number
@REM of arguments (up to the command line limit, anyway).
set CMD_LINE_ARGS=
:Win9xApp
if %1a==a goto Win9xGetScriptDir
set CMD_LINE_ARGS=%CMD_LINE_ARGS% %1
shift
goto Win9xApp

:Win9xGetScriptDir
set SAVEDIR=%CD%
%0\
cd %0\..\.. 
set BASEDIR=%CD%
cd %SAVEDIR%
set SAVE_DIR=
goto repoSetup

:WinNTGetScriptDir
set BASEDIR=%~dp0\..

:repoSetup


if "%JAVACMD%"=="" set JAVACMD=java

if "%REPO%"=="" set REPO=%BASEDIR%\repo

set CLASSPATH="%BASEDIR%"\etc;"%REPO%"\net\dv8tion\JDA\3.8.3_463\JDA-3.8.3_463.jar;"%REPO%"\com\google\code\findbugs\jsr305\3.0.2\jsr305-3.0.2.jar;"%REPO%"\org\jetbrains\annotations\16.0.1\annotations-16.0.1.jar;"%REPO%"\org\slf4j\slf4j-api\1.7.25\slf4j-api-1.7.25.jar;"%REPO%"\com\neovisionaries\nv-websocket-client\2.5\nv-websocket-client-2.5.jar;"%REPO%"\com\squareup\okhttp3\okhttp\3.13.0\okhttp-3.13.0.jar;"%REPO%"\com\squareup\okio\okio\1.17.2\okio-1.17.2.jar;"%REPO%"\club\minnced\opus-java-api\1.0.4\opus-java-api-1.0.4.jar;"%REPO%"\net\java\dev\jna\jna\4.4.0\jna-4.4.0.jar;"%REPO%"\club\minnced\opus-java-natives\1.0.4\opus-java-natives-1.0.4.jar;"%REPO%"\org\apache\commons\commons-collections4\4.1\commons-collections4-4.1.jar;"%REPO%"\org\json\json\20160810\json-20160810.jar;"%REPO%"\net\sf\trove4j\trove4j\3.0.3\trove4j-3.0.3.jar;"%REPO%"\com\google\firebase\firebase-admin\6.8.0\firebase-admin-6.8.0.jar;"%REPO%"\com\google\api-client\google-api-client\1.25.0\google-api-client-1.25.0.jar;"%REPO%"\com\google\oauth-client\google-oauth-client\1.25.0\google-oauth-client-1.25.0.jar;"%REPO%"\com\google\http-client\google-http-client-jackson2\1.25.0\google-http-client-jackson2-1.25.0.jar;"%REPO%"\com\fasterxml\jackson\core\jackson-core\2.9.6\jackson-core-2.9.6.jar;"%REPO%"\com\google\api-client\google-api-client-gson\1.25.0\google-api-client-gson-1.25.0.jar;"%REPO%"\com\google\http-client\google-http-client-gson\1.25.0\google-http-client-gson-1.25.0.jar;"%REPO%"\com\google\code\gson\gson\2.1\gson-2.1.jar;"%REPO%"\com\google\http-client\google-http-client\1.25.0\google-http-client-1.25.0.jar;"%REPO%"\org\apache\httpcomponents\httpclient\4.5.5\httpclient-4.5.5.jar;"%REPO%"\org\apache\httpcomponents\httpcore\4.4.9\httpcore-4.4.9.jar;"%REPO%"\commons-logging\commons-logging\1.2\commons-logging-1.2.jar;"%REPO%"\commons-codec\commons-codec\1.10\commons-codec-1.10.jar;"%REPO%"\com\google\j2objc\j2objc-annotations\1.1\j2objc-annotations-1.1.jar;"%REPO%"\com\google\api\api-common\1.7.0\api-common-1.7.0.jar;"%REPO%"\com\google\auth\google-auth-library-oauth2-http\0.11.0\google-auth-library-oauth2-http-0.11.0.jar;"%REPO%"\com\google\auth\google-auth-library-credentials\0.11.0\google-auth-library-credentials-0.11.0.jar;"%REPO%"\com\google\cloud\google-cloud-storage\1.43.0\google-cloud-storage-1.43.0.jar;"%REPO%"\com\google\cloud\google-cloud-core\1.43.0\google-cloud-core-1.43.0.jar;"%REPO%"\joda-time\joda-time\2.9.2\joda-time-2.9.2.jar;"%REPO%"\com\google\api\gax\1.30.0\gax-1.30.0.jar;"%REPO%"\com\google\protobuf\protobuf-java-util\3.6.0\protobuf-java-util-3.6.0.jar;"%REPO%"\com\google\api\grpc\proto-google-common-protos\1.12.0\proto-google-common-protos-1.12.0.jar;"%REPO%"\com\google\api\grpc\proto-google-iam-v1\0.12.0\proto-google-iam-v1-0.12.0.jar;"%REPO%"\com\google\cloud\google-cloud-core-http\1.43.0\google-cloud-core-http-1.43.0.jar;"%REPO%"\com\google\http-client\google-http-client-appengine\1.24.1\google-http-client-appengine-1.24.1.jar;"%REPO%"\com\google\http-client\google-http-client-jackson\1.24.1\google-http-client-jackson-1.24.1.jar;"%REPO%"\org\codehaus\jackson\jackson-core-asl\1.9.11\jackson-core-asl-1.9.11.jar;"%REPO%"\com\google\api\gax-httpjson\0.47.0\gax-httpjson-0.47.0.jar;"%REPO%"\io\opencensus\opencensus-contrib-http-util\0.15.0\opencensus-contrib-http-util-0.15.0.jar;"%REPO%"\com\google\apis\google-api-services-storage\v1-rev135-1.24.1\google-api-services-storage-v1-rev135-1.24.1.jar;"%REPO%"\com\google\cloud\google-cloud-firestore\0.61.0-beta\google-cloud-firestore-0.61.0-beta.jar;"%REPO%"\com\google\cloud\google-cloud-core-grpc\1.43.0\google-cloud-core-grpc-1.43.0.jar;"%REPO%"\com\google\protobuf\protobuf-java\3.6.0\protobuf-java-3.6.0.jar;"%REPO%"\io\grpc\grpc-protobuf\1.13.1\grpc-protobuf-1.13.1.jar;"%REPO%"\io\grpc\grpc-protobuf-lite\1.13.1\grpc-protobuf-lite-1.13.1.jar;"%REPO%"\io\grpc\grpc-context\1.13.1\grpc-context-1.13.1.jar;"%REPO%"\com\google\api\gax-grpc\1.30.0\gax-grpc-1.30.0.jar;"%REPO%"\org\threeten\threetenbp\1.3.3\threetenbp-1.3.3.jar;"%REPO%"\com\google\api\grpc\proto-google-cloud-firestore-v1beta1\0.26.0\proto-google-cloud-firestore-v1beta1-0.26.0.jar;"%REPO%"\com\google\auto\value\auto-value\1.4\auto-value-1.4.jar;"%REPO%"\io\grpc\grpc-netty-shaded\1.13.1\grpc-netty-shaded-1.13.1.jar;"%REPO%"\io\grpc\grpc-core\1.13.1\grpc-core-1.13.1.jar;"%REPO%"\com\google\errorprone\error_prone_annotations\2.1.2\error_prone_annotations-2.1.2.jar;"%REPO%"\io\opencensus\opencensus-contrib-grpc-metrics\0.12.3\opencensus-contrib-grpc-metrics-0.12.3.jar;"%REPO%"\io\grpc\grpc-stub\1.13.1\grpc-stub-1.13.1.jar;"%REPO%"\io\grpc\grpc-auth\1.13.1\grpc-auth-1.13.1.jar;"%REPO%"\io\opencensus\opencensus-api\0.15.0\opencensus-api-0.15.0.jar;"%REPO%"\io\opencensus\opencensus-contrib-grpc-util\0.15.0\opencensus-contrib-grpc-util-0.15.0.jar;"%REPO%"\com\google\guava\guava\20.0\guava-20.0.jar;"%REPO%"\io\netty\netty-codec-http\4.1.22.Final\netty-codec-http-4.1.22.Final.jar;"%REPO%"\io\netty\netty-codec\4.1.22.Final\netty-codec-4.1.22.Final.jar;"%REPO%"\io\netty\netty-handler\4.1.22.Final\netty-handler-4.1.22.Final.jar;"%REPO%"\io\netty\netty-buffer\4.1.22.Final\netty-buffer-4.1.22.Final.jar;"%REPO%"\io\netty\netty-common\4.1.22.Final\netty-common-4.1.22.Final.jar;"%REPO%"\io\netty\netty-transport\4.1.22.Final\netty-transport-4.1.22.Final.jar;"%REPO%"\io\netty\netty-resolver\4.1.22.Final\netty-resolver-4.1.22.Final.jar;"%REPO%"\com\justbotproject\CIP\1.0-SNAPSHOT\CIP-1.0-SNAPSHOT.jar
set EXTRA_JVM_ARGUMENTS=
goto endInit

@REM Reaching here means variables are defined and arguments have been captured
:endInit

%JAVACMD% %JAVA_OPTS% %EXTRA_JVM_ARGUMENTS% -classpath %CLASSPATH_PREFIX%;%CLASSPATH% -Dapp.name="worker" -Dapp.repo="%REPO%" -Dbasedir="%BASEDIR%" WorkerProcess %CMD_LINE_ARGS%
if ERRORLEVEL 1 goto error
goto end

:error
if "%OS%"=="Windows_NT" @endlocal
set ERROR_CODE=1

:end
@REM set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" goto endNT

@REM For old DOS remove the set variables from ENV - we assume they were not set
@REM before we started - at least we don't leave any baggage around
set CMD_LINE_ARGS=
goto postExec

:endNT
@endlocal

:postExec

if "%FORCE_EXIT_ON_ERROR%" == "on" (
  if %ERROR_CODE% NEQ 0 exit %ERROR_CODE%
)

exit /B %ERROR_CODE%
