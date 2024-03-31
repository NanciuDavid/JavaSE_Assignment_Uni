package eu.deic.oop.oop;
import java.util.Scanner;

class Parking {
    private int[] dailyMinutes;

    public Parking(int numDays) {
        dailyMinutes = new int[numDays];
    }

    public void setMinutes(int day, int minutes) {
        dailyMinutes[day] = minutes;
    }

    public int getMaxMinutes() {
        int max = Integer.MIN_VALUE;
        for (int minutes : dailyMinutes) {
            if (minutes > max) {
                max = minutes;
            }
        }
        return max;
    }

    public int getMinMinutes() {
        int min = Integer.MAX_VALUE;
        for (int minutes : dailyMinutes) {
            if (minutes < min) {
                min = minutes;
            }
        }
        return min;
    }
}