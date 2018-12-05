package adventofcode.year2018.day1;

import java.util.ArrayList;

public class Part2 {

	public static void main(String[] args) {
		Integer resultingFrequency = 0;
		ArrayList<Integer> frequenciesArray = new ArrayList<Integer>();
		frequenciesArray.add(resultingFrequency);
		
		for (int i = 0; i < args.length; i++) {
			System.out.print("Current Frequency " + resultingFrequency + ", ");
			System.out.print("change of " + args[i] + "; ");
			resultingFrequency+= Integer.parseInt(args[i]);
			System.out.print("resulting freuency " + resultingFrequency);
			System.out.println();
			
			if(i==args.length-1){
				i=-1;
			}
			if(frequenciesArray.contains(resultingFrequency)){
				break;
			} else {
				frequenciesArray.add(resultingFrequency);
			}
		}
		System.out.println("repeated frequency " + resultingFrequency.toString());
	}

}
