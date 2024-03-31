package eu.deic.oop.oop;

import java.util.Random;

public class SoftwareDeveloper {
    private final int weeks = 3;
    private final int days = 7;
    private int[][] minutesPerDay;

    public SoftwareDeveloper() {
        this.minutesPerDay = new int[weeks][days];
        generateMinutesWorked();
    }

    private void generateMinutesWorked() {
        Random random = new Random();
        for (int i = 0; i < weeks; i++) {
            for (int j = 0; j < days; j++) {
                minutesPerDay[i][j] = random.nextInt(540); // Assuming a workday is at most 9 hours (540 minutes)
            }
        }
    }

    public int[][] getMinutesPerDay() {
        return minutesPerDay;
    }

    public int getMaxMinutesWorked() {
        int max = minutesPerDay[0][0];
        for (int[] week : minutesPerDay) {
            for (int minutes : week) {
                if (minutes > max) {
                    max = minutes;
                }
            }
        }
        return max;
    }

    public int getMinMinutesWorked() {
        int min = minutesPerDay[0][0];
        for (int[] week : minutesPerDay) {
            for (int minutes : week) {
                if (minutes < min) {
                    min = minutes;
                }
            }
        }
        return min;
    }

    public int getMaxDay() {
        int day = 0 ;
        for(int i = 0 ; i < weeks ; i++) {
            for(int j = 0 ; j < days ; j++) {
                if(minutesPerDay[i][j] == getMaxMinutesWorked()) {
                    day = j;
                }
            }
        }
        return ++day;
    }

    public int getMinDay() {
        int day = 0 ;
        for(int i = 0 ; i < weeks ; i++) {
            for(int j = 0 ; j < days ; j++) {
                if(minutesPerDay[i][j] == getMinMinutesWorked()) {
                    day = j;
                }
            }
        }
        return ++day;
    }

    public int getMaxWeek() {
        int week = 0 ;
        for(int i = 0 ; i < weeks ; i++) {
            for(int j = 0 ; j < days ; j++) {
                if(minutesPerDay[i][j] == getMaxMinutesWorked()) {
                    week = i;
                }
            }
        }
        return ++week;
    }

    public int getMinWeek() {
        int week = 0 ;
        for(int i = 0 ; i < weeks ; i++) {
            for(int j = 0 ; j < days ; j++) {
                if(minutesPerDay[i][j] == getMinMinutesWorked()) {
                    week = i;
                }
            }
        }
        return ++week;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("The maximum number of minutes worked in a day is ");
        sb.append(getMaxMinutesWorked());
        sb.append(" registered on day ");
        sb.append(getMaxDay());
        sb.append(" week ");
        sb.append(getMaxWeek());

        sb.append("\nThe minimum number of minutes worked in a day is ");
        sb.append(getMinMinutesWorked());
        sb.append(" registered on day ");
        sb.append(getMinDay());
        sb.append(" week ");
        sb.append(getMinWeek());

        return sb.toString();
    }
}


