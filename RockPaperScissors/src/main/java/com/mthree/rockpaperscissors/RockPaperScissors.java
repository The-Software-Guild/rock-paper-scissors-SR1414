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
public class RockPaperScissors {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        Random rand = new Random();
        String[] choices = {"Rock", "Paper", "Scissors"};
        boolean gameStart = false;
        int maxRounds = 10;
        int numOfRounds = 0;
        int playerScore = 0;
        int compScore = 0;
        int tied = 0;

        //while (maxRounds < 1 || maxRounds > 10) {
        //System.out.println("ERROR: Invalid Response - Closing Game");
        //System.exit(0);
        //}
        while (numOfRounds != maxRounds) {
            if (gameStart == false) {
                System.out.println("\n--------------------------------------------------------------");
                System.out.println("We are going to play Rock, Paper, Scissors");
                System.out.println("How many rounds do you want to play (minimum 1, maximum 10? ");
                maxRounds = userInput.nextInt();
                gameStart = true;
                if (maxRounds < 1 || maxRounds > 10) {
                    System.out.println("ERROR: Invalid Response - Closing Game");
                    System.exit(0);
                }
            }

            numOfRounds++;
            String playerChoice;
            String compChoice;
            System.out.println("-------------------------------------------");
            System.out.println("\nPlayer Score: " + playerScore);
            System.out.println("Computer Score: " + compScore);
            System.out.println("Game Tied: " + tied + "\n");

            System.out.println("Round: " + numOfRounds);
            System.out.println("Make your choice: ");
            System.out.println("1 = Rock, 2 = Paper, 3 = Scissors");
            playerChoice = choices[userInput.nextInt() - 1];
            System.out.println("-------------------------------------------\n");
            System.out.println("You chose: " + playerChoice);
            compChoice = compRand();
            System.out.println("\nComputer chose: " + compChoice);

            switch (roundWins(playerChoice, compChoice)) {
                case 0:
                    System.out.println("ERROR: INVALID RESULT - Closing game");
                    System.exit(0);
                case 1:
                    System.out.println("\nIt's a tie");
                    tied++;
                    break;
                case 2:
                    System.out.println("\nComputer wins this round");
                    compScore++;
                    break;
                case 3:
                    System.out.println("\nPlayer wins this round");
                    playerScore++;
                    break;
            }
            System.out.println("-------------------------------------------\n");

            if (numOfRounds == maxRounds) {
                System.out.println("FINAL TALLYS: \n");
                System.out.println("\nPlayer Score: " + playerScore);
                System.out.println("Computer Score: " + compScore);
                System.out.println("Game Tied: " + tied + "\n");

                switch (gameWin(playerScore, compScore)) {
                    case 0:
                        System.out.println("ERROR: INVALID RESULT - Closing game");
                        System.exit(0);
                    case 1:
                        System.out.println("TIED GAME");
                        break;
                    case 2:
                        System.out.println("COMPUTER WINS!!!!!");
                        break;
                    case 3:
                        System.out.println("YOU WIN!!!!");
                        break;
                }
                System.out.println("Play Again? (y/n) ");
                Scanner restartYN = new Scanner(System.in);
                String playAgain = restartYN.nextLine();

                if (!playAgain.equals("y") && !playAgain.equals("n")) {
                    System.out.println("ERROR: Invalid Response - Closing Game");
                    System.exit(0);
                }
                if (playAgain.equals("n")) {
                    System.out.println("Thanks for Playing!");
                    System.exit(0);
                }
                if (playAgain.equals("y")) {
                    gameStart = false;
                    playerScore = 0;
                    compScore = 0;
                    tied = 0;
                    numOfRounds = 0;
                }

            }

        }

    }

    public static String compRand() {
        String[] choices = {"Rock", "Paper", "Scissors"};
        Random rand = new Random();
        int max = 3;
        int min = 0;

        return choices[rand.nextInt(max - min) + min];
    }

    //1 is a tie
    //2 is computer win
    //3 is player win
    //x = playerScore, y = compScore
    public static int gameWin(int x, int y) {
        if (x == y) {
            return 1;
        }
        if (x < y) {
            return 2;
        }
        if (x > y) {
            return 3;
        } else {
            return 0;
        }

    }

    public static int roundWins(String x, String y) {
        switch (x) {
            case "Rock":
                if (y.equals("Rock")) {
                    return 1;
                }
                if (y.equals("Paper")) {
                    return 2;
                }
                if (y.equals("Scissors")) {
                    return 3;
                }
            case "Paper":
                if (y.equals("Rock")) {
                    return 3;
                }
                if (y.equals("Paper")) {
                    return 1;
                }
                if (y.equals("Scissors")) {
                    return 2;
                }
            case "Scissors":
                if (y.equals("Rock")) {
                    return 2;
                }
                if (y.equals("Paper")) {
                    return 3;
                }
                if (y.equals("Scissors")) {
                    return 1;
                }
            default:
                return 0;
        }

    }
;
}
