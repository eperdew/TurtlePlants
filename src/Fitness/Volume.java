package Fitness;

import java.util.List;

import TurtleInstructions.Line3D;

public class Volume extends Evaluator {

	@Override
	public double evaluate(List<Line3D> lines) {
		double maxX = Double.NEGATIVE_INFINITY;
		double maxY = Double.NEGATIVE_INFINITY;
		double maxZ = Double.NEGATIVE_INFINITY;
		double minX = Double.POSITIVE_INFINITY;
		double minY = Double.POSITIVE_INFINITY;
		double minZ = Double.POSITIVE_INFINITY;
		for (Line3D l: lines){
			maxX = Math.max(Math.max(maxX, l.origin.x),l.destination.x);
			maxY = Math.max(Math.max(maxY, l.origin.y),l.destination.y);
			maxZ = Math.max(Math.max(maxZ, l.origin.z),l.destination.z);
			minX = Math.min(Math.min(minX, l.origin.x),l.destination.x);
			minY = Math.min(Math.min(minY, l.origin.y),l.destination.y);
			minZ = Math.min(Math.min(minZ, l.origin.z),l.destination.z);	
		}
		return (maxX-minX)*(maxY-minY)*(maxZ-minZ);
	}

}
