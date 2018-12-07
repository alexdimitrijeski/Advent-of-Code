package adventofcode.year2018.day4;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import adventofcode.year2018.day4.Part1.Guard;

public class Part1_1 {

	/**
	 * @param String[]
	 *            args - First argument is text file of input
	 */
	public static void main(String[] args) {

		TreeMap<LocalDateTime, String> fileLines = new TreeMap<LocalDateTime, String>();

		Scanner scanner = new Scanner(Part1_1.class.getResourceAsStream(args[0]));

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

		Part1_1 part1 = new Part1_1();

		HashMap<String, Guard> guardsMap = new HashMap<String, Guard>();

		Guard workingGuard = null;
		LocalDateTime startTime = LocalDateTime.now();
		LocalDateTime endTime = LocalDateTime.now();

		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String ldtString = line.substring(line.indexOf("[") + 1, line.indexOf("]"));
			String dataString = line.substring(line.indexOf("]") + 2);

			LocalDateTime stringTime = LocalDateTime.parse(ldtString, dtf);
			fileLines.put(stringTime, dataString);
		}

		Set<LocalDateTime> ts = fileLines.keySet();

		for (LocalDateTime localDateTime : ts) {

		}

		scanner.close();
	}

	public class Guard {

		private String guardId;
		private long minutes = 0;
		private long maxSleepMinutesTotal = 0;
		private long maxSleepMinute = 0;

		public String getGuardId() {
			return guardId;
		}

		public void setGuardId(String guardId) {
			this.guardId = guardId;
		}

		public long getMinutes() {
			return minutes;
		}

		public void addMinutes(long minutes) {
			this.minutes += minutes;
		}

		public long getMaxSleepMinutesTotal() {
			return maxSleepMinutesTotal;
		}

		public void setMaxSleepMinutesTotal(long maxSleepMinutesTotal) {
			this.maxSleepMinutesTotal = maxSleepMinutesTotal;
		}

		public long getMaxSleepMinute() {
			return maxSleepMinute;
		}

		public void setMaxSleepMinute(long maxSleepMinute) {
			this.maxSleepMinute = maxSleepMinute;
		}
	}

}
