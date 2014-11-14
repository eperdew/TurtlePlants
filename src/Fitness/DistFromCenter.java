package Fitness;

import java.util.List;

import javax.vecmath.Point3d;

import TurtleInstructions.Line3D;

public class DistFromCenter extends Evaluator {

	@Override
	public double evaluate(List<Line3D> lines) {
		if (lines.size() == 0){
			return -1.0;
		}
		double length = 0;
		Point3d center = new Point3d(0,0,0);
		for (Line3D l: lines){
			center.add(l.origin);
			center.add(l.destination);
			length += l.magnitude();
		}
		center.scale(.5/lines.size());
		double totalDist = 0;
		for (Line3D l: lines){
			totalDist += l.origin.distance(center);
			totalDist += l.destination.distance(center);
		}
		totalDist = totalDist/lines.size();
		return length/(totalDist);
	}

}
