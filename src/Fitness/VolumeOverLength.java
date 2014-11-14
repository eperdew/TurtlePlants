package Fitness;

import java.util.ArrayList;
import java.util.List;

import quickhull3d.QuickHull3D;
import TurtleInstructions.Line3D;

public class VolumeOverLength extends Evaluator {

	@Override
	public double evaluate(List<Line3D> lines) {
		try {
			double length = 0;
			QuickHull3D hull = new QuickHull3D();
			ArrayList<quickhull3d.Point3d> points = new ArrayList<quickhull3d.Point3d>();
			for (Line3D l : lines) {
				length += l.magnitude();
				points.add(convert(l.origin));
				points.add(convert(l.destination));
			}
			hull.build(points.toArray(new quickhull3d.Point3d[points.size()]));
			return hull.getNumFaces()/length;
		} catch (Exception e) {
			return -1;
		}
	}

	private static quickhull3d.Point3d convert(javax.vecmath.Point3d p){
		return new quickhull3d.Point3d(p.x, p.y, p.z);
	}
}
