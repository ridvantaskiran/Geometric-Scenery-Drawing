/**
 * tree class for define and draw tree objects with three private data field: treeBodyHeight treeBodyHeight treeRadius
 * @author Ridvan Taskiran
 * @since Date: 16.05.2021
 */
public class Tree {
	public double centerX;
	private double treeBodyHeight = 0.08;
	private double treeBodyWidth = 0.02;
	private double treeRadius = 0.04;
	
	/**
	 * Constructor that creates a tree object based on the input arguments
	 * @param centerX center of the tree
	 */
	Tree(double centerX){
		this.centerX = centerX;
	}
	
	// A method for drawing the tree using StdDraw
	public void draw() {
		//to draw top of the tree
		StdDraw.setPenColor(StdDraw.GREEN);
		StdDraw.filledCircle(centerX, treeBodyHeight+treeRadius, treeRadius);
		
		//to draw body of the tree
		StdDraw.setPenColor(StdDraw.PINK);
		StdDraw.filledRectangle(centerX, treeBodyHeight/2, treeBodyWidth/2, treeBodyHeight/2);
		
		// to draw borderline of the tree
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.circle(centerX, treeBodyHeight+treeRadius, treeRadius);		
		StdDraw.rectangle(centerX, treeBodyHeight/2, treeBodyWidth/2, treeBodyHeight/2);
		StdDraw.show();
	}
}
