package com.company;
import java.util.Arrays;
import java.util.Scanner;

public class GameBoard {
    boolean hasWon;
    String[] players;
    String[][] board;
    boolean player1;
    boolean player2;
    public GameBoard() {
        hasWon = false;
    }
    public void createBoard() {
        int count2 = 0;
         board = new String[6][4];
        for (int i = 0; i < 6; i++) {
            int count = 0;
            for (int x = 0; x < 4; x++) {
                if (i == 0) {
                    if(x == 0) {
                        board[i][x] = " ";
                    } else {
                        board[i][x] = "  " + String.valueOf(count + 1) + "  ";
                        count++;
                    }
                }
                else if (x == 0 && i%2 != 0){
                    board[i][x] = String.valueOf(count2 + 1);
                    count2++;

                } else if (i ==  2 || i == 4) {
                    board[i][x] = "----";
                }
                else {
                    board[i][x] = "  -  ";
                }
                }
            }
        gameAssignPlayer();

    }
    public void gameAssignPlayer() {
        Scanner sc = new Scanner(System.in);
        players = new String[2];
        for (int i = 0; i < 2; i++) {
            String playerName = "What is Player " + (i + 1) + "'s name? ";
            if(i == 0) {
                playerName += "(X)";
            }
            if(i == 1) {
                playerName += "(O)";
            }
            System.out.println(playerName);
            players[i] = sc.nextLine();
        }
        gameSession();
    }
    public void gameSession() {
        System.out.println("Your Board:");
        boardPrinter();
        int count = 0;
        player1 = true;
        while(!hasWon) {
            if(player1) {
                count = 0;
                System.out.println(players[count] + "'s turn. " + "In put your value in the following format: row column");
                Scanner sc = new Scanner(System.in);
                String input = sc.nextLine();
                checkInput(input);
                boardPrinter();
                checkGame();
                //count++;
            } if (player2) {
                count = 1;
                System.out.println(players[count] + "'s turn. " + "In put your value in the following format: row column");
                Scanner sc = new Scanner(System.in);
                String input = sc.nextLine();
                checkInput(input);
                boardPrinter();
                checkGame();
                //count++;
            }
            //count = 0;
        }

    }




    public void boardPrinter() {
        for (int row = 0; row < 6; row++) {
            for (int column = 0; column < 4; column++) {
                System.out.print(board[row][column]);
            }
            System.out.println();
        }
    }
    public void checkInput(String s) {
        Scanner sc = new Scanner(s);
        int row = 0;
        int col = 0;
        int[] inputArr = new int[2];
        int howManyValues = 0;
        int range = 0;
        for (int i = 0; i < s.length(); i++) {
            if (sc.hasNextInt()) {
                howManyValues++;
               int temp = sc.nextInt();
               if (temp > 3|| temp < 1 ) {
                   range++;
               }
            }
        }
        Scanner s2 = new Scanner(s);
        if (howManyValues == 2 && range == 0) {
            int count = 0;
            for(int i = 0; i < s.length(); i++) {
                if (s2.hasNextInt()) {
                    inputArr[count] = s2.nextInt();
                    count++;
                }
            }
            checkValue(inputArr);
        } else if(howManyValues == 0) {
            System.out.println("You have entered no numbers, try again.");
        } else if(range != 0) {
            System.out.println("Your numbers are out of the range, try again.");
        } else if(howManyValues > 2) {
            System.out.println("You have entered too many values, try again.");
        }
        else {
            System.out.println("An unknown error has occurred.");
        }
    }
    public void checkValue(int[] arr) {
        //.contains(-)
        for (int i = 0; i < arr.length; i++) {
            if(i == 0 && arr[i] == 2) {
                arr[i] = 3;
            } else if (i == 0 && arr[i] == 3) {
                arr[i] = 5;
            }
        }
        if (board[arr[0]][arr[1]].contains("-")) {
            if (player1) {
                board[arr[0]][arr[1]] = "  X  ";
                player1 = false;
                player2 = true;
            } else {
                board[arr[0]][arr[1]] = "  O  ";
                player2 = false;
                player1 = true;
            }
        } else {
            System.out.println("This value has already been placed, try again.");
        }
        }
    public void checkGame() {
        //check if any row or column has three x's
        for(int row = 0; row < 6; row++) {
            for (int col = 0; col < 4; col++) {

            }
        }
    }
}
