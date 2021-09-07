package CRM.CRM.service;

import CRM.CRM.CrmApplication;
import CRM.CRM.model.Deportament;
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
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    DeportamentService deportamentService;


    public UserDetails loadUserByUsername(String s) {
        User user = userRepository.findByUsername(s);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }

    public String createUser(String name, String lastname, String login, String password, String phone, String email, String deportamentName) {
        User fakeUser = userRepository.findByEmail(email);
        if (fakeUser != null) {
            return "Такой пользователь существует";
        }
        if (deportamentService.findByName(deportamentName)==null){
            CrmApplication.LOGGER.info("Такого депортамента не существует");
            return "Такого депортамента не существует";
        }
    User user = new User(login,name,lastname,phone,password,true,deportamentService.findByName(deportamentName).getId(),email,Collections.singleton(Role.USER));

    userRepository.save(user);
        CrmApplication.LOGGER.info("Пользователь успешно создан");
        return "Пользователь успешно создан";
    }

    public User findUserId(Long id) {
        CrmApplication.LOGGER.info("Пользователь успешно найден");
        return userRepository.findById(id).get();
    }

    public String deleteUser(Long id) {
        User user = userRepository.findById(id).get();
        if (user == null) {
            CrmApplication.LOGGER.info("Такой пользователь не существует");
            return "Такой пользователь не существует";
        }
        CrmApplication.LOGGER.info("Пользователь успешно удалён");
        userRepository.delete(user);
        return "Пользователь успешно удалён";
    }

    public String updateUser(Long id, String name, String lastname, String login, String phone, String password, String email, String deportamentName) {
        User user = userRepository.findById(id).get();
        if (user == null) {
            CrmApplication.LOGGER.info("Такой пользователь не существует");
            return "Такой пользователь не существует";
        }

        Deportament deportament = deportamentService.findByName(deportamentName);
        if (deportament==null){
            CrmApplication.LOGGER.info("Такого депортамента не существует");
            return "Такого депортамента не существует";
        }
        user.setDeportamentId(deportament.getId());
        user.setUsername(name);
        user.setLastname(lastname);
        user.setLogin(login);
        user.setPhoneNumber(phone);
        user.setPassword(passwordEncoder.encode(password));
        user.setEmail(email);
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepository.save(user);
        CrmApplication.LOGGER.info("Пользователь успешно обновлён");
        return "Пользователь успешно обновлён";
    }



    public boolean changeEmail() {
        return true;
    }

    public boolean changePassword() {
        return true;
    }

    public boolean changeName() {

        return true;
    }

    public List<User> findAll() {
        CrmApplication.LOGGER.info("Все пользователи найдены");
        return userRepository.findAll();
    }

    public String saveUser(User user) {
        userRepository.save(user);
        CrmApplication.LOGGER.info("Пользователь успешно сохранён");
        return "Пользователь успешно сохранён";
    }

    public User findEmail(String email) {
        CrmApplication.LOGGER.info("Пользователь успешно найден");
        return userRepository.findByEmail(email);
    }
}