package CRM.CRM.model;


import CRM.CRM.repository.UserRepository;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Data
public class Chat {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	
	@ManyToMany(fetch = FetchType.EAGER,  cascade = CascadeType.ALL)
	@JoinTable(
			name = "user_chat",
			joinColumns = @JoinColumn(name="chat_id"),
			inverseJoinColumns = @JoinColumn(name = "user_id")
	)
	@JsonBackReference
	private List<User> users;
	private Date creationDate;

	
	public Chat() {
	
	}
	
	public Chat( String name, Date creationDate) {
		this.name = name;
		this.creationDate = creationDate;
	}
	public void chatAddUser(User user){
       users.add(user);
	}
}
