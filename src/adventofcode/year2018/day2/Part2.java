package adventofcode.year2018.day2;

public class Part2 {

	public static void main(String[] args) {
		
		String box1 = "";
		String box2 = "";
		
		for (int i = 0; i < args.length; i++) {
			for (int j = 0; j < args.length; j++) {
				if(args[i].length()!=args[j].length()){
					break;
				}
				int offCount = 0;
				for(int k = 0; k<args[i].length(); k++){
					if(args[i].charAt(k)!= args[j].charAt(k)){
						offCount++;
					}
				}
				if(offCount==1){
					box1 = args[i];
					box2 = args[j];
				}
			}
		}

		System.out.println(box1);
		System.out.println(box2);

		StringBuilder matchingLetters = new StringBuilder("");
		
		for(int i = 0; i<box1.length(); i++){
			if(box1.charAt(i)==box2.charAt(i)){
				matchingLetters.append(box1.charAt(i));
			}
		}
		
		System.out.println(matchingLetters);
	}
	

}
