package adventofcode.year2018.day6;

import java.util.ArrayList;
import java.util.Scanner;

public class Part2 {


	public static void main(String[] args) {
		
		Part2 part1 = new Part2();

		Scanner scanner = new Scanner(part1.getClass().getResourceAsStream(args[0]));
		int MAX_DISTANCE = Integer.parseInt(args[1]);

		ArrayList<Location> locationsArray = new ArrayList<Location>();
		ArrayList<Coordinate> coordinatesArray = new ArrayList<Coordinate>();

		while (scanner.hasNext()) {
			String line = scanner.nextLine();
			Location location = part1.new Location(Integer.parseInt(line.split(",")[0].trim()),
					Integer.parseInt(line.split(",")[1].trim()), line);
			locationsArray.add(location);
		}

		scanner.close();

		// Begin calculating coordinates on edge so we can remove those later,
		// and also get a working area

		int furthestLeft = Integer.MAX_VALUE;
		int furthestTop = Integer.MAX_VALUE;
		int furthestRight = 0;
		int furthestBottom = 0;

		for (Location location : locationsArray) {

			if (location.getFromLeft() < furthestLeft) {
				furthestLeft = location.getFromLeft();
			}
			if (location.getFromTop() < furthestTop) {
				furthestTop = location.getFromTop();
			}
			if (location.getFromLeft() > furthestRight) {
				furthestRight = location.getFromLeft();
			}
			if (location.getFromTop() > furthestBottom) {
				furthestBottom = location.getFromTop();
			}
		}

		for (int i = furthestLeft; i <= furthestRight; i++) {
			for (int j = furthestTop; j <= furthestBottom; j++) {
				coordinatesArray.add(part1.new Coordinate(i, j));
			}
		}

		for (Coordinate coordinate : coordinatesArray) {
			System.out.print(coordinate.getFromLeft() + ", " + coordinate.getFromTop() + ": " );
			for (Location location : locationsArray) {
				int distance = Math.abs(coordinate.getFromLeft() - location.getFromLeft())
						+ Math.abs(coordinate.getFromTop() - location.getFromTop());
				coordinate.addTotalDistance(distance);
				System.out.print(" " + distance);
			}
			System.out.println();
		}

		ArrayList<Coordinate> coordinatesToCount = new ArrayList<Coordinate>();

		for (Coordinate coordinate : coordinatesArray) {
			System.out.println(coordinate.getFromLeft() + ", " + coordinate.getFromTop() + ": " + coordinate.getTotalDistance());
			if (coordinate.getTotalDistance()<MAX_DISTANCE) {
				coordinatesToCount.add(coordinate);
			}
		}

		System.out.println("Area Size: " + coordinatesToCount.size());

	}

	private class Location {

		private Integer fromLeft;
		private Integer fromTop;
		private String locationId;

		protected Location(Integer fromLeft, Integer fromTop, String locationId) {
			super();
			this.setFromLeft(fromLeft);
			this.setFromTop(fromTop);
			this.setLocationId(locationId);
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

		protected String getLocationId() {
			return locationId;
		}

		protected void setLocationId(String locationId) {
			this.locationId = locationId;
		}
	}

	private class Coordinate {

		private Integer fromTop;
		private Integer fromLeft;
		private Integer totalDistance;

		protected Coordinate(Integer fromLeft, Integer fromTop) {
			super();
			this.setFromLeft(fromLeft);
			this.setFromTop(fromTop);
			this.setTotalDistance(0);
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

		protected Integer getTotalDistance() {
			return totalDistance;
		}

		protected void setTotalDistance(Integer totalDistance) {
			this.totalDistance = totalDistance;
		}

		protected void addTotalDistance(Integer distanceToAdd) {
			totalDistance += distanceToAdd;
		}

	}

}
