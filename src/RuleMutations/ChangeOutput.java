package RuleMutations;

import LSystem.Alphabet;
import LSystem.Rule;
import Mutation.RuleMutation;

public class ChangeOutput extends RuleMutation {

	@Override
	public Rule mutate(Rule r, Alphabet alpha) {
		r = r.copy();
		String toBeMutated = alpha.randomString();
		r.output = r.output.replaceFirst(toBeMutated, alpha.randomString());
		return r;
	}


}