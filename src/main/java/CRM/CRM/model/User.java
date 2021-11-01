package CRM.CRM.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table
@Data
@Embeddable
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String login;
    private String username;
    private String lastname;
    private String phoneNumber;
    private String password;
    private boolean active;
    private String cod;
    private Long deportamentId;
    private String email;
    
    @ManyToMany(fetch = FetchType.EAGER,  cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_chat",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name = "chat_id")
    )
    @JsonBackReference
   private List<Chat> chats;
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    public User(){

    }

    public User(String login, String username, String lastname, String phoneNumber, String password, boolean active,  Long deportamentId, String email, Set<Role> roles) {
        this.login = login;
        this.username = username;
        this.lastname = lastname;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.active = active;
        this.deportamentId = deportamentId;
        this.email = email;
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public boolean isAccountNonExpired() {
        return isActive();
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}