
public class Pattern {
	private String name;
	private String author;
	private int width;
	private int height;
	private int startCol;
	private int startRow;
	private String cells; 
	private String []cellsToBeInitialised;
	
	public String getName() {
		return name;
	}
	
	public Pattern(String format) {
		 String[] arr=format.split(":");
		 cellsToBeInitialised=arr[6].split(" ");
		 startRow=Integer.parseInt(arr[5]);
		 startCol=Integer.parseInt(arr[4]);
		 width=Integer.parseInt(arr[2]);
		 height=Integer.parseInt(arr[3]);
		 cells=arr[6];
		 name=arr[0];
		 author=arr[1];
         
	}
	
	public String getAuthor(){return author;}
	public int getStartCol(){return startCol;}
	public int getStartRow(){return startRow;}
	public String getCells() {return cells;}
	public int getWidth(){return width;}
	public int getHeight(){return height;}

	public void initialise(World world) {
		
		
		for(int i=0;i<cellsToBeInitialised.length;i++){
			for(int z=0;z<cellsToBeInitialised[i].length();z++){
				
				if(cellsToBeInitialised[i].charAt((z))=='0') {
					world.setCell(startCol, startRow, false);startCol++;
					}
				else if(cellsToBeInitialised[i].charAt((z))=='1') {
					world.setCell(startCol, startRow, true);startCol++;
					}
			}
			startRow++;
			startCol=startCol-cellsToBeInitialised[i].length();
			
		}
		
	}

}

	

