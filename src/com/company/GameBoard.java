package com.company;
import java.util.Arrays;
import java.util.Scanner;

public class GameBoard {
    boolean hasWon;
    String[] players;
    String[][] board;
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
        while(hasWon == false) {
            System.out.println(players[count] + "turn. " + "In put your value in the following format: row column");
            Scanner sc = new Scanner(System.in);
            sc.nextLine();

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
    public void checkInput() {

    }
    public void checkValue() {
        //.contains(-)

    }
    public void checkGame() {

    }

}
