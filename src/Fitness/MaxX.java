package Fitness;

import java.util.List;

import TurtleInstructions.Line3D;

public class MaxX extends Evaluator {

	@Override
	public double evaluate(List<Line3D> lines) {
		double result = Double.NEGATIVE_INFINITY;
		for (Line3D l: lines){
			result = Math.max(Math.max(result, l.origin.x),l.destination.x);
		}
		return result;
	}

}
