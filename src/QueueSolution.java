import java.util.*;

/*
 * need to enqueue kirby's position
 * dequeue kirby's position?
 * added kirby tile to seen
 * queue tile north, south, east, and west of kirby and checking if cake is there and marking them as seen
 * pop the first thing in queue and place that in dequeue
 * process the tile that you just popped
 * pop the first thing in queue and place that in dequeue
 * process the tile that you just popped
 * 
 * don't process walls
 * 
 * dequeue is the solution
 * 
 * */
public class QueueSolution extends MapScanner{
	
	private ArrayDeque<Tile> enqueue = new ArrayDeque<Tile>();	//contains walkable tiles
	private ArrayDeque<Tile> dequeue = new ArrayDeque<Tile>();	//contains the solution tiles
	private ArrayList<Tile> seen = new ArrayList<Tile>();		//contains all tiles that have been visited
	private Tile curr;											//current tile being processed
	private boolean cakeFound = false;
	
	public QueueSolution(String fileName, boolean isCoordinateMap) {
		super(fileName, isCoordinateMap);
		this.fileToArray();
		Tile temp = new Tile('K', this.kirbyRow(), this.kirbyCol());
		
		curr = temp;
		
		//redundant but helps me understand
		enqueue.add(temp); 
		dequeue.add(enqueue.remove());
		
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
					enqueue.add(northTile);
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
					enqueue.add(southTile);
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
					enqueue.add(eastTile);
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
					enqueue.add(westTile);
				}
			}
		}
		
		if(!enqueue.isEmpty()) {
			//add the dequeue here because the east tile is the last one to be proccessed
			curr = enqueue.pop();
			dequeue.add(curr);
			map[curr.getRow()][curr.getCol()] = '+';
		}
	}
	public ArrayDeque<Tile> getEnqueue() {
		return enqueue;
	}

	public void setEnqueue(ArrayDeque<Tile> enqueue) {
		this.enqueue = enqueue;
	}

	public ArrayDeque<Tile> getDequeue() {
		return dequeue;
	}

	public void setDequeue(ArrayDeque<Tile> dequeue) {
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
