#!/bin/bash

# Set the path to the Robocode installation directory
ROBOCODE_HOME="/Users/davidnanciu/robocode"

# Set the path to the JDK bin directory
JAVA_HOME="/usr/bin"

# Compile the JRobot.java file
$JAVA_HOME/javac -classpath "$ROBOCODE_HOME/libs/*:$ROBOCODE_HOME/JavaSE_A06_NANCIU-ALEXANDRU-David_Ioan/src" $ROBOCODE_HOME/JavaSE_A06_NANCIU-ALEXANDRU-David_Ioan/src/eu/ase/jrobot/JRobot.java

# Run Robocode with the compiled robot
$JAVA_HOME/java -Xmx512M -Dsun.io.useCanonCaches=false -cp "$ROBOCODE_HOME/libs/*:$ROBOCODE_HOME/JavaSE_A06_NANCIU-ALEXANDRU-David_Ioan/src" robocode.Robocode -battle eu.ase.jrobot.JRobot.battle
