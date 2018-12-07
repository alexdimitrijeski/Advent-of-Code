package adventofcode.year2018.day7;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Part1 {

	ArrayList<String> instructionsArrayRaw = new ArrayList<String>();
	ArrayList<Instruction> instructionsArray = new ArrayList<Instruction>();
	TreeMap<String, Step> stepMap = new TreeMap<String, Step>();

	public static void main(String[] args) {
		Part1 part1 = new Part1();
		part1.run(args);
	}

	private void run(String[] args) {
		loadFile(args[0]);
		refineInstruction();
		createSteps();
		processSteps();
	}

	private void loadFile(String fileName) {
		Scanner scanner = new Scanner(getClass().getResourceAsStream(fileName));

		while (scanner.hasNext()) {
			String line = scanner.nextLine();
			instructionsArrayRaw.add(line);
		}

		scanner.close();
	}

	private void refineInstruction() {
		for (String instruction : instructionsArrayRaw) {
			instruction = instruction.replace("Step ", "");
			instruction = instruction.replace(" must be finished before step ", "");
			instruction = instruction.replace(" can begin.", "");

			String first = String.valueOf(instruction.charAt(0));
			String second = String.valueOf(instruction.charAt(1));
			instructionsArray.add(this.new Instruction(first, second));
		}

	}

	private void createSteps() {
		for (Instruction instruction : instructionsArray) {
			if (!stepMap.containsKey(instruction.getFirst())) {
				Step step1 = new Step(instruction.getFirst());
				stepMap.put(instruction.getFirst(), step1);
			}
			if (!stepMap.containsKey(instruction.getSecond())) {
				Step step2 = new Step(instruction.getSecond());
				step2.addPriorStep(instruction.getFirst());
				stepMap.put(instruction.getSecond(), step2);
			} else {
				Step step2 = stepMap.get(instruction.getSecond());
				step2.addPriorStep(instruction.getFirst());
				stepMap.put(instruction.getSecond(), step2);
			}
		}

		for (Instruction instruction : instructionsArray) {
			System.out.println(instruction.getFirst() + " -> " + instruction.getSecond());
		}
	}

	private void processSteps() {

		StringBuilder stepsInOrder = new StringBuilder();

		while (true) {
			Step step;

			Set<String> keys = stepMap.keySet();

			if (keys.size() == 0)
				break;

			for (String stepName : keys) {
				step = stepMap.get(stepName);

				if (step.getPriorSteps().size() == 0) {
					step.setStatus(Step.STATUS_IS_READY);
					System.out.println("Step :" + step.getStepName() + " is ready");
					break;
				}
			}

			for (String stepName : keys) {
				step = stepMap.get(stepName);

				if (step.getStatus() == Step.STATUS_IS_READY) {
					stepsInOrder = step.processStep(stepsInOrder);
					System.out.println("Step :" + step.getStepName() + " is processed");
					break;
				}
			}

			for (String stepName : keys) {
				step = stepMap.get(stepName);
				if (step.getStatus() == Step.STATUS_IS_WAITING) {
					for (String stepNameInnter : keys) {
						Step stepInner = stepMap.get(stepNameInnter);
						if (stepInner.getStatus() == Step.STATUS_IS_PROCESSED
								&& step.getPriorSteps().contains(stepNameInnter)) {
							step.removePriorStep(stepNameInnter);
						}
					}
				}
			}

			Set<String> toRemove = new HashSet<String>();

			for (String stepName : keys) {
				step = stepMap.get(stepName);
				if (step.getStatus() == Step.STATUS_IS_PROCESSED) {
					toRemove.add(stepName);
				}
			}

			stepMap.keySet().removeAll(toRemove);
		}
		System.out.println("Steps in Order: " + stepsInOrder.toString());

	}

	protected class Instruction {

		private String first;
		private String second;

		protected Instruction(String first, String second) {
			this.first = first;
			this.second = second;
		}

		protected String getFirst() {
			return first;
		}

		protected String getSecond() {
			return second;
		}

	}

	protected class Step {

		private String stepName;
		private ArrayList<String> priorSteps = new ArrayList<String>();
		private int status;

		private static final int STATUS_IS_WAITING = 0;
		private static final int STATUS_IS_READY = 1;
		private static final int STATUS_IS_PROCESSED = 2;

		protected Step(String stepName) {
			this.stepName = stepName;
			this.status = STATUS_IS_WAITING;
		}

		protected String getStepName() {
			return stepName;
		}

		protected ArrayList<String> getPriorSteps() {
			return priorSteps;
		}

		protected void addPriorStep(String priorStep) {
			if (!priorSteps.contains(priorSteps)) {
				priorSteps.add(priorStep);
			}
		}

		protected void removePriorStep(String priorStep) {
			if (priorSteps.contains(priorStep)) {
				priorSteps.remove(priorStep);
			}
		}

		protected int getStatus() {
			return status;
		}

		protected void setStatus(int status) {
			this.status = status;
		}

		protected StringBuilder processStep(StringBuilder stepStringBuilder) {
			this.status = STATUS_IS_PROCESSED;
			stepStringBuilder.append(this.stepName);
			return stepStringBuilder;
		}

	}

}
