package com.tictactoe;

import java.util.Scanner;

public class TicTacToe {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		char playAgain;
		do {
		char[][] board = { { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };
		
		
		System.out.println("Enter Player X Name:");
		String playerX = sc.next();
		
		System.out.println("Enter Player O Name:");
		String playerO = sc.next();
		
		char player = 'X';
		boolean gameOver = false;

		System.out.println("---TIC TAC TOE---");
		System.out.println();

		for (int turn = 1; turn <= 9; turn++) {
			printBoard(board);

			System.out.println();
			
			if(player == 'X') {
				System.out.println(playerX+"'s Turn (X)");
			}else {
				System.out.println(playerO+"'s Turn (O)");
			}
			
			int row;
			int column;
			
			while(true) {

			System.out.println("Enter Row (1-3)");
			row = sc.nextInt();

			System.out.println("Enter Column (1-3)");
			column = sc.nextInt();

			if (isValidMove(board, row, column)) {
				break;
			}
			System.out.println("Invalid Move! Try Again.");
			}

			board[row - 1][column - 1] = player;

			if (checkwinner(board, player)) {
				printBoard(board);
				System.out.println();
				if(player == 'X') {
					System.out.println(playerX+" (X) WINS!!");
				}else {
					System.out.println(playerO+" (O) WINS!!");
				}
				gameOver = true;
				break;
			}

			if (player == 'X') {
				player = 'O';
			} else {
				player = 'X';
			}
			System.out.println();
		}
		if (!gameOver) {
			printBoard(board);
			System.out.println();
			System.out.println("It's A Draw!!");
		}
		System.out.println("Do you Want to Play Again? (Y/N): ");
		playAgain = sc.next().charAt(0);
		}while(playAgain == 'Y' || playAgain == 'y');

		sc.close();

	}

	private static boolean isValidMove(char[][] board, int row, int column) {
		if (row < 1 || row > 3 || column < 1 || column > 3) {
			return false;
		}
		if (board[row - 1][column - 1] != ' ') {
			return false;
		}
		return true;
	}

	private static boolean checkwinner(char[][] board, char player) {

		for (int i = 0; i < 3; i++) {
			if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
				return true;
			}
		}

		for (int i = 0; i < 3; i++) {
			if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
				return true;
			}
		}

		if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
			return true;
		}

		if (board[2][0] == player && board[1][1] == player && board[0][2] == player) {
			return true;
		}
		return false;
	}

	private static void printBoard(char[][] board) {
		System.out.println(" " + board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
		System.out.println("---+---+---");
		System.out.println(" " + board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
		System.out.println("---+---+---");
		System.out.println(" " + board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
	}
}
