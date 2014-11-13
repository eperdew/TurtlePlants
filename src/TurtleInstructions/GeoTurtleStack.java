package TurtleInstructions;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class GeoTurtleStack {

	protected Deque<GeoTurtle> stack;
	GeoTurtle current;

	public GeoTurtleStack(GeoTurtle t) {
		stack = new LinkedList<GeoTurtle>();
		current = t;
	}
	
	public List<Line3D> getLines(){
		return current.lines;
	}

	public void pushTurtle() {
		stack.push(current.copy());
	}

	public void popTurtle() {
		try {
			current = stack.pop();
		} catch (Exception e) {
			//System.out.println("Invalid pop, ignoring");
		}
	}

}
