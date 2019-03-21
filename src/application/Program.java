package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import exceptions.ChessException;

public class Program {
	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();
		
		while(true) {
			try {
				UI.clearScreen();
				UI.printMatch(chessMatch);
				
				System.out.print("Source: ");
				ChessPosition source =  UI.readChessPosition(sn);
				
				boolean[][] possibleMoves = chessMatch.possibleMoves(source);
				UI.clearScreen();
				UI.printBoard(chessMatch.getPieces(), possibleMoves);
				
				System.out.print("\nTarget: ");
				ChessPosition target = UI.readChessPosition(sn);
				
				ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
			}catch(ChessException e) {
				System.out.println(e.getMessage());
				sn.nextLine();
			}catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				sn.nextLine();
			}
			
		}
	}
}
