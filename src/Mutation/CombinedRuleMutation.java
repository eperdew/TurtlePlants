package Mutation;

import java.util.ArrayList;
import java.util.List;

import LSystem.LSystem;
import LSystem.Rule;

public class CombinedRuleMutation extends Mutation {

	RuleMutator ruleMutator;
	
	public CombinedRuleMutation(RuleMutator ruleMutator){
		this.ruleMutator = ruleMutator;
	}
	
	@Override
	LSystem mutate(LSystem ls) {
		ls = ls.copy();
		List<Rule> rules = new ArrayList<Rule>();
		for (Rule r: ls.rules){
			rules.add(ruleMutator.mutate(r));
		}
		ls.rules = rules;
		return ls;
	}

}
