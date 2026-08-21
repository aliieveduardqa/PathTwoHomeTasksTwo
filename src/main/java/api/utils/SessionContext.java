package api.utils;

public class SessionContext {
    private static final ThreadLocal<String> userToken = new ThreadLocal<>();
    private static final ThreadLocal<String> userEmail = new ThreadLocal<>();

    private SessionContext() {}

    public static void setToken(String token) {
        userToken.set(token);
    }

    public static String getToken() {
        return userToken.get();
    }

    public static void setEmail(String email) {
        userEmail.set(email);
    }

    public static String getEmail() {
        return userEmail.get();
    }

    public static void clear() {
        userToken.remove();
        userEmail.remove();
    }
}