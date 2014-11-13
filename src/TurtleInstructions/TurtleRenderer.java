package TurtleInstructions;

public class TurtleRenderer {
	private static Frame frame = new Frame(600, 600, "3D Turtle Graphics");

	public static void render (InstructionSet is){
		is.enactOn(new TurtleStack(new Turtle(0,frame)));
	}
	
}