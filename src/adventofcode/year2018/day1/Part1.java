package adventofcode.year2018.day1;

public class Part1 {

	public static void main(String[] args) {
		Integer resultingFrequency = 0;
		
		for (int i = 0; i < args.length; i++) {
			System.out.print("Current Frequency " + resultingFrequency + ", ");
			System.out.print("change of " + args[i] + "; ");
			resultingFrequency+= Integer.parseInt(args[i]);
			System.out.print("resulting freuency " + resultingFrequency);
			System.out.println();
		}
		System.out.println("resulting frequency " + resultingFrequency.toString());
	}

}
