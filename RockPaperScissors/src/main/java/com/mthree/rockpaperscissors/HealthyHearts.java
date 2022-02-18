/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.rockpaperscissors;

import java.util.Scanner;

/**
 *
 * @author srior
 */
public class HealthyHearts {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        double age = 0;
        double bpm = 0;

        System.out.println("What is your age? ");
        age = Integer.parseInt(userInput.nextLine());
        bpm = 220 - age;
        double bpmMin = (bpm / 100) * 50;
        double bpmMax = (bpm / 100) * 85;
        System.out.println("Your maximum heart rate should be " + bpm + " beats per minute");
        System.out.println("Your target HR Zone is " + (int)bpmMin + " - " + (int)bpmMax + " beats per minute");
    }
}
