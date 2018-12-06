package adventofcode.year2018.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Part2 {

	public static void main(String[] args) throws IOException {

		Part2 part2 = new Part2();

		String inputString = part2.getTextFromFile(args[0]);

		int minReactLength = Integer.MAX_VALUE;
		String letterWithMaxReactLength = "";

		ArrayList<String>reactions = populateReactions(new ArrayList<String>());
		ArrayList<String> reactionsShort = populateReactionsShort(new ArrayList<String>());

		for (String reaction : reactionsShort) {
			
			System.out.print("reactionsshort: " + reaction);
			System.out.print(", inputString: " + inputString);
			
			String tempInputString = inputString.replaceAll("["+reaction+"]", "");
			System.out.print(", tempInputString: " + tempInputString);

			int reactLength = react(tempInputString, reactions);
			
			System.out.print (" , length: " + reactLength + "\n");

			if (reactLength < minReactLength) {
				minReactLength = reactLength;
				letterWithMaxReactLength = reaction;
			}
		}

		System.out.println("Letter with shortest react length: " + letterWithMaxReactLength);
		System.out.println("Shortest React Length: " + minReactLength);

	}

	private static int react(String inputString, ArrayList<String> reactions) {
		int loopCount = 0;
		int maxPosition = reactions.size();

		int fullLoops = 0;
		int maxFullLoops = 2;

		while (true) {
			String newString = inputString.replace(reactions.get(loopCount), "");
			if (!newString.equals(inputString)) {
				fullLoops = 0;
				inputString = newString;
			}
			
			loopCount++;
			if (loopCount == maxPosition) {
				loopCount = 0;
				fullLoops++;
			}
			if (fullLoops == maxFullLoops) {
				break;
			}
		}
		return inputString.length();

	}

	private static ArrayList<String> populateReactions(ArrayList<String> reactions) {
		reactions.add("Aa");
		reactions.add("Bb");
		reactions.add("Cc");
		reactions.add("Dd");
		reactions.add("Ee");
		reactions.add("Ff");
		reactions.add("Gg");
		reactions.add("Hh");
		reactions.add("Ii");
		reactions.add("Jj");
		reactions.add("Kk");
		reactions.add("Ll");
		reactions.add("Mm");
		reactions.add("Nn");
		reactions.add("Oo");
		reactions.add("Pp");
		reactions.add("Qq");
		reactions.add("Rr");
		reactions.add("Ss");
		reactions.add("Tt");
		reactions.add("Uu");
		reactions.add("Vv");
		reactions.add("Ww");
		reactions.add("Xx");
		reactions.add("Yy");
		reactions.add("Zz");
		reactions.add("aA");
		reactions.add("bB");
		reactions.add("cC");
		reactions.add("dD");
		reactions.add("eE");
		reactions.add("fF");
		reactions.add("gG");
		reactions.add("hH");
		reactions.add("iI");
		reactions.add("jJ");
		reactions.add("kK");
		reactions.add("lL");
		reactions.add("mM");
		reactions.add("nN");
		reactions.add("oO");
		reactions.add("pP");
		reactions.add("qQ");
		reactions.add("rR");
		reactions.add("sS");
		reactions.add("tT");
		reactions.add("uU");
		reactions.add("vV");
		reactions.add("wW");
		reactions.add("xX");
		reactions.add("yY");
		reactions.add("zZ");
		return reactions;
	}
	
	private static ArrayList<String> populateReactionsShort(ArrayList<String> reactions) {
		reactions.add("Aa");
		reactions.add("Bb");
		reactions.add("Cc");
		reactions.add("Dd");
		reactions.add("Ee");
		reactions.add("Ff");
		reactions.add("Gg");
		reactions.add("Hh");
		reactions.add("Ii");
		reactions.add("Jj");
		reactions.add("Kk");
		reactions.add("Ll");
		reactions.add("Mm");
		reactions.add("Nn");
		reactions.add("Oo");
		reactions.add("Pp");
		reactions.add("Qq");
		reactions.add("Rr");
		reactions.add("Ss");
		reactions.add("Tt");
		reactions.add("Uu");
		reactions.add("Vv");
		reactions.add("Ww");
		reactions.add("Xx");
		reactions.add("Yy");
		reactions.add("Zz");
		return reactions;
	}

	private String getTextFromFile(String filename) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(
				new InputStreamReader(this.getClass().getResourceAsStream(filename), "UTF-8"));
		try {
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				line = br.readLine();
			}
		} finally {
			br.close();
		}
		return sb.toString();
	}
}
