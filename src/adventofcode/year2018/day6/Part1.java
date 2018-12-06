package adventofcode.year2018.day6;

import java.util.ArrayList;
import java.util.Scanner;

public class Part1 {

	public static void main(String[] args) {
		Part1 part1 = new Part1();

		Scanner scanner = new Scanner(part1.getClass().getResourceAsStream(args[0]));

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
			for (Location location : locationsArray) {
				int distance = Math.abs(coordinate.getFromLeft() - location.getFromLeft())
						+ Math.abs(coordinate.getFromTop() - location.getFromTop());
				if (distance == coordinate.getSmallestDistance()) {
					coordinate.setClosestLocation(".");
				} else if (distance < coordinate.getSmallestDistance()) {
					coordinate.setClosestLocation(location.getLocationId());
					coordinate.setSmallestDistance(distance);
				}
			}
		}

		ArrayList<Location> locationsToRemoveArray = new ArrayList<Location>();
		for (Location location : locationsArray) {
			if (location.getFromLeft() == furthestLeft) {
				locationsToRemoveArray.add(location);
			}
			if (location.getFromTop() == furthestTop) {
				locationsToRemoveArray.add(location);
			}
			if (location.getFromLeft() == furthestRight) {
				locationsToRemoveArray.add(location);
			}
			if (location.getFromTop() == furthestBottom) {
				locationsToRemoveArray.add(location);
			}
		}

		locationsArray.removeAll(locationsToRemoveArray);

		int largestArea = 0;

		for (Location location : locationsArray) {
			int areaSize = 0;
			for (Coordinate coordinate : coordinatesArray) {
				if (coordinate.getClosestLocation().equals(location.getLocationId())) {
					areaSize++;
				}
			}
			if (areaSize > largestArea) {
				largestArea = areaSize;
			}
		}

		System.out.println("Largest Area: " + largestArea);

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
		private String closestLocation = ".";
		private Integer smallestDistance = Integer.MAX_VALUE;

		protected Coordinate(Integer fromLeft, Integer fromTop) {
			super();
			this.setFromLeft(fromLeft);
			this.setFromTop(fromTop);
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

		protected String getClosestLocation() {
			return closestLocation;
		}

		protected void setClosestLocation(String closestLocation) {
			this.closestLocation = closestLocation;
		}

		protected Integer getSmallestDistance() {
			return smallestDistance;
		}

		protected void setSmallestDistance(Integer smallestDistance) {
			this.smallestDistance = smallestDistance;
		}

	}

}
