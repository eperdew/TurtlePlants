package TurtleInstructions;

public class Sample {
	private static Frame frame = new Frame(600, 600, "3D Turtle Graphics");

	public static void main(String args[]){
		//this is sample.
		//Turtle(sleeptime, frame).
		foo( new Turtle(0, frame), 5 );
	}

	//draw passeri
	private static void foo(Turtle t, double arg){
		if (arg < 0.01) return;

		for(int i=0; i<3; i++){
			t.down(30);
			t.fd(arg);
			foo( t, arg/2 );
			t.bk(arg);
			t.up(30);
			t.twist(120);
		}
	}
	
	private static void boo(Turtle t, int iter){
		if (iter <= 0) return;

		
	}
}
