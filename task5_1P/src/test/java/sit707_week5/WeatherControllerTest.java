package sit707_week5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class WeatherControllerTest {
	
	private static WeatherController controller;
    private static List<Double> hourlyTemps;

    @BeforeClass
    public static void initializeBeforeClass() {
        // Arrange shared test setup (called once before all tests)
        controller = WeatherController.getInstance();
        hourlyTemps = new ArrayList<>();
        int totalHours = controller.getTotalHours();
        for (int i = 0; i < totalHours; i++) {
            hourlyTemps.add(controller.getTemperatureForHour(i + 1));
        }
    }

    @AfterClass
    public static void shutdownAfterClass() {
        // Clean up once after all tests
        controller.close();
    }

	@Test
	public void testStudentIdentity() {
		String studentId = "s224719679";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Keerthana";
		Assert.assertNotNull("Student name is null", studentName);
	}

	@Test
	public void testTemperatureMin() {
		System.out.println("+++ testTemperatureMin +++");

        // Arrange
        double expectedMin = Collections.min(hourlyTemps);

        // Act
        double cachedMin = controller.getTemperatureMinFromCache();

        // Assert
        Assert.assertEquals("Minimum temperature does not match", expectedMin, cachedMin, 0.001);	
	}
	
	@Test
	public void testTemperatureMax() {
		System.out.println("+++ testTemperatureMax +++");

        // Arrange
        double expectedMax = Collections.max(hourlyTemps);

        // Act
        double cachedMax = controller.getTemperatureMaxFromCache();

        // Assert
        Assert.assertEquals("Maximum temperature does not match", expectedMax, cachedMax, 0.001);
	}

	@Test
	public void testTemperatureAverage() {
		System.out.println("+++ testTemperatureAverage +++");

        // Arrange
        double sum = 0.0;
        for (double temp : hourlyTemps) {
            sum += temp;
        }
        double expectedAvg = sum / hourlyTemps.size();

        // Act
        double cachedAvg = controller.getTemperatureAverageFromCache();

        // Assert
        Assert.assertEquals("Average temperature does not match", expectedAvg, cachedAvg, 0.001);
	}
	
	@Test
	public void testTemperaturePersist() {
		/*
		 * Remove below comments ONLY for 5.3C task.
		 */
//		System.out.println("+++ testTemperaturePersist +++");
//		
//		// Initialise controller
//		WeatherController wController = WeatherController.getInstance();
//		
//		String persistTime = wController.persistTemperature(10, 19.5);
//		String now = new SimpleDateFormat("H:m:s").format(new Date());
//		System.out.println("Persist time: " + persistTime + ", now: " + now);
//		
//		Assert.assertTrue(persistTime.equals(now));
//		
//		wController.close();
	}
}
