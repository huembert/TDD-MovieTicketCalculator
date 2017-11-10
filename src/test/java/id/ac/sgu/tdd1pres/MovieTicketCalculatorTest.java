package id.ac.sgu.tdd1pres;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/*
 * Write a program that determines the price of a movie ticket. The program asks for the 
 * customer's age and for the time on a 24-hour clock (where noon is 1200 and 4:30PM is 1630). 
 *
 * The normal adult ticket price is $8.00, however the adult matinee price is $5.00. 
 * Adults are those over 13 years. The normal children children's ticket price is $4.00, 
 * however the children's matinee price is $2.00. Assume that a 
 * matinee starts at any time earlier than 5pm (1700). Get the information from the 
 * user and then use nested if statements to determine the ticket price. 
 *
 * It is usually a good idea to separate the "information gathering phase" 
 * (asking the user for age and time) from the "processing phase" of a program 
 * (deciding on the ticket price). There are many ways in which the 
 * if statements can be nested. Sketch out a flowchart as you design your program.
 */
@RunWith(Parameterized.class)
public class MovieTicketCalculatorTest {

	@Parameters(name = "age {0} time {1} exp. price {2}, exp. exception {3}")
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				// age, time, expected price, expect exception
				{ 18, 1800, 8, false }, 
				{ 18, 1600, 5, false }, 
				{ 13, 1800, 4, false }, 
				{ 13, 1600, 2, false },
				
				// cases for testing the adult check
				{ 21, 2300, 8, false },
				{ 13, 2300, 4, true },
			});
	}

	private MovieTicketCalculator calc;
	private int age;
	private int time;
	private int expected;
	private boolean hasException;

	@Before
	public void setUp() throws Exception {
		calc = new MovieTicketCalculator();
	}

	public MovieTicketCalculatorTest(int age, int time, int expected, boolean hasException) {
		this.age = age;
		this.time = time;
		this.expected = expected;
		this.hasException = hasException;
	}

	@Test
	public void testPrice() {

		int price;
		try {
			price = calc.calculate(age, time);
			assertEquals(expected, price);
			assertFalse(hasException);
		} catch (AdultException e) {
			System.out.println("AdultException happend");
			assertTrue(hasException);
		}

	}

}