package CRM.CRM.service;

import CRM.CRM.model.User;
import CRM.CRM.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(s);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }

    public boolean createUser(String name, String password, String email) {
        User fakeUser = userRepository.findByEmail(email);

        if (fakeUser != null) {
            return false;
        }

        User user = new User();
        user.setUsername(name);
        user.setPassword(passwordEncoder.encode(password));
        user.setEmail(email);
        userRepository.save(user);

        return true;
    }

    public boolean deleteUser(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            return false;
        }

        userRepository.delete(user);
        return true;
    }

    public boolean updateUser(String oldEmail, String name, String newEmail, String password){
        User user = userRepository.findByEmail(oldEmail);
        return true;
    }

    public boolean changeEmail(){
        return true;
    }

    public boolean changePassword(){
        return true;
    }

    public boolean changeName(){

        return true;
    }
}