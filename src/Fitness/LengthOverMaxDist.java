package Fitness;

import java.util.List;

import javax.vecmath.Point3d;

import TurtleInstructions.Line3D;

public class LengthOverMaxDist extends Evaluator {

	@Override
	public double evaluate(List<Line3D> lines) {
		double length = 0;
		double maxDist = 0;
		for (Line3D l: lines){
			length += l.magnitude();
			maxDist = Math.max(maxDist, l.origin.distance(new Point3d(0,0,0)));
			maxDist = Math.max(maxDist, l.destination.distance(new Point3d(0,0,0)));
		}
		return length/(maxDist + 1);
	}

}
