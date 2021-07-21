package CRM.CRM.service;

import CRM.CRM.model.Role;
import CRM.CRM.model.User;
import CRM.CRM.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

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
        user.setRoles(Collections.singleton(Role.USER));
        user =userRepository.save(user);

        return user.getId()!=0;
    }

    public User findUserId(Long id){
        return userRepository.findById(id).get();
    }
    public boolean deleteUser(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            return false;
        }

        userRepository.delete(user);
        return true;
    }
    public void saveUser(User user){
        userRepository.save(user);
    }

    public boolean updateUser(String oldEmail, String name, String newEmail, String password){
        User user = userRepository.findByEmail(oldEmail);
        return true;
    }

    public User checkEmail(String email){

        return userRepository.findByEmail(email);
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