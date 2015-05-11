package org.uqbarproject.sokoban.domain.pieces;

import org.uqbarproject.sokoban.domain.behavior.Movement;

public class Sokoban extends Element{

	@Override
	public boolean mayIMove(Movement aMovement, int places) {
		return true;
	}

	@Override
	public boolean iAmSolid() {
		return true;
	}

}