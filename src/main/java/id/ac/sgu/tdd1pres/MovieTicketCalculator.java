package id.ac.sgu.tdd1pres;

public class MovieTicketCalculator {

	public int calculate(int age, int time) throws AdultException {

		int price;

		if (isAdult(age)) {

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

	private boolean isEvening(int time) {
		return time > 1700;
	}

	private boolean isAdult(int age) {
		return age > 13;
	}

}
