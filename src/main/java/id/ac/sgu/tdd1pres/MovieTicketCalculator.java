package id.ac.sgu.tdd1pres;

public class MovieTicketCalculator {

	public int calculate(int age, int time) throws AdultException {

		checkForAdult(age, time);
		
		int price;

		if (!isChild(age)) {

			if (isEvening(time)) {
				price = 8;
			} else {
				price = 5;
			}
			
		} else {

			if (isEvening(time)) {
				price = 4;
			} else {
				price = 2;
			}
		}

		return price;

	}

	private void checkForAdult(int age, int time) throws AdultException {
		if(!isAdult(age) && isNightTime(time)) {
			throw new AdultException();
		}
	}

	private boolean isNightTime(int time) {
		return time > 2200;
	}

	private boolean isAdult(int age) {
		return age >= 18;
	}

	private boolean isEvening(int time) {
		return time > 1700;
	}

	private boolean isChild(int age) {
		return age <= 13;
	}

}
