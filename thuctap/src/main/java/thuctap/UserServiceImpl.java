package thuctap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepository userRepository;
	
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
	}


	public boolean checkLogin(String email, String password) {
		// TODO Auto-generated method stub
		User optionalUser = findByEmail(email);
		if(optionalUser!=null && optionalUser.getPassword().equals(password)) {
			return true;
		}
		return false;
	}
	public boolean checkPassword(String email, String password) {
		User user = findByEmail(email);
		if(user.getPassword().equals(password)) {
			return true;
		}else {
			return false;
		}
	}
	public boolean checkEmail(String email) {
		User optionalUser = findByEmail(email);
		if(optionalUser==null) {
			return true;
		}
		return false;
	}
	public User userss(String email) {
		User optionalUser = findByEmail(email);
		return optionalUser;
	}


}
