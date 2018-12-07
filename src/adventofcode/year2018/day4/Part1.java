package adventofcode.year2018.day4;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalField;
import java.util.HashMap;

public class Part1 {

	public static void main(String[] args) {

		Part1 part1 = new Part1();

		HashMap<String, Guard> guardsMap = new HashMap<String, Guard>();

		Guard workingGuard = null;
		LocalDateTime startTime = LocalDateTime.now();
		LocalDateTime endTime = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

		for (int i = 0; i < args.length;) {
			String dateString = args[i].substring(1);
			String timeString = args[i + 1].substring(0, 5);

			if (args[i + 2].equals("Guard")) {
				if (workingGuard != null) {
					guardsMap.put(workingGuard.guardId, workingGuard);
				}
				String guardId = args[i + 3];
				if (guardsMap.get(guardId) != null) {
					workingGuard = guardsMap.get(guardId);
				} else {
					workingGuard = part1.new Guard();
					workingGuard.setGuardId(guardId);
				}
				i += 6;
			} else {
				if (args[i + 2].equals("falls")) {

					startTime = LocalDateTime.parse(dateString + " " + timeString, dtf);
				} else {
					endTime = LocalDateTime.parse(dateString + " " + timeString, dtf);
					long minutes = startTime.until(endTime, ChronoUnit.MINUTES);
					workingGuard.addMinutes(minutes);
					System.out.println("minutes = " + minutes);
					System.out.println("guard max minutes = " + workingGuard.getMaxSleepMinutesTotal());
					if (minutes > workingGuard.getMaxSleepMinutesTotal()) {
						workingGuard.setMaxSleepMinutesTotal(minutes);
						System.out.println("start minute = " + startTime.getLong(ChronoField.MINUTE_OF_HOUR));
						workingGuard.setMaxSleepMinute(startTime.getLong(ChronoField.MINUTE_OF_HOUR));
					}
				}

				i += 4;
			}
		}

		long maxMinutes = 0;
		long bestGuardId = 0;
		long bestMinute = 0;

		for (String guardId : guardsMap.keySet()) {
			Guard checkingGuard = guardsMap.get(guardId);
			if (checkingGuard.getMinutes() > maxMinutes) {
				maxMinutes = checkingGuard.getMinutes();
				bestGuardId = Long.valueOf(checkingGuard.getGuardId().substring(1));
				bestMinute = checkingGuard.getMaxSleepMinute();
			}
		}

		System.out.println("Best Guard = " + bestGuardId);
		System.out.println("Best Minute = " + bestMinute);
		System.out.print("Answer = ");
		System.out.print(bestGuardId * bestMinute);
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
