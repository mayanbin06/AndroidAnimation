android animation example.

use [android create project ....] to create project.

if build debug. use ant debug cmd in project home dir.

to build release and sign the apk -- [example: ViewAnimation project]

1. generate keystore, use cmd below, it will generate "android.keystore" in current dir.
    keytool -genkey -alias android.keystore -keyalg RSA -validity 20000 -keystore android.keystore 

2. create "build.properties" in the home dir of the project. add the content below.
    proguard.config=proguard.flags // whether shuffle the code
    key.store=./android.keystore   // must same with keytool -keystore.
    key.alias=android.keystore     // must same with keytool -alias.
    key.store.password=123456      // the passward type int keytool cmd.
    key.alias.password=123456

3. add "build.properties" to "build.xml" file.
    <property file="local.properties" />
    # add property file.
    <property file="build.properties" />

4. add proguard.flags file to controll the shuffle.
    a example ./ViewAnimation/proguard.flags

last to run ant release.
