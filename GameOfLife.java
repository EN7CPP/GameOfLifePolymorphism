import java.io.IOException;
import java.util.Scanner;

public class GameOfLife {
private World world;
public GameOfLife(World w) {
	this.world=w;
}

public void play()throws IOException{
    Scanner keyboard=new Scanner(System.in);

    while(true){
        System.out.print("Please enter \"s\" to play and \"q\" to quit! : ");
        char input=keyboard.nextLine().charAt(0);
        try {
            if(input=='s'){
                world.nextGeneration();
                this.print();
            }
            else if(input=='q'){
                System.out.println("Quitting");
                break;
            }
            else throw new IOException("Please follow the instructions!");
        }
        catch(IOException e) {
        	System.out.println(e.getMessage());
        }

    }
}
public void print() {
	System.out.println("- "+this.world.getGenerationCount());
	for(int i=0;i<world.getHeight();i++){
		
		for(int z=0;z<world.getWidth();z++){
			if(world.getCell(z,i))System.out.print("#");
			else System.out.print("-");
		}
		
		System.out.println();
	}
}
public static void main(String[] args) throws IOException  {
	World w=null;
	if(args.length==0)throw new IOException("No main argument");
	else if(args.length==1){
		w=new ArrayWorld(args[0]);
	}
	else if(args.length==2){
		if(args[0].equals("--packed")){
			w=new PackedLife(args[1]);
		}
		else if(args[0].equals("--array")){
			w=new ArrayWorld(args[1]);
		}
		else throw new IOException("Unknown input!");
	}

	
	GameOfLife gol=new GameOfLife(w);
	gol.play();
}
}
