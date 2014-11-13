package TurtleInstructions;

import javax.vecmath.Point3d;

public class Line3D {

	public Point3d origin;
	public Point3d destination;
	
	public Line3D(Point3d origin, Point3d destination){
		this.origin = (Point3d)origin.clone();
		this.destination = (Point3d)destination.clone();
	}
	
	public double magnitude(){
		return (destination.distance(origin)); 
	}
	
}
