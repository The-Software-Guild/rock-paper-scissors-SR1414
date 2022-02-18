/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.rockpaperscissors;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author srior
 */
public class DogGenetics {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        Random rand = new Random();

        int max = 100;
        int min = 1;
        int numOfDogs = 0;
        String dogName;
        String[] breeds = {"Border Collie", "Dolmation", "German Shepard", "Terrier", "Corgie"};
        String[] chosen = new String[5];
        int[] backgrounds = new int[5];
        backgrounds[0] = rand.nextInt(100);
        backgrounds[1] = rand.nextInt(100 - backgrounds[0]);
        backgrounds[2] = rand.nextInt(100 - backgrounds[0] - backgrounds[1]);
        backgrounds[3] = rand.nextInt(100 - backgrounds[0] - backgrounds[1] - backgrounds[2]);
        backgrounds[4] = 100 - backgrounds[0] - backgrounds[1] - backgrounds[2] - backgrounds[3];

        System.out.println("What is your dog's name? ");
        dogName = userInput.nextLine();

        System.out.println("\nWell " + dogName + " is quite the mix.\n");
        
        for(int i = 0; i < breeds.length; i++){
            System.out.println(backgrounds[i] + "% " + breeds[i]);
        }

    }
}
