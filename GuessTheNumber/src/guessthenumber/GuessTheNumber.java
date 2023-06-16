/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package guessthenumber;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Alfredo
 */
public class GuessTheNumber {

    Scanner scan = new Scanner(System.in);
    int theNUMBER;
    int max;
    boolean go = true;

    public GuessTheNumber() {
        Random rand = new Random();
        max = 100;
        theNUMBER = Math.abs(rand.nextInt()) % (max + 1);
        
    }

    public void play() {
        while (go) {
            int move = scan.nextInt();
            if (move > theNUMBER) {
                System.out.println("Your number is too big");
            }
            else if (move < theNUMBER) {
                System.out.println("Your number is too small");
            } else {
                System.out.println("You got it broo !!!");
                go = false;
            }
        }
    }

    public static void howBigIsMyNumber(int x) {
        if (x >= 0 && x <= 10) {
            System.out.println("Our number is pretty small");
        } else if (x >= 11 && x <= 100) {
            System.out.println("Our number is pretty big");
        } else {
            System.out.println("The number is out of range");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       GuessTheNumber guessGame = new GuessTheNumber();
       System.out.println("Welcome to my game. Try and guess my imposible number"
                + "It´s between 0 and " + guessGame.max + "inclusive. Just type a number"
                        + "to guet started!!");
        System.out.print("Type a number:");
       guessGame.play();
    }

}
