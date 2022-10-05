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
    public void newGame() {
         board = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int x = 0; x < 3; x++) {
                board[i][x] = "| - |";
                }
            }
        gameAssignPlayer();

    }
    public void gameAssignPlayer() {
        Scanner sc = new Scanner(System.in);
        players = new String[2];
        for (int i = 0; i < 2; i++) {
            System.out.println("What is Player " + (i + 1) + "'s name?");
            players[i] = sc.nextLine();
        }
        gameSession();
    }
    public void gameSession() {
        System.out.println("Your Board:");
        boardPrinter();
    }




    public void boardPrinter() {
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                System.out.print(board[row][column] + " ");
            }
            System.out.println();
        }
    }

}
