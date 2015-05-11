package org.uqbarproject.sokoban.domain.pieces;

import org.uqbarproject.sokoban.domain.behavior.Movement;

public class Place extends Element{

	@Override
	public boolean mayIMove(Movement aMovement, int places) {
		return false;
	}

	@Override
	public boolean iAmSolid() {
		return false;
	}

}
