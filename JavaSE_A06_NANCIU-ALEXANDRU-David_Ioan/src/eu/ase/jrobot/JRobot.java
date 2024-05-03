package eu.ase.jrobot;

import robocode.*;
import java.awt.Color;

public class JRobot extends Robot {

    int squaresTraveled = 0; // Counter for the number of squares traveled
    boolean clockwise = true; // Indicates the direction of movement
    boolean aggressive = true; // Indicates whether the robot should fire at each corner
    boolean scanForRobots = true; // Indicates whether the robot rotates its radar at each corner
    int directionCounter = 0; // Counter to alternate direction of movement

    // Method to move the robot in a square
    public void moveInSquare(int lengthOfSide) {
        for (int i = 0; i < 4; i++) {
            ahead(lengthOfSide);
            if (directionCounter % 2 == 0) {
                turnRight(90); // Turn right if directionCounter is even
            } else {
                turnLeft(90); // Turn left if directionCounter is odd
            }
        }
    }

    // Event handler for the end of each round
    public void onRoundEnded(RoundEndedEvent event) {
        System.out.println("Round ended!");
        System.out.println("Total squares traveled: " + squaresTraveled);
    }

    // Main logic for the robot's behavior
    public void run() {
        setColors(Color.red, Color.blue, Color.green); // Set colors for body, gun, and radar

        while (true) {
            moveInSquare(150); // Move the robot in a square with side length 150
            squaresTraveled++; // Increment the squares traveled counter
            System.out.println("Squares Traveled: " + squaresTraveled);
            directionCounter++; // Increment the direction counter to alternate movement direction
            if (directionCounter % 2 == 0) {
                System.out.println("Direction: Clockwise"); // Print direction if clockwise
            } else {
                System.out.println("Direction: Anticlockwise"); // Print direction if anticlockwise
            }
        }
    }

    // Event handler for when the robot scans another robot
    public void onScannedRobot(ScannedRobotEvent e) {
        System.out.println("Scanned Robot: " + e.getName() + ", Energy: " + e.getEnergy() + ", Distance: " + e.getDistance());
        if (aggressive) {
            fire(1); // Fire at the scanned robot if aggressive mode is on
        }
    }

    // Event handler for when the robot is hit by a bullet
    public void onHitByBullet(HitByBulletEvent e) {
        back(10);
    }

    // Event handler for when the robot hits a wall
    public void onHitWall(HitWallEvent e) {
        back(20);
    }
}
