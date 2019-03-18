package boardgame;

import exceptions.BoardException;

public class Board {
	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		if(rows < 0 || columns < 0) {
			throw new BoardException("Error creating board: There must be at leat 1 row and 1 column.");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}
	
	public Piece pieceAt(int row, int column) {
		if(!positionExists(row, column)) {
			throw new BoardException("Error: Piece not in the board.");
		}
		return pieces[row][column];
	}
	
	public Piece pieceAt(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Piece not in the board.");
		}
		return pieces[position.getRow()][position.getColumn()]; 
	}
	
	public void placePiece(Piece piece, Position position) {
		if (thereIsAPiece(position)) {
			throw new BoardException("There is already a piece on position " + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	public Piece removePiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Position not in the board");
		}
		if(pieceAt(position) == null) {
			return null;
		}
		
		Piece aux = pieceAt(position);
		aux.position = null;
		pieces[position.getRow()][position.getColumn()] = null;
		
		return aux;
	}
	
	public boolean positionExists(int row, int colum) {
		return row >= 0 && row < rows && colum >= 0 && colum < columns;	
	}
	
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	public boolean thereIsAPiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Error: Piece not in the board.");
		}
		return pieceAt(position) != null;
	}
	
}
