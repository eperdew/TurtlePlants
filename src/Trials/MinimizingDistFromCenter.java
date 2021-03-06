package Trials;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Evolve.Population;
import Fitness.*;
import LSystem.Alphabet;
import LSystem.Combinator;
import LSystem.Expresser;
import RuleMutations.*;
import TurtleInstructions.Instruction;
import TurtleInstructions.InstructionMap;
import TurtleInstructions.Move;
import Mutation.*;

public class MinimizingDistFromCenter {

	public static final double ADDMATCH_RATE = .03;
	public static final double ADDOUTPUT_RATE = .1;
	public static final double CHANGEMATCH_RATE = .03;
	public static final double CHANGEOUTPUT_RATE = .03;
	public static final double TRIMMATCH_RATE = .03;
	public static final double TRIMOUTPUT_RATE = .03;

	public static final double MUTATOR_RATE = .7;

	public static final int MU = 300;
	public static final int LAMBDA = 300;

	public static final int DEPTH = 8;
	
	public static final int RENDERING_DEPTH = 12;

	public static final int NUM_EVALUATIONS = 5000;

	public static void main(String[] args) {
		/*
		 * W represents forward, Q and E are roll left and right, F and R are
		 * down and up A and D are turn left and right
		 */
		Alphabet alpha = new Alphabet("WQEFRAD");
		Evaluator eval = new DistFromCenter();

		// Add the six standard rule mutations
		ArrayList<RuleMutation> ruleMutations = new ArrayList<RuleMutation>();
		ruleMutations.add(new AddMatch());
		ruleMutations.add(new AddOutput());
		ruleMutations.add(new ChangeMatch());
		ruleMutations.add(new ChangeOutput());
		ruleMutations.add(new TrimMatch());
		ruleMutations.add(new TrimOutput());
		// Choose a set of weights for each mutation
		double[] weights = { ADDMATCH_RATE, ADDOUTPUT_RATE, CHANGEMATCH_RATE,
				CHANGEOUTPUT_RATE, TRIMMATCH_RATE, TRIMOUTPUT_RATE };
		// Create the components for the combinator
		RuleMutator rm = new RuleMutator(ruleMutations, weights, alpha);
		CombinedRuleMutation crm = new CombinedRuleMutation(rm);
		List<Mutation> mutations = new ArrayList<Mutation>();
		mutations.add(crm);
		Mutator mutator = new Mutator(mutations, new double[] { MUTATOR_RATE });
		// Create the combinator
		Combinator combo = new Combinator(mutator);

		double angle = 20;

		HashMap<String, Instruction> interp = new HashMap<String, Instruction>();
		interp.put("W", new Instruction(Move.FORWARD, .5));
		interp.put("Q", new Instruction(Move.ROLL_LEFT, angle));
		interp.put("E", new Instruction(Move.ROLL_RIGHT, angle));
		interp.put("F", new Instruction(Move.TURN_UP, angle));
		interp.put("R", new Instruction(Move.TURN_DOWN, angle)); // for what
		interp.put("A", new Instruction(Move.TURN_LEFT, angle));
		interp.put("D", new Instruction(Move.TURN_RIGHT, angle));
		InstructionMap imap = new InstructionMap(interp);
		Expresser express = new Expresser(DEPTH, imap);

		Population pop = new Population(alpha, MU, LAMBDA, eval, combo, express);

		while (pop.evaluations < NUM_EVALUATIONS) {
			pop.step();
		}
		System.out.println(pop.elite);
		
		pop.elite.ls.current = pop.elite.ls.start;
		for (int i = 0; i < RENDERING_DEPTH; i++){
			pop.elite.ls.step();
		}
		TurtleInstructions.TurtleRenderer.render(express.imap
				.fromString(pop.elite.ls.current));
	}

}
