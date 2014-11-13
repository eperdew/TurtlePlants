package RuleMutations;

import LSystem.Alphabet;
import LSystem.Rule;
import Mutation.RuleMutation;

public class AddOutput extends RuleMutation {

	@Override
	public Rule mutate(Rule r, Alphabet alpha) {
		r = r.copy();
		int cut = (int)(Math.random() * r.output.length());
		r.output = r.output.substring(0,cut) + alpha.randomString() + r.output.substring(cut);
		return r;
	}

}