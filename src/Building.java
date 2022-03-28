/**
 * building class for define and draw building objects with one private data field: floorHeight
 * @author Ridvan Taskiran
 * @since Date: 16.05.2021 
 */
public class Building {
	public int floorCount;
	public double centerX;
	public double buildingWidth;
	public String buildingColor;
	private double floorHeight = 0.06;
	/**
	 * Constructor that creates a Building object based on the input arguments
	 * @param floorCount floor count of the building
	 * @param centerX center of the building
	 * @param buildingWidth width of the building
	 * @param buildingColor color of the building
	 */
	Building(int floorCount, double centerX, double buildingWidth, String buildingColor){
		this.floorCount = floorCount;
		this.centerX = centerX;
		this.buildingWidth = buildingWidth;
		this.buildingColor = buildingColor;
		
	}

	// A method for drawing the building using StdDraw
	public void draw() {
		//for loop to draw all floors
		for(int i=1; i<=floorCount; i++) {
			double y = (i*floorHeight) - (floorHeight/2); // building center y values
			//draw borderline for floors with rectangle
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.rectangle(centerX, y, buildingWidth/2, floorHeight/2);
			
			//nested if to decide PenColor
			if(buildingColor.equals("Red"))
				StdDraw.setPenColor(StdDraw.RED);
			else if(buildingColor.equals("Yellow"))
				StdDraw.setPenColor(StdDraw.YELLOW);
			else if(buildingColor.equals("Blue"))
				StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
			else if(buildingColor.equals("Orange"))
				StdDraw.setPenColor(StdDraw.PRINCETON_ORANGE);
			else if(buildingColor.equals("Green"))
				StdDraw.setPenColor(StdDraw.GREEN);
			//to draw floors with filledRectangle
			StdDraw.filledRectangle(centerX, y, buildingWidth/2, floorHeight/2);
		}
		
		double roofHeight= floorHeight/2;
		double [] x = {centerX-(buildingWidth/2), centerX, centerX+(buildingWidth/2)}; // x values of corners
		double [] y = {floorHeight*floorCount, floorHeight*floorCount+roofHeight, floorHeight*floorCount}; // x values of corners
		//draw borderline for roof with polygon
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.polygon(x,y);
		//to draw roof with filledPolygon
		StdDraw.setPenColor(StdDraw.BOOK_RED);
		StdDraw.filledPolygon(x, y);
		StdDraw.show();
	}
	
}
