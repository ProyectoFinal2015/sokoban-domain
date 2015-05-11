package org.uqbarproject.sokoban.domain.pieces;

import org.uqbarproject.sokoban.domain.behavior.Movement;
import org.uqbarproject.sokoban.domain.behavior.Position;

public abstract class Element {
	private Position myPosition;
	private GameBoard myGameBoard;

	public void move(Movement aMovement, int places){
		if (myGameBoard.mayIMove(this, aMovement, places))
			aMovement.move(getMyPosition(), places);
	}
	
	public abstract boolean mayIMove(Movement aMovement, int places);
	public abstract boolean iAmSolid();
	
	public Position getMyPosition() {
		return myPosition;
	}

	public void setMyPosition(Position myPosition) {
		this.myPosition = myPosition;
	}


	public GameBoard getMyGameBoard() {
		return myGameBoard;
	}


	public void setMyGameBoard(GameBoard myGameBoard) {
		this.myGameBoard = myGameBoard;
		myGameBoard.addElement(this);
	}
	
}
