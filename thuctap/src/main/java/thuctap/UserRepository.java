package thuctap;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>{
//////
//////	Optional<org.apache.catalina.User> findByEmail(String email);
////	@Query("SELECT u FROM User u WHERE u.email = ?1")

	User save(thuctap.User user);
	User  findByEmail(String email);

	
}