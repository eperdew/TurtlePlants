package Mutation;

import java.util.ArrayList;
import java.util.List;

import LSystem.Alphabet;
import LSystem.Rule;

public class RuleMutator {
	
	List<MutProb> mutations;
	Alphabet alphabet;
	
	public RuleMutator(List<RuleMutation> muts, double[] probabilities, Alphabet alphabet){
		this.alphabet = alphabet;
		if (muts.size() != probabilities.length){
			throw new RuntimeException("Error: Number of mutations must equal number of probabilities.");
		}
		mutations = new ArrayList<MutProb>();
		for (int i = 0; i < muts.size(); i++){
			mutations.add(new MutProb(muts.get(i),probabilities[i]));
		}
	}
	
	
	/** Returns a mutated version of r. Does not affect r. */
	public Rule mutate(Rule r){
		for (MutProb mp: mutations){
			while (Math.random() < mp.prob){
				r = mp.mut.mutate(r,alphabet);
			}
		}
		return r;
	}
	
	
	
	private static class MutProb {
		RuleMutation mut;
		double prob;
		
		MutProb(RuleMutation mut, double prob){
			this.mut = mut;
			this.prob = prob;
		}
	}
	
}