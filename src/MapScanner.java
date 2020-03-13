import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Scanner;


//create a pair class

public class MapScanner extends Args{
	
	private int rows;					//amount of rows in the map
	private int cols;					//amount of cols in the map
	private String fileName;			//name of the file that contains the map
	protected char[][] map;				//contains the converted map file
	private boolean isCoordinateMap;	//whether the input is a coordinate or grid file
	
	public MapScanner(String fileName, boolean isCoordinateMap) {
		this.fileName = fileName;
		this.isCoordinateMap = isCoordinateMap;
		char[][] map = null;
		rows = 0;
		cols = 0;
	}
	
	public void gridConversion() {
		
		File file = new File(fileName);
		
		try{
			Scanner sc = new Scanner(file); // set up scanner
			
			rows = sc.nextInt();
			cols = sc.nextInt();
			
			sc.nextLine();
			
			//instantiating map to the correct amount of rows and cols
			map = new char[rows][cols];
			
			//looping through an empty map and instantiating each spot to its respective char
			for(int r=0; r<rows; r++) {
				//temp variable that contains an entire line in the input file
				String temp = sc.nextLine();
				
				for(int c=0; c<cols; c++) {
					//temp variable that contains the current char
					char cur = temp.charAt(c);
					map[r][c] = cur;
				}
			}
			sc.close(); // close scanner
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}
		
	}
	
	public void coordinateConversion() {
		
		File file = new File(fileName);
		
		try{
			Scanner sc = new Scanner(file); // set up scanner
			
			rows = sc.nextInt();
			cols = sc.nextInt();
			
			//instantiating map to the correct amount of rows and cols
			map = new char[rows][cols];
			
			int curRow;		//temp row that the char is at
			int curCol;		//temp col that the char is at
			char curChar;	//temp char at the curRow and curCol
			
			sc.nextLine();
			
			while(sc.hasNextLine()){
				//temp variable that contains an entire line in the input file
				String temp = sc.nextLine();
				
				//instantiating current variables
				curRow = Character.getNumericValue(temp.charAt(2));
				curCol = Character.getNumericValue(temp.charAt(4));
				curChar = (char) temp.charAt(0);
				
				//adding character to its respective spot in the map
				map[curRow][curCol] = curChar;
			}
			
			sc.close(); // close scanner
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}
		
		//filling in all null spots with "."
		for(int r=0; r<rows; r++) {
			for(int c=0; c<cols; c++) {
				if( (int) map[r][c] == 0) {
					map[r][c] = '.';
				}
			}
		}
		
	}
	
	public void fileToArray() {
		
		//if it is a coordinate input, then redirect to coordinateConversion()
		if(isCoordinateMap) {
			this.coordinateConversion();
		}
		//otherwise, it is a grid input, then redirect to gridConversion()
		else {
			this.gridConversion();
		}
		
	}
	
	public void printCoordMap() {
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				System.out.println(map[i][j]+" "+i+" "+j);
			}
		}
	}
	
	public void printTextMap() {
		
		//interacts through every index of map and prints
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	public boolean isCake() {
		
		for(int r=0; r<rows; r++) {
			for(int c=0; c<cols; c++) {
				//checks if there is a 'C' as the current index
				if( (int) map[r][c] == 67) {
					//returns true if cake exists on the map
					return true;
				}
			}
		}
		
		//returns false when cake was never found
		return false;
		
	}
	
	public int[] locateKirby() {
		
		int[] coord = new int[2];
		
		for(int r=0; r<rows; r++) {
			for(int c=0; c<cols; c++) {
				if( (int) map[r][c] == 75) {
					coord[0] = r;
					coord[1] = c;
					return coord;
				}
			}
		}
		
		return coord;
		
	}
	
	public int kirbyRow() {
		return this.locateKirby()[0];
	}
	
	public int kirbyCol() {
		return this.locateKirby()[1];
	}
	
}
