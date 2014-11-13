package LSystem;

public class Rule {

	public String output;
	public String match;
	
	public Rule(String match, String output){
		this.output = output;
		this.match = match;
	}
	
	public String applyTo(String input){
		if (input.equals(match)){
			return output;
		}
		else{
			return input;
		}
	}

	public Rule copy(){
		return new Rule(match,output);
	}
	
	@Override
	public String toString(){
		return match + " -> " + output;
	}
	
}
