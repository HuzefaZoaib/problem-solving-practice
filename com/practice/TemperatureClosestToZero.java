package com.practice;

public class TemperatureClosestToZero {

    public static void main(String[] args) {

        
    }

    static int closestToZero(int[] ts) {

        int closest = 0;
        for(int i=0; i<ts.length; i++) {

            if(ts[i] == closest) {
                closest = ts[i];
            } else if(ts[i] > 0 && ts[i] < closest) {
                closest = ts[i];
            } else if(ts[i] < 0 && (-1*ts[i]) < closest) {
                closest = ts[i];
            }
        }

        return closest;
    }
}
