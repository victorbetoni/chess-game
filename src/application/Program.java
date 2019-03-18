package application;

import java.util.Scanner;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {
	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();
		
		while(true) {
			UI.printBoard(chessMatch.getPieces());
			System.out.print("Source: ");
			ChessPosition source =  UI.readChessPosition(sn);
			
			System.out.print("\nTarget: ");
			ChessPosition target = UI.readChessPosition(sn);
			
			ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
			
		}
	}
}
