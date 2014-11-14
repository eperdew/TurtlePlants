package Fitness;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.vecmath.Point3d;

import TurtleInstructions.Line3D;

import java.util.HashSet;

public class DistFromCenter extends Evaluator {

	@Override
	public double evaluate(List<Line3D> lines) {
		if (lines.size() == 0) {
			return -1.0;
		}
		double length = 0;
		Point3d center = new Point3d(0, 0, 0);
		for (Line3D l : lines) {
			center.add(l.origin);
			center.add(l.destination);
			length += l.magnitude();
		}
		center.scale(.5 / lines.size());
		double totalDist = 0;
		for (Line3D l : lines) {
			totalDist += manhattanDistance(l.origin,center);
			totalDist += manhattanDistance(l.destination,center);
		}
		totalDist = totalDist / lines.size();
		return length / (totalDist);
	}

	public static double manhattanDistance(Point3d l1, Point3d l2) {
		return Math.abs(l1.x - l2.x) + Math.abs(l1.y - l2.y)
				+ Math.abs(l1.z - l2.z);
	}

}
