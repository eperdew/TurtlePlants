package TurtleInstructions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InstructionMap {

	HashMap<String,Instruction> interpretation;
	
	public InstructionMap(HashMap<String,Instruction> interpretation){
		this.interpretation = interpretation;
	}
	
	public InstructionSet fromString(String read){
		List<String> keys = new ArrayList<String>(interpretation.keySet());
		List<Instruction> instrs = fromStringHelper(read, new ArrayList<Instruction>(), keys);
		return new InstructionSet(instrs);
	}
	
	private List<Instruction> fromStringHelper(String read, List<Instruction> result, List<String> keys){
		for(String s: keys){
			if (read.startsWith(s)){
				result.add(interpretation.get(s));
				return fromStringHelper(read.substring(s.length()),result,keys);
			}
		}
		return result;
	}
	
}
