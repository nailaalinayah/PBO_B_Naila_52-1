public class Admin {
    private final String username = "bismillah";
    private final String password = "bismillah123";

    public boolean login(String inputUsername, String inputPassword) {
        return username.equals(inputUsername) && password.equals(inputPassword);
    }
}
