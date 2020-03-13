import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;

public class StackSolution extends MapScanner{
	
	Stack s = new Stack<Integer>();
	private Stack enqueue = new Stack<Tile>();					//contains walkable tiles
	private Stack dequeue = new Stack<Tile>();					//contains the solution tiles
	private ArrayList<Tile> seen = new ArrayList<Tile>();		//contains all tiles that have been visited
	private Tile curr;											//current tile being processed
	private boolean cakeFound = false;
	
	public StackSolution(String fileName, boolean isCoordinateMap) {
		super(fileName, isCoordinateMap);
		this.fileToArray();
		Tile temp = new Tile('K', this.kirbyRow(), this.kirbyCol());
		
		curr = temp;
		
		//redundant but helps me understand
		enqueue.push(temp); 
		dequeue.push(enqueue.pop());
		
		seen.add(temp);
	}
	
	public boolean beenSeen(Tile tile) {
		
		for(int i=0; i<seen.size(); i++) {
			//checks whether the coordinates if tile are already in the seen list
			if(	seen.get(i).getRow()==tile.getRow()&&
				seen.get(i).getCol()==tile.getCol()) {
				return true;
			}
		}
		
		return false;
	}

	public void northTile() {
		int currRow = curr.getRow();
		int currCol = curr.getCol();
		
		//need an if to see if its out of range
		if(currRow>0) {
			Tile northTile = new Tile(map[currRow-1][currCol], currRow-1, currCol);
			//System.out.println("THIS IS THE NORTH TILE: "+"'"+map[currRow-1][currCol]+"'"+" ("+(currRow-1)+", "+currCol+")");
			if(!beenSeen(northTile)) {
				if(northTile.getTile()=='C') {
					cakeFound = true;
				}
				else if(northTile.getTile()=='.'&&(!cakeFound)) {
					seen.add(northTile);
					enqueue.push(northTile);
				}
			}
		}
		
	}
	
	public void southTile() {
		int currRow = curr.getRow();
		int currCol = curr.getCol();
		
		//need an if to see if its out of range
		if(currRow<(map.length-1)) {
			Tile southTile = new Tile(map[currRow+1][currCol], currRow+1, currCol);
			//System.out.println("THIS IS THE SOUTH TILE: "+"'"+map[currRow+1][currCol]+"'"+" ("+(currRow+1)+", "+currCol+")");
			if(!beenSeen(southTile)) {
				if(southTile.getTile()=='C') {
					cakeFound = true;
				}
				else if(southTile.getTile()=='.'&&(!cakeFound)) {
					seen.add(southTile);
					enqueue.push(southTile);
				}
			}
		}
	}

	public void eastTile() {
		int currRow = curr.getRow();
		int currCol = curr.getCol();
		
		//need an if to see if its out of range
		if(currCol>0) {
			Tile eastTile = new Tile(map[currRow][currCol-1], currRow, currCol-1);
			//System.out.println("THIS IS THE EAST TILE: "+"'"+map[currRow][currCol-1]+"'"+" ("+currRow+", "+(currCol-1)+")");
			if(!beenSeen(eastTile)) {
				if(eastTile.getTile()=='C') {
					cakeFound = true;
				}
				else if(eastTile.getTile()=='.'&&(!cakeFound)) {
					seen.add(eastTile);
					enqueue.push(eastTile);
				}
			}
		}
	}
	 
	
	public void westTile() {
		int currRow = curr.getRow();
		int currCol = curr.getCol();
		
		//need an if to see if its out of range
		if(currCol<(map[0].length-1)) {
			Tile westTile = new Tile(map[currRow][currCol+1], currRow, currCol+1);
			//System.out.println("THIS IS THE WEST TILE: "+"'"+map[currRow][currCol+1]+"'"+" ("+currRow+", "+(currCol+1)+")");
			if(!beenSeen(westTile)) {
				if(westTile.getTile()=='C') {
					cakeFound = true;
				}
				else if(westTile.getTile()=='.'&&(!cakeFound)) {
					seen.add(westTile);
					enqueue.push(westTile);
				}
			}
		}
		
		if(!enqueue.isEmpty()) {
			//add the dequeue here because the east tile is the last one to be proccessed
			curr = (Tile) enqueue.pop();
			dequeue.add(curr);
			map[curr.getRow()][curr.getCol()] = '+';
		}
	}
	public Stack<Tile> getEnqueue() {
		return enqueue;
	}

	public void setEnqueue(Stack<Tile> enqueue) {
		this.enqueue = enqueue;
	}

	public Stack<Tile> getDequeue() {
		return dequeue;
	}

	public void setDequeue(Stack<Tile> dequeue) {
		this.dequeue = dequeue;
	}

	public ArrayList<Tile> getSeen() {
		return seen;
	}

	public void setSeen(ArrayList<Tile> seen) {
		this.seen = seen;
	}
	
	public void solve() {
		if(!this.isCake()) {
			System.out.println("The cake is a lie.");
		}
		else {
			while(!cakeFound) {
				this.northTile();
				this.southTile();
				this.eastTile();
				this.westTile();
			}
		}
	}
	
}
