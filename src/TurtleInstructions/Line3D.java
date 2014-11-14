package TurtleInstructions;

import javax.vecmath.Point3d;

public class Line3D implements Comparable<Line3D> {

	public static final double EPSILON = 1e-9;

	public Point3d origin;
	public Point3d destination;

	public Line3D(Point3d origin, Point3d destination) {
		this.origin = (Point3d) origin.clone();
		this.destination = (Point3d) destination.clone();
	}

	public double magnitude() {
		return (destination.distance(origin));
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Line3D)) {
			return false;
		} else {
			Line3D other = (Line3D) o;
			return (other.origin.distance(origin) < EPSILON && other.destination
					.distance(destination) < EPSILON);
		}
	}

	@Override
	public int compareTo(Line3D o) {
		double val = destination.distanceSquared(destination);
		return (int) Math.signum(val);
	}

}
