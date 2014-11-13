package TurtleInstructions;
import java.util.ArrayList;
import java.util.List;

import javax.vecmath.*;
import javax.media.j3d.*;

public class GeoTurtle {
	protected Point3d point;
	protected Transform3D angle;
	protected List<Line3D> lines;

	public GeoTurtle(){
		point = new Point3d();
		angle = new Transform3D();
		lines = new ArrayList<Line3D>();
	}

	public void fd(double d){
		Point3d origin = point;

		Vector3d v = new Vector3d(d,0,0);
		angle.transform(v);
		point = new Point3d(
			point.x + v.x,
			point.y + v.y,
			point.z + v.z
		);

		lines.add(new Line3D(origin,point));
	}

	public void bk(double d){
		fd(-d);
	}

	public void left(double arg){
		Transform3D tmp = new Transform3D();
		tmp.rotY( Math.PI * arg / 180 );
		angle.mul(tmp);
	}

	public void right(double arg){
		left(-arg);
	}

	public void up(double arg){
		Transform3D tmp = new Transform3D();
		tmp.rotZ( Math.PI * arg / 180 );
		angle.mul(tmp);
	}

	public void down(double arg){
		up(-arg);
	}

	public void twist(double arg){
		Transform3D tmp = new Transform3D();
		tmp.rotX( Math.PI * arg / 180 );
		angle.mul(tmp);
	}

	public void r_twist(double arg){
		twist(-arg);
	}
	
	public GeoTurtle copy(){
		GeoTurtle clone = new GeoTurtle();
		clone.angle = new Transform3D(angle);
		clone.point = (Point3d) point.clone();
		clone.lines = lines;
		return clone;
	}
}
