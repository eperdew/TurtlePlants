package Fitness;

import java.util.List;

import TurtleInstructions.Line3D;

public class SumLength extends Evaluator {

	@Override
	public double evaluate(List<Line3D> lines) {
		double result = 0;
		for (Line3D l: lines){
			result += l.magnitude();
		}
		return result;
	}

	
	
}
