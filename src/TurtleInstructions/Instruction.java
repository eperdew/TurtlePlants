package TurtleInstructions;


public class Instruction {
	public final Move move;
	public final double arg;
	
	public Instruction(Move m, double a){
		move = m;
		arg = a;
	}
	
	@Override
	public String toString(){
		return "Move: " + move.toString() + ", arg: " + arg;
	}
	
}
