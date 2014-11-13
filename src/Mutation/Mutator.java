package Mutation;

import java.util.ArrayList;
import java.util.List;

import LSystem.LSystem;

public class Mutator {
	
	List<MutProb> mutations;
	
	public Mutator(List<Mutation> muts, double[] probabilities){
		if (muts.size() != probabilities.length){
			throw new RuntimeException("Error: Number of mutations must equal number of probabilities.");
		}
		mutations = new ArrayList<MutProb>();
		for (int i = 0; i < muts.size(); i++){
			mutations.add(new MutProb(muts.get(i),probabilities[i]));
		}
	}
	
	
	/** Returns a mutated version of ls. Does not affect ls. */
	public LSystem mutate(LSystem ls){
		for (MutProb mp: mutations){
			while (Math.random() < mp.prob){
				ls = mp.mut.mutate(ls);
			}
		}
		return ls;
	}
	
	
	
	private static class MutProb {
		Mutation mut;
		double prob;
		
		MutProb(Mutation mut, double prob){
			this.mut = mut;
			this.prob = prob;
		}
	}
	
}
