package Evolve;

import Fitness.Evaluator;
import LSystem.Expresser;
import LSystem.LSystem;

public class Member implements Comparable<Member> {

	public LSystem ls;
	public double fitness;
	
	public Member(LSystem ls, Expresser exp, Evaluator eval){
		this.ls = ls;
		this.fitness = eval.evaluate(exp.phenotypeOf(ls));
	}

	@Override
	public int compareTo(Member o) {
		return (int)Math.signum(o.fitness - this.fitness);
	}
	
	@Override
	public String toString(){
		return ls.toString() + "\n Fitness: " + fitness;
	}
	
}
