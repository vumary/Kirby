public class Tile {
	
	private int row;		//row the tile is at
	private int col;		//col the tile is at
	private char tile;		//what the char on the map is at that spot
	
	public Tile(char tile, int row, int col) {
		this.row = row;
		this.col = col;
		this.tile = tile;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public char getTile() {
		return tile;
	}

	public void setTile(char tile) {
		this.tile = tile;
	}
	
	
}
