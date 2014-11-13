package RuleMutations;

import LSystem.Alphabet;
import LSystem.Rule;
import Mutation.RuleMutation;

public class AddMatch extends RuleMutation {

	@Override
	public Rule mutate(Rule r, Alphabet alpha) {
		r = r.copy();
		int cut = (int)(Math.random() * r.match.length());
		r.match = r.match.substring(0,cut) + alpha.randomString() + r.match.substring(cut);
		return r;
	}

}
