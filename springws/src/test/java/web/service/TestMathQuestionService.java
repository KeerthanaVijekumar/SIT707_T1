package web.service;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestMathQuestionService {

    @Test
    public void testAddition_ValidInput() {
        assertEquals(3.0, MathQuestionService.q1Addition("1", "2"), 0.001);
    }

    @Test
    public void testAddition_NegativeNumbers() {
        assertEquals(-5.0, MathQuestionService.q1Addition("-2", "-3"), 0.001);
    }

    @Test
    public void testAddition_Decimals() {
        assertEquals(5.7, MathQuestionService.q1Addition("2.5", "3.2"), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddition_EmptyInput() {
        MathQuestionService.q1Addition("", "2");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddition_InvalidString() {
        MathQuestionService.q1Addition("abc", "3");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddition_NullInput() {
        MathQuestionService.q1Addition(null, "5");
    }

    @Test
    public void testSubtraction_ValidInput() {
        assertEquals(1.0, MathQuestionService.q2Subtraction("5", "4"), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSubtraction_InvalidInput() {
        MathQuestionService.q2Subtraction("abc", "4");
    }
    
    @Test
    public void testMultiplication_ValidInput() {
        assertEquals(12.0, MathQuestionService.q3Multiplication("3", "4"), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMultiplication_InvalidInput() {
        MathQuestionService.q3Multiplication("a", "5");
    }

}
