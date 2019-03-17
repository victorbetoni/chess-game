package application;

import chess.ChessPiece;

public class UI {
	public static void printBoard(ChessPiece[][] chessPiece) {
		for(int i=0; i<chessPiece.length; i++) {
			System.out.print((8-i) + " ");
			for(int j=0; j<chessPiece.length; j++) {
				printPiece(chessPiece[i][j]);
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");
	}
	
	public static void printPiece(ChessPiece piece) {
		if(piece == null) {
			System.out.print("-");
		}else {
			System.out.print(piece);
		}
		System.out.print(" ");
	}
	
}
