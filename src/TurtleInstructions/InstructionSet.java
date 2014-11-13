package TurtleInstructions;
import java.util.List;

public class InstructionSet {
	private List<Instruction> instructions;

	public InstructionSet(List<Instruction> instructions) {
		this.instructions = instructions;
	}

	public List<Instruction> getInstructions() {
		return instructions;
	}

	public void setInstructions(List<Instruction> instructions) {
		this.instructions = instructions;
	}

	public void enactOn(TurtleStack ts) {
		for (Instruction i : instructions) {
			switch (i.move) {
			case FORWARD:
				ts.current.fd(i.arg);
				break;
			case BACK:
				ts.current.bk(i.arg);
				break;
			case TURN_LEFT:
				ts.current.left(i.arg);
				break;
			case TURN_RIGHT:
				ts.current.right(i.arg);
				break;
			case TURN_UP:
				ts.current.up(i.arg);
				break;
			case TURN_DOWN:
				ts.current.down(i.arg);
				break;
			case ROLL_LEFT:
				ts.current.twist(i.arg);
				break;
			case ROLL_RIGHT:
				ts.current.r_twist(i.arg);
				break;
			case PUSH:
				ts.pushTurtle();
				break;
			case POP:
				ts.popTurtle();
				break;
			}
		}
	}
	
	public void enactOn(GeoTurtleStack ts) {
		for (Instruction i : instructions) {
			switch (i.move) {
			case FORWARD:
				ts.current.fd(i.arg);
				break;
			case BACK:
				ts.current.bk(i.arg);
				break;
			case TURN_LEFT:
				ts.current.left(i.arg);
				break;
			case TURN_RIGHT:
				ts.current.right(i.arg);
				break;
			case TURN_UP:
				ts.current.up(i.arg);
				break;
			case TURN_DOWN:
				ts.current.down(i.arg);
				break;
			case ROLL_LEFT:
				ts.current.twist(i.arg);
				break;
			case ROLL_RIGHT:
				ts.current.r_twist(i.arg);
				break;
			case PUSH:
				ts.pushTurtle();
				break;
			case POP:
				ts.popTurtle();
				break;
			}
		}
	}
	
	@Override
	public String toString(){
		return instructions.toString();
	}
	
	

}
