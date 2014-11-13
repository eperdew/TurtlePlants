package Evolve;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Fitness.Evaluator;
import LSystem.Alphabet;
import LSystem.Combinator;
import LSystem.Expresser;
import LSystem.LSystem;

public class Population {

	public final int MU;
	public final int LAMBDA;
	
	public static final boolean DEBUG = true;

	List<Member> members;
	Evaluator eval;
	Combinator combo;
	Expresser express;

	public Member elite;
	double eliteFitness = Double.NEGATIVE_INFINITY;

	public int evaluations = 0;

	public Population(Alphabet alpha, int mu, int lambda, Evaluator eval,
			Combinator combo, Expresser express) {
		this.MU = mu;
		this.LAMBDA = lambda;
		this.eval = eval;
		this.combo = combo;
		this.express = express;
		initializePopulation(alpha, mu);
	}

	private void initializePopulation(Alphabet alpha, int size) {
		members = new ArrayList<Member>();
		for (int i = 0; i < size; i++) {
			LSystem ls = LSystem.randomLSystem(alpha);
			members.add(new Member(ls, express, eval));
			updateElite(members.get(i));
		}
		evaluations += size;
	}

	public void updateElite(Member m) {
		if (m.fitness > eliteFitness) {
			elite = m;
			eliteFitness = m.fitness;
			if (DEBUG){
				System.out.println(elite + "\n______________");
			}
		}
	}

	private Member randomMember() {
		return members.get((int) (Math.random() * MU));
	}

	public void step() {
		for (int i = 0; i < LAMBDA; i++) {
			Member child = new Member(combo.childOf(randomMember().ls,
					randomMember().ls), express, eval);
			members.add(child);
			updateElite(child);
			evaluations += 1;
		}
		Collections.sort(members);
		while (members.size() > MU) {
			members.remove(members.size() - 1);
		}
	}

}
