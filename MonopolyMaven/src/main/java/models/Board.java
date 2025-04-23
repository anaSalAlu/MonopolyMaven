package models;

/**
 * @author Ana
 */
public class Board {

	public Cell[] cells;
	public int size;

	public Cell[] getCells() {
		return cells;
	}

	public void setCells(Cell[] cells) {
		this.cells = cells;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}
