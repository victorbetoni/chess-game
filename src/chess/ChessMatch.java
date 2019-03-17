package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
	
	private Board board;
	
	public ChessMatch() {
		board = new Board(8,8);
		initialSetup();
	}
	
	public ChessPiece[][] getPieces(){
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		for(int i=0; i<board.getRows(); i++) {
			for(int c=0; c<board.getColumns(); c++) {
				mat[i][c] = (ChessPiece) board.pieceAt(i,c);
			}
		}
		return mat;
	}
	
	private void initialSetup() {
		board.placePiece(new Rook(board, Color.WHITE), new Position(0,0));
		board.placePiece(new King(board, Color.WHITE), new Position(0,4));
		board.placePiece(new Rook(board, Color.BLACK), new Position(7,7));
		board.placePiece(new King(board, Color.BLACK), new Position(7,3));
	}
	
}
