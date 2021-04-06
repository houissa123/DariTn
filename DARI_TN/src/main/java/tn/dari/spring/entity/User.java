package tn.dari.spring.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "T_USER")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String FirstName;
	private String LastName;
	private String Email;

	public Long getId() {
		return Id;
	}
	//

	public void setId(Long id) {
		Id = id;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	@OneToMany
	private List<Claim> claims;
	/*@OneToMany
	private List<Visit> visits;*/
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	private Set<Favorites> favorites;
	/*@OneToMany
	private List<Bank> banks;*/
	/*@OneToMany
	private List<Historical> historicals;*/
	
	@OneToMany(mappedBy="user" , cascade=CascadeType.MERGE)
    private List<Search> search;

}
