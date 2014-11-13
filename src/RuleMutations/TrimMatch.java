package RuleMutations;

import LSystem.Alphabet;
import LSystem.Rule;
import Mutation.RuleMutation;

public class TrimMatch extends RuleMutation {

	@Override
	public Rule mutate(Rule r, Alphabet alpha) {
		r = r.copy();
		if (r.match.length() <= 1){
			return r;
		}
		int cut = (int)(Math.random() * r.match.length());
		r.match = r.match.substring(0,cut) + r.match.substring(cut);
		return r;
	}

}