package Fitness;

import java.util.List;
import TurtleInstructions.Line3D;

public abstract class Evaluator {
	
	public abstract double evaluate(List<Line3D> lines);
	
}
