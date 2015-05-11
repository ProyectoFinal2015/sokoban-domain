package org.uqbarproject.sokoban.domain.pieces;

import java.util.ArrayList;
import java.util.List;

import org.uqbarproject.sokoban.domain.behavior.Movement;
import org.uqbarproject.sokoban.domain.behavior.Position;

public class GameBoard {

	private Sokoban aPlayer;
	private List<Element> elements;

	public GameBoard(){
		elements = new ArrayList<Element>();
	}

	public boolean mayIMove(Element element, Movement aMovement, int places) {
		//puedo mover un elemento: 
		//	* Si no tengo a alguien en la nueva posición
		//	* Si los elementos en la posición que tengo cumplen con:
		//		* Si no es sólido
		//		* Si es sólido y se puede mover.
		Position newPosition = element.getMyPosition().clone(aMovement, places);
		if (elements.stream()
				.filter(x -> x.getMyPosition().equals(newPosition))
				.count() == 0)
			return true;
		if (elements.stream()
				.filter(x -> x.getMyPosition().equals(newPosition) && (!x.iAmSolid() || x.mayIMove(aMovement, places)))
				.count() != 0){
			//Muevo las que correspondan
			elements.forEach(
					x -> {
					if (x.getMyPosition().equals(newPosition) && x.mayIMove(aMovement, places)){
						x.move(aMovement, places);
					}
					});
			return true;
		}
		return false;
	}

	public Sokoban getaPlayer() {
		return aPlayer;
	}

	public void setaPlayer(Sokoban aPlayer) {
		this.aPlayer = aPlayer;
	}
	public void addElement(Element anElement){
		this.elements.add(anElement);
	}

}
