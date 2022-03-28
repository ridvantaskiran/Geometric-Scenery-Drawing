import java.io.FileNotFoundException; //To ignore the error and run it
import java.io.File; //to access text file
import java.util.ArrayList; //be able to use arraylist
import java.util.Scanner; //to scan file
public class main {

	/**
	 * The program draws a scenery that provided by given .text data with using StdDraw Library. 
	 * @author Ridvan Taskiran, Student ID: 041901002
	 * @since Date: 16.05.2021
	 * @throws FileNotFoundException To ignore the error and run it
	 */
	public static void main(String[] args) throws FileNotFoundException {

		 String filename = "data1.txt"; // input filename
		 
		 // store scene elements in array lists
		 ArrayList<Building> buildings = new ArrayList<>();
		 ArrayList<Tree> trees = new ArrayList<>();
		 
		 loadData(filename, buildings, trees); // load scene elements from the input fill	        
		 plotScene(buildings, trees); // plot scene elements
		 
	}
	/**
	 * The void method that load data from text file to ArrayList.
	 * @param filename String for the access data file
	 * @param buildings ArrayList that holds building objects
	 * @param trees ArrayList that holds tree objects
	 * @throws FileNotFoundException To ignore the error and run it
	 */
	public static void loadData(String filename, ArrayList<Building> buildings, ArrayList<Tree> trees) throws FileNotFoundException{
		//define scanner object to read text file
		File file = new File(filename);
		Scanner input = new Scanner(file);
		
		//while loop to read all line from text file
		while(input.hasNext()) {
			String str = input.next(); //Store lines as string
			String [] line = str.split(";"); //With split function, put elements to array. separated by semicolon			
			
			String object = line[0]; // decide whether is tree or building
			int i = 0;
			String building = "Building";
			
			if(object.equals(building)){ // if first element is building
				//with parse function. it returns string to wanted type
				int	floorCount = Integer.parseInt(line[i+1]);
				double centerX = Double.parseDouble(line[i+2]);
				double buildingWidth = Double.parseDouble(line[i+3]);
				String buildingColor = line[i+4];

				//create a building object scenery
				Building scenery = new Building(floorCount, centerX, buildingWidth, buildingColor);				
				buildings.add(scenery);	//add scenery object to the buildings arraylist
			}
			// if it is not equals to building then it is tree
			else{
				double centerX = Double.parseDouble(line[1]);
				
				Tree tree = new Tree(centerX); //create a tree object tree
				trees.add(tree); ////add tree object to the trees arraylist
			}
								
		}
		input.close(); // close the Scanner object used for reading the input file
		
	}
	/**
	 * The void method draws scenery from arraylist provided by loadData method
	 * @param buildings ArrayList that holds building objects
	 * @param trees ArrayList that holds tree objects
	 */
	public static void plotScene(ArrayList<Building> buildings, ArrayList<Tree> trees) {
	      // set the size of the drawing canvas
	      int canvasW = 600, canvasH = 600;
	      StdDraw.setCanvasSize(canvasW, canvasH);
	      // set the scale of the coordinate system
	      StdDraw.setXscale(0, 1); // x axis scale is in the range [0, 1]
	      StdDraw.setYscale(0, 1); // y axis scale is in the range [0, 1]
	      
	      //draw buildings with using for-each loop
	      for (Building b : buildings)
	    	  b.draw();
	      
	      //draw buildings with using for-each loop	  
	      for (Tree t : trees)
	    	  t.draw();
	      
	   }
}