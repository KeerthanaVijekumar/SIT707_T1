package web.service;

public class LoginService {
    public static boolean login(String username, String password, String dob) {
        // Treat null or whitespace-only inputs as empty
        if (username == null || username.trim().isEmpty() ||
            password == null || password.trim().isEmpty() ||
            dob == null || dob.trim().isEmpty()) {
            return false;
        }

        return "keerthana".equals(username.trim()) &&
               "keerthana_pass".equals(password.trim()) &&
               "1997-07-17".equals(dob.trim());
    }
}
