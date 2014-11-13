package LSystem;

import java.util.List;

import TurtleInstructions.GeoTurtle;
import TurtleInstructions.GeoTurtleStack;
import TurtleInstructions.Instruction;
import TurtleInstructions.InstructionMap;
import TurtleInstructions.InstructionSet;
import TurtleInstructions.Line3D;

public class Expresser {

	public int iterations;
	public InstructionMap imap;
	
	public Expresser(int iterations, InstructionMap imap){
		this.iterations = iterations;
		this.imap = imap;
	}
	
	
	public List<Line3D> phenotypeOf(LSystem ls){
		ls.current = ls.start;
		for (int i = 0; i < iterations; i++){
			ls.step();
		}
		InstructionSet iset = imap.fromString(ls.current);
		GeoTurtleStack gts = new GeoTurtleStack(new GeoTurtle());
		iset.enactOn(gts);
		return gts.getLines();
	}
	
	
	
}
