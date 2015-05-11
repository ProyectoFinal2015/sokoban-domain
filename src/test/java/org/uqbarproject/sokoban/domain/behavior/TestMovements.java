package org.uqbarproject.sokoban.domain.behavior;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.uqbarproject.sokoban.domain.pieces.Box;
import org.uqbarproject.sokoban.domain.pieces.GameBoard;
import org.uqbarproject.sokoban.domain.pieces.Place;
import org.uqbarproject.sokoban.domain.pieces.Sokoban;
import org.uqbarproject.sokoban.domain.pieces.Wall;

public class TestMovements {

	private Sokoban personaje;
	private Wall pared;
	private GameBoard tablero;
	private Box caja;
	private Place goal;
	private Place goalOcupado;
	private Box cajaEnGoal;
	
	
	@Before
	public void init(){
		tablero = new GameBoard();
		personaje = new Sokoban();
		personaje.setMyGameBoard(tablero);
		personaje.setMyPosition(new Position(2,2));
		tablero.setaPlayer(personaje);
		pared = new Wall();
		pared.setMyGameBoard(tablero);
		pared.setMyPosition(new Position(1,2));
		caja = new Box();
		caja.setMyPosition(new Position(3,2));
		caja.setMyGameBoard(tablero);
		goal = new Place();
		goal.setMyPosition(new Position(2,3));
		goal.setMyGameBoard(tablero);
		goalOcupado = new Place();
		goalOcupado.setMyPosition(new Position(2,0));
		goalOcupado.setMyGameBoard(tablero);
		cajaEnGoal = new Box();
		cajaEnGoal.setMyPosition(new Position(2,1));
		cajaEnGoal.setMyGameBoard(tablero);		
	}
	
	@Test
	public void sokobanNoSeMueveSiTieneUnaPared(){
		personaje.move(new MovementLeft(), 1);
		Assert.assertTrue(new Position(2,2).equals(personaje.getMyPosition()));
	}
	@Test
	public void sokobanSeMuevePorqueTieneUnaCaja(){
		personaje.move(new MovementRight(), 1);
		Assert.assertTrue(new Position(3,2).equals(personaje.getMyPosition()));
		Assert.assertTrue(new Position(4,2).equals(caja.getMyPosition()));
	}
	@Test
	public void sokobanPisaElGoalYNoSeMueve(){
		personaje.move(new MovementTop(), 1);
		Assert.assertTrue(new Position(2,3).equals(personaje.getMyPosition()));
		Assert.assertTrue(new Position(2,3).equals(goal.getMyPosition()));		
	}
	@Test
	public void sokobanMueveCajaAlGoal(){
		personaje.move(new MovementDown(), 1);
		Assert.assertTrue(new Position(2,1).equals(personaje.getMyPosition()));
		Assert.assertTrue(new Position(2,0).equals(goalOcupado.getMyPosition()));
		Assert.assertTrue(new Position(2,0).equals(cajaEnGoal.getMyPosition()));
	}
	
	@Test
	public void sokobanNoSeMueveSiTieneCajaYPared(){
		Wall otraPared = new Wall();
		otraPared.setMyPosition(new Position(4,2));
		otraPared.setMyGameBoard(tablero);
		personaje.move(new MovementRight(), 1);
		Assert.assertTrue(new Position(2,2).equals(personaje.getMyPosition()));
		Assert.assertTrue(new Position(3,2).equals(caja.getMyPosition()));
		Assert.assertTrue(new Position(4,2).equals(otraPared.getMyPosition()));
	}
	
}
