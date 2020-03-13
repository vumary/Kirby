
public class p1 {
	public static void main(String[] args) {

		
		Args main = new Args();
		main.transverse(args);
		
		//use the queue-based approach
		if(main.getQueue()) {
			QueueSolution sol = new QueueSolution(args[args.length - 1], main.getInCoordinate());
			sol.solve();
			//the output file is in the coordinate-based system. 
			//If the switch is not set, the output file is in the text-map format.
			if(main.getOutCoordinate()) {
				sol.printCoordMap();
			}
			else {
				sol.printTextMap();
			}
		}
		
		
		//use the stack-based approach
		if(main.getStack()) {
			StackSolution sol = new StackSolution(args[args.length - 1], main.getInCoordinate());
			sol.solve();
			
			//the output file is in the coordinate-based system. 
			//If the switch is not set, the output file is in the text-map format.
			if(main.getOutCoordinate()) {
				sol.printCoordMap();
			}
			else {
				sol.printTextMap();
			}
		}
		
		//print the runtime of the program
		if(main.getTime()) {
			
		}
		
		//find the shortest path
		if(main.getOpt()) {
			
		}
		
		
		
		
		
		
		
		
		
		/*
		//testing MapScanner on a grid map
		MapScanner testGrid = new MapScanner("grid.input", false);
		testGrid.fileToArray();
		testGrid.printMap();
		System.out.println();
		
		//testing MapScanner on a coordinate map
		MapScanner testCoord = new MapScanner("coord.input", true);
		testCoord.fileToArray();
		testCoord.printMap();
		System.out.println();
		
		//testing to find ASCII of cake
		char c = 'C';
		System.out.println("C: "+(int) c);
		System.out.println();
		
		//testing isCake()
		System.out.println("Grid: "+testGrid.isCake());
		System.out.println("Coordinate: "+testCoord.isCake());
		System.out.println();
		
		//testing to find ASCII of kirby
		char k = 'K';
		System.out.println("K: "+(int) k);
		System.out.println();
		
		//testing locateKirby()
		System.out.println("row: "+testGrid.kirbyRow()+"\t"+"col: "+testGrid.kirbyCol());
		System.out.println("row: "+testCoord.kirbyRow()+"\t"+"col: "+testCoord.kirbyCol());
		System.out.println();
		
		//testing inheritance of the QueueSolution class
		QueueSolution testGrid2 = new QueueSolution("grid2.input", false);
		testGrid2.fileToArray();
		testGrid2.printMap();
		System.out.println();
		System.out.println(testGrid2.getDequeue().peek().getTile());
		System.out.println("row: "+testGrid2.getDequeue().peek().getRow());
		System.out.println("col: "+testGrid2.getDequeue().peek().getCol());
		System.out.println();
		
		//testing isCake() on a QueueSolution object
		QueueSolution testGrid3 = new QueueSolution("grid3.input", false);
		testGrid3.solve();
		
		//TESTING QUEUE SOLUTION
		QueueSolution _test = new QueueSolution("grid4.input", false);		
		_test.solve();
		_test.printCoordMap();
		*/
		
	}
}
