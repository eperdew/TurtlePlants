package TurtleInstructions;
import java.util.Deque;
import java.util.LinkedList;


public class TurtleStack {

	protected Deque<Turtle> stack;
	Turtle current;
	
	public TurtleStack(Turtle t){
		stack = new LinkedList<Turtle>();
		current = t;
	}
	
	public void pushTurtle(){
		stack.push(current.copy());
	}
	
	public void popTurtle(){
		try {
			current = stack.pop();
		}
		catch (Exception e){
			System.out.println("Invalid pop");
		}
	}
	
}
