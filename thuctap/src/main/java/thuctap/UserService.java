package thuctap;

public interface UserService  {
	User findByEmail(String email);
	boolean checkLogin(String email, String password);
	boolean checkEmail(String email);
	User userss(String email);
	boolean checkPassword(String email, String password);

}
