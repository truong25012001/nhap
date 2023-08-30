package thuctap;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "adress", nullable = false, length = 1000)
	private String adress;
	
	@Column(nullable = false, unique = true, length = 45)
	private String email;
	
	
	@Column(name = "name", nullable = false, length = 20)
	private String name;
	
	
	@Column(nullable = false, length = 64)
	private String password;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public String getadress() {
		return adress;
	}

	public void setadress(String adress) {
		this.adress = adress;
	}
	
	
	
}