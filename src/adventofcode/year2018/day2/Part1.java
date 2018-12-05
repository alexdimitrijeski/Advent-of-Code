package adventofcode.year2018.day2;

import java.util.ArrayList;

public class Part1 {

	public static void main(String[] args) {

		int twoCount = 0;
		int threeCount = 0;
		ArrayList<String> letters = new ArrayList<String>();
		letters.add("a");
		letters.add("b");
		letters.add("c");
		letters.add("d");
		letters.add("e");
		letters.add("f");
		letters.add("g");
		letters.add("h");
		letters.add("i");
		letters.add("j");
		letters.add("k");
		letters.add("l");
		letters.add("m");
		letters.add("n");
		letters.add("o");
		letters.add("p");
		letters.add("q");
		letters.add("r");
		letters.add("s");
		letters.add("t");
		letters.add("u");
		letters.add("v");
		letters.add("w");
		letters.add("x");
		letters.add("y");
		letters.add("z");

		for (int i = 0; i < args.length; i++) {

			
			System.out.println(args[i]);

			for (int j = 0; j < letters.size(); j++) {
				int letterCount = 0;
				System.out.println(letters.get(j));
				for (int k = 0; k < ((String) args[i]).length(); k++) {
					String stringToCount = args[i];

					System.out.println(stringToCount.charAt(k) + "," + letters.get(j).charAt(0));

					if (stringToCount.charAt(k) == letters.get(j).charAt(0)) {
						letterCount++;
					}

				}
				if (letterCount == 2) {
					twoCount++;

					System.out.println("twoCount++ = " + twoCount);
					break;
				}
			}

		}

		for (int i = 0; i < args.length; i++) {

	

			System.out.println(args[i]);

			for (int j = 0; j < letters.size(); j++) {
				int letterCount = 0;
				for (int k = 0; k < ((String) args[i]).length(); k++) {
					String stringToCount = args[i];
					if (stringToCount.charAt(k) == letters.get(j).charAt(0)) {
						letterCount++;
					}
				}
				if (letterCount == 3) {
					threeCount++;
					break;
				}
			}

		}

		System.out.println(twoCount);
		System.out.println(threeCount);
		System.out.println(twoCount * threeCount);
	}

}
