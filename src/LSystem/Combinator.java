package LSystem;

import Crossover.Crossover;
import Mutation.Mutator;

public class Combinator {
	public Mutator mutator;
	
	public Combinator(Mutator mutator){
		this.mutator = mutator;
	}
	
	public LSystem childOf(LSystem p1, LSystem p2){
		LSystem result = Crossover.crossover(p1,p2);
		mutator.mutate(result);
		return result;
	}
	
}
