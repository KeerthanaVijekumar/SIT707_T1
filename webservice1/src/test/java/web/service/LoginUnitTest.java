package web.service;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Unit tests for LoginService.java
 * Covers boundary value, equivalence class, and decision-table based testing.
 */
public class LoginUnitTest {

    // Positive test: all correct
    @Test
    public void testValidLogin() {
        assertTrue(LoginService.login("keerthana", "keerthana_pass", "1997-07-17"));
    }

    // Decision-table test cases
    @Test
    public void testWrongUsername() {
        assertFalse(LoginService.login("wronguser", "keerthana_pass", "1997-07-17"));
    }

    @Test
    public void testWrongPassword() {
        assertFalse(LoginService.login("keerthana", "wrong_pass", "1997-07-17"));
    }

    @Test
    public void testWrongDOB() {
        assertFalse(LoginService.login("keerthana", "keerthana_pass", "2000-01-01"));
    }

    @Test
    public void testAllWrong() {
        assertFalse(LoginService.login("bad", "bad", "2000-12-31"));
    }

    // Boundary value test: empty strings
    @Test
    public void testEmptyUsername() {
        assertFalse(LoginService.login("", "keerthana_pass", "1997-07-17"));
    }

    @Test
    public void testEmptyPassword() {
        assertFalse(LoginService.login("keerthana", "", "1997-07-17"));
    }

    @Test
    public void testEmptyDOB() {
        assertFalse(LoginService.login("keerthana", "keerthana_pass", ""));
    }

    // Null input tests
    @Test
    public void testNullUsername() {
        assertFalse(LoginService.login(null, "keerthana_pass", "1997-07-17"));
    }

    @Test
    public void testNullPassword() {
        assertFalse(LoginService.login("keerthana", null, "1997-07-17"));
    }

    @Test
    public void testNullDOB() {
        assertFalse(LoginService.login("keerthana", "keerthana_pass", null));
    }

    // Equivalence class: wrong format DOB
    @Test
    public void testDOBWrongFormat() {
        assertFalse(LoginService.login("keerthana", "keerthana_pass", "17-07-1997")); // dd-mm-yyyy instead of yyyy-mm-dd
    }
}
