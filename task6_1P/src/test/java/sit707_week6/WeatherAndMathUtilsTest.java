package sit707_week6;

import org.junit.Assert;
import org.junit.Test;

public class WeatherAndMathUtilsTest {
	
	@Test
	public void testStudentIdentity() {
		String studentId = "s224719679";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Keerthana Vijekumar";
		Assert.assertNotNull("Student name is null", studentName);
	}
	
	@Test
	public void testDangerousWindSpeed() {
	    String result = WeatherAndMathUtils.weatherAdvice(71.0, 2.0);
	    Assert.assertEquals("CANCEL", result);
	}

	@Test
	public void testDangerousRainfall() {
	    String result = WeatherAndMathUtils.weatherAdvice(30.0, 6.1);
	    Assert.assertEquals("CANCEL", result);
	}

	@Test
	public void testDangerousCombinedCondition() {
	    String result = WeatherAndMathUtils.weatherAdvice(50.1, 4.1);
	    Assert.assertEquals("CANCEL", result);
	}

	@Test
	public void testWarningWindSpeedOnly() {
	    String result = WeatherAndMathUtils.weatherAdvice(46.0, 1.0);
	    Assert.assertEquals("WARN", result);
	}

	@Test
	public void testWarningRainfallOnly() {
	    String result = WeatherAndMathUtils.weatherAdvice(10.0, 5.0);
	    Assert.assertEquals("WARN", result);
	}

	@Test
	public void testAllClearCondition() {
	    String result = WeatherAndMathUtils.weatherAdvice(20.0, 2.0);
	    Assert.assertEquals("ALL CLEAR", result);
	}
	
	@Test
	public void testWarnOnlyWindIsHigh() {
	    String result = WeatherAndMathUtils.weatherAdvice(50.0, 3.0);
	    Assert.assertEquals("WARN", result);
	}
	
	@Test
	public void testWarnOnlyRainIsHigh() {
	    String result = WeatherAndMathUtils.weatherAdvice(30.0, 5.0);
	    Assert.assertEquals("WARN", result);
	}

	@Test
	public void testPrimeNumber() {
	    Assert.assertTrue(WeatherAndMathUtils.isPrime(7)); // Prime
	}

	@Test
	public void testNonPrimeNumber() {
	    Assert.assertFalse(WeatherAndMathUtils.isPrime(9)); // Not prime
	}

	@Test
	public void testEdgeCaseTwo() {
	    Assert.assertTrue(WeatherAndMathUtils.isPrime(2)); // Edge case (first even prime)
	}

	@Test
	public void testOneIsNotPrime() {
	    Assert.assertFalse(WeatherAndMathUtils.isPrime(1)); // 1 is not prime
	}

	@Test
	public void testZeroIsNotPrime() {
	    Assert.assertFalse(WeatherAndMathUtils.isPrime(0)); // 0 is not prime
	}

	@Test
	public void testTrueNumberIsEven() {
	    Assert.assertTrue(WeatherAndMathUtils.isEven(4));
	}

	@Test
	public void testFalseNumberIsEven() {
	    Assert.assertFalse(WeatherAndMathUtils.isEven(5));
	}
	
	@Test
	public void testZeroIsEven() {
	    Assert.assertTrue(WeatherAndMathUtils.isEven(0));
	}

	@Test
	public void testTotalRainfall() {
	    double[] data = {1.2, 3.4, 2.0};
	    Assert.assertEquals(6.6, WeatherAndMathUtils.totalRainfall(data), 0.01);
	}

	@Test
	public void testTotalRainfallEmpty() {
	    double[] data = {};
	    Assert.assertEquals(0.0, WeatherAndMathUtils.totalRainfall(data), 0.01);
	}

	@Test
	public void testCountSevereWindSpeeds() {
	    double[] speeds = {60.0, 71.0, 80.0};
	    Assert.assertEquals(2, WeatherAndMathUtils.countSevereWindSpeeds(speeds));
	}

	@Test
	public void testCountSevereWindSpeedsNone() {
	    double[] speeds = {30.0, 45.0, 50.0};
	    Assert.assertEquals(0, WeatherAndMathUtils.countSevereWindSpeeds(speeds));
	}

}
