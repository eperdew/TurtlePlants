package Crossover;

import LSystem.LSystem;

public class Crossover {

	public static LSystem crossover(LSystem p1, LSystem p2) {
		LSystem result = p1.copy();
		//Crossover the rules
		for (int i = 0; i < Math.min(p1.rules.size(), p2.rules.size()); i++) {
			if (Math.random() < .5) {
				result.rules.set(i, p2.rules.get(i));
			}
		}
		for (int i = Math.min(p1.rules.size(), p2.rules.size()); i < Math.max(
				p1.rules.size(), p2.rules.size()); i++) {
			if (p1.rules.size() > p2.rules.size()){
				if (Math.random() < .5){
					//Since we started with a copy of p1, we remove rules with 1/2 chance
					result.rules.remove(i);
				}
			}
			else{
				if (Math.random() < .5){
					//Otherwise we add rules from p2 with 1/2 chance
					result.rules.add(p2.rules.get(i));
				}
			}
		}
		//With 1/2 chance, take p2's starting string. Do not combine them
		if (Math.random() < .5){
			result.start = p2.start;
		}
		//Make sure the current is at the start for evaluation later
		result.current = result.start;
		//Take the union of the sets for the new alphabet, though this will rarely be different
		result.alpha.alphabet.addAll(p2.alpha.alphabet);
		return result;
	}

}
