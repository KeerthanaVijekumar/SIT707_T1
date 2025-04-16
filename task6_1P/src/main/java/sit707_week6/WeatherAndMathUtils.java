package sit707_week6;

public class WeatherAndMathUtils {
	public static final double DANGEROUS_WINDSPEED = 70.0;
	public static final double DANGEROUS_RAINFALL = 6.0;
	public static final double CONCERNING_WINDSPEED = 45.0;
	public static final double CONCERNING_RAINFALL = 4.0;

	/**
	 * Advises weather alert based on wind-speed and precipitation.
	 * 
	 * 
	 * @param windSpeed
	 * @param precipitation
	 * @return
	 */
	public static String weatherAdvice(double windSpeed, double precipitation) {
		if (windSpeed < 0 || precipitation < 0) {
			// Optional: Keep this condition uncovered for P task.
			throw new IllegalArgumentException();
		}

		String advice = "ALL CLEAR";

		if (windSpeed > DANGEROUS_WINDSPEED || precipitation > DANGEROUS_RAINFALL
				|| (windSpeed > CONCERNING_WINDSPEED && precipitation > CONCERNING_RAINFALL)) {
			advice = "CANCEL";
		} else if (windSpeed > CONCERNING_WINDSPEED || precipitation > CONCERNING_RAINFALL) {
			advice = "WARN";
		}

		return advice;
	}

	/**
	 * Calculates if a number is even.
	 * 
	 * @param a
	 * @return
	 */
	public static boolean isEven(int a) {
		if (a % 2 == 0) {
			return true;
		}
		return false;
	}

	/**
	 * Calculates if a number is prime.
	 * 
	 * @param n
	 * @return
	 */
	public static boolean isPrime(int n) {
		 if (n <= 1) {
		        return false;
		    }
		    // Test if n is divisible by any other number down to 2.
		    for (int i = 2; i <= Math.sqrt(n); i++) {
		        if (n % i == 0) {
		            return false;
		        }
		    }
		    return true;
	}
	
	/**
	 * Calculates the total rainfall from a given array of precipitation values.
	 * 
	 * @param rainfallData array of precipitation amounts
	 * @return total rainfall
	 */
	public static double totalRainfall(double[] rainfallData) {
	    double total = 0;
	    for (double rain : rainfallData) {
	        total += rain;
	    }
	    return total;
	}

	/**
	 * Counts how many days had severe wind speeds above the danger threshold.
	 * 
	 * @param windSpeeds array of wind speeds
	 * @return number of severe wind days
	 */
	public static int countSevereWindSpeeds(double[] windSpeeds) {
	    int count = 0;
	    for (double wind : windSpeeds) {
	        if (wind > DANGEROUS_WINDSPEED) {
	            count++;
	        }
	    }
	    return count;
	}

}
