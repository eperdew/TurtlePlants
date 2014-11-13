package LSystem;

import java.util.List;
import java.util.ArrayList;

public class LSystem {
	public List<Rule> rules;
	public Alphabet alpha;
	public String current;
	public String start;

	public static final int MIN_STARTING_STRING_LENGTH = 1;
	public static final int MAX_STARTING_STRING_LENGTH = 4;

	public static final int MIN_NUM_RULES = 1;
	public static final int MAX_NUM_RULES = 2;

	public LSystem() {
		rules = new ArrayList<Rule>();
		alpha = new Alphabet("");
		start = "";
	}

	public LSystem(Alphabet alpha, String start, List<Rule> rules) {
		this.alpha = alpha;
		this.start = start;
		current = start;
		this.rules = rules;
		
	}

	public void step() {
		current = buildNext(current);
	}

	private String buildNext(String s) {
		if (s.isEmpty()) {
			return s;
		} else {
			for (Rule r : rules) {
				if (r.match.length() <= s.length()) {
					String appliedTo = s.substring(0, r.match.length());
					String applied = r.applyTo(appliedTo);
					if (!applied.equals(appliedTo)) {
						return applied
								+ buildNext(s.substring(r.match.length()));
					}
				}
			}
		}
		return s.substring(0, 1) + buildNext(s.substring(1));
	}

	public LSystem copy() {
		List<Rule> copyRules = new ArrayList<Rule>();
		for (Rule r : rules) {
			copyRules.add(r.copy());
		}
		return new LSystem(alpha.copy(), start, copyRules);
	}

	public static LSystem randomLSystem(Alphabet alpha) {
		String start = randomString(alpha);
		ArrayList<Rule> rules = new ArrayList<Rule>();
		int numRules = (int) (Math.random() * (MAX_NUM_RULES - MIN_NUM_RULES + 1))
				+ MIN_NUM_RULES;
		for (int i = 0; i < numRules; i++){
			rules.add(new Rule(randomString(alpha,1),randomString(alpha,2)));
		}
		return new LSystem(alpha,start,rules);
	}

	private static String randomString(Alphabet alpha) {
		int numChars = (int) (Math.random() * (MAX_STARTING_STRING_LENGTH
				- MIN_STARTING_STRING_LENGTH + 1))
				+ MIN_STARTING_STRING_LENGTH;
		String result = "";
		for (int i = 0; i < numChars; i++) {
			result += alpha.randomString();
		}
		return result;
	}
	
	private static String randomString(Alphabet alpha, int size) {
		String result = "";
		for (int i = 0; i < size; i++) {
			result += alpha.randomString();
		}
		return result;
	}
	
	
	//The closer to zero, the more similar
	public static int similarityBetween(LSystem ls1, LSystem ls2, int n){
		ls1.current = ls1.start;
		ls2.current = ls2.start;
		for (int i = 0; i < n; i++){
			ls1.step();
			ls2.step();
		}
		return Utilities.StringUtilities.minDistance(ls1.current,ls2.current);
	}
	
	@Override
	public String toString(){
		String result = "Start: " + start + "\n";
		for (Rule r: rules){
			result += r.toString() + "\n";
		}
		return result;
	}

}
