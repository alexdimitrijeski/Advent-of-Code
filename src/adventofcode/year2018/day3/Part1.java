package adventofcode.year2018.day3;

import java.util.ArrayList;
import java.util.HashMap;

public class Part1 {

	public static void main(String[] args) {
		HashMap<String,Square> squares = new HashMap<String,Square>();
		ArrayList<Claim> claims = new ArrayList<Claim>();
		
		Part1 part1 = new Part1();
		
		for (int i = 0; i < args.length; i+=4) {
			Integer claimNumber = new Integer(args[i].replace("#", ""));
			Integer fromLeft = new Integer(args[i+2].split(",")[0]);
			Integer fromTop = new Integer(args[i+2].split(",")[1].replace(":", ""));
			int width = Integer.parseInt(args[i+3].split("x")[0]);
			int height = Integer.parseInt(args[i+3].split("x")[1]);
			
			claims.add(part1.new Claim(claimNumber, fromTop, fromLeft, width, height));
		}
		
		for(int i = 0; i<claims.size(); i++){
			Claim claim = claims.get(i);
			for(int j = 0; j<claim.getWidth(); j++){
				for(int k = 0; k<claim.getHeight(); k++){
					
					int squareLeft = claim.getFromLeft()+j;
					int squareTop = claim.getFromTop()+k;
					
					Square square = squares.get((squareLeft)+","+(squareTop));
					
					if(square==null){
						System.out.println("New Claim: " + claim.claimNumber + " to Square:" + squareTop +"," + squareLeft);
						square = part1.new Square(claim.claimNumber);
						squares.put((squareLeft)+","+(squareTop), square);
					} else {
						System.out.println("Add Claim: " + claim.claimNumber + " to Square:" + squareTop +"," + squareLeft);
						square.addClaimNumber(claim.claimNumber);
						squares.replace((squareLeft)+","+(squareTop), square);
					}
				}
			}
		}
		
		int multipleClaimsPerSquareCount = 0;
		for(Square square:squares.values()){
			if(square.getClaimNumbers()!=null && square.getClaimNumbers().size()>1){
				multipleClaimsPerSquareCount++;
			}
		}
		
		System.out.println("Square Count :" + multipleClaimsPerSquareCount);

	}
	
	public class Claim {
		
		private Integer claimNumber;
		private Integer fromTop;
		private Integer fromLeft;
		private Integer width;
		private Integer height;
		
		public Claim(Integer claimNumber, Integer fromTop, Integer fromLeft, Integer width, Integer height) {
			super();
			this.claimNumber = claimNumber;
			this.fromTop = fromTop;
			this.fromLeft = fromLeft;
			this.width = width;
			this.height = height;
		}
		
		protected Integer getClaimNumber() {
			return claimNumber;
		}
		protected void setClaimNumber(Integer claimNumber) {
			this.claimNumber = claimNumber;
		}
		protected Integer getFromTop() {
			return fromTop;
		}
		protected void setFromTop(Integer fromTop) {
			this.fromTop = fromTop;
		}
		protected Integer getFromLeft() {
			return fromLeft;
		}
		protected void setFromLeft(Integer fromLeft) {
			this.fromLeft = fromLeft;
		}
		protected Integer getWidth() {
			return width;
		}
		protected void setWidth(Integer width) {
			this.width = width;
		}
		protected Integer getHeight() {
			return height;
		}
		protected void setHeight(Integer height) {
			this.height = height;
		}
	}
	
	private class Square {
		
		private ArrayList<Integer> claimNumbers = new ArrayList<Integer>();
		
		protected Square(Integer claim){
			super();
			this.addClaimNumber(claim);
		}
		
		protected ArrayList<Integer> getClaimNumbers() {
			return claimNumbers;
		}
		
		protected void addClaimNumber(Integer claimNumber) {
			claimNumbers.add(claimNumber);
		}
		
	}

}