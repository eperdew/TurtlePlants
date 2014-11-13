package Mutation;

import LSystem.Alphabet;
import LSystem.Rule;

public abstract class RuleMutation {

	public abstract Rule mutate(Rule r, Alphabet alpha);

}
