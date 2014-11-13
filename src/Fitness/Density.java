package Fitness;

import java.util.List;

import TurtleInstructions.Line3D;

public class Density extends Evaluator {

	@Override
	public double evaluate(List<Line3D> lines) {
		double length = 0;
		double maxX = Double.NEGATIVE_INFINITY;
		double maxY = Double.NEGATIVE_INFINITY;
		double maxZ = Double.NEGATIVE_INFINITY;
		double minX = Double.POSITIVE_INFINITY;
		double minY = Double.POSITIVE_INFINITY;
		double minZ = Double.POSITIVE_INFINITY;
		for (Line3D l: lines){
			length += l.magnitude();
			maxX = Math.max(Math.max(maxX, l.origin.x),l.destination.x);
			maxY = Math.max(Math.max(maxY, l.origin.y),l.destination.y);
			maxZ = Math.max(Math.max(maxZ, l.origin.z),l.destination.z);
			minX = Math.min(Math.min(minX, l.origin.x),l.destination.x);
			minY = Math.min(Math.min(minY, l.origin.y),l.destination.y);
			minZ = Math.min(Math.min(minZ, l.origin.z),l.destination.z);	
		}
		double val = length/(maxX-minX)*(maxY-minY)*(maxZ-minZ);
		if (Double.isNaN(val) || Double.isInfinite(val)){
			return 0.0;
		}
		else{
			return val;
		}
	}

}
