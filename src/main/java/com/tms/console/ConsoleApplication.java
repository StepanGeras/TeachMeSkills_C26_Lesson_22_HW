package com.tms.console;


import com.tms.Application;
import com.tms.model.Operation;
import com.tms.service.OperationService;

public class ConsoleApplication implements Application {

	private final OperationService operationService = new OperationService();
	private final ConsoleReader consoleReader = new ConsoleReader();
	private final ConsoleWriter consoleWriter = new ConsoleWriter();

	public void run() {

		while (true) {

			consoleWriter.write("Enter num 1");
			double num1 = consoleReader.readNum();
			consoleWriter.write("Enter num 2");
			double num2 = consoleReader.readNum();
			consoleWriter.write("Enter operation");
			String type = consoleReader.readOperationType();
			Operation operation = new Operation(num1, num2, type);
			Operation calculate = operationService.calculate(operation);
			consoleWriter.write("Result = " + calculate.getResult());
			consoleWriter.write("Would you like to continue? " + "(Y or N)");

			while (true) {

				String endOperation = consoleReader.readEndOperation();

				if (endOperation.equalsIgnoreCase("n")) {
					return;
				} else if (endOperation.equalsIgnoreCase("y")) {
					break;
				} else {
					consoleWriter.write("Invalid input");
				}

			}

		}

	}
}
