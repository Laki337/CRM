package CRM.CRM.service;

import CRM.CRM.errors.NotFoundException;
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
import java.util.logging.Logger;


@Service
public class UserService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    DeportamentService deportamentService;

    @Autowired
    Logger logger;


    public User createUser(String name, String lastname, String login, String password, String phone, String email, String deportamentName) {
        final User user;
        try {
            if (userRepository.findByEmail(email)!=null) {
                logger.info("Такой пользователь  существует");
                throw new NotFoundException();
            }
            if (deportamentService.findByName(deportamentName) == null) {
                logger.info("Такого депортамента не существует");
                throw new NotFoundException();
            }

            user = new User(login, name, lastname, phone, passwordEncoder.encode(password), true, deportamentService.findByName(deportamentName).getId(), email, Collections.singleton(Role.USER));
            userRepository.save(user);
            logger.info("Пользователь не создан");
        } catch (Exception ex) {
            return  null;
        }
        return user;
    }

    public User findUserId(Long id) {
        final User user;
        try {
            user = userRepository.findById((long) id).get();
            logger.info("Пользователь успешно найден");
        } catch (Exception e) {
            logger.info("Пользователь не удалён");
            return null;
        }
        return user;
    }


    public boolean deleteUser(final Long id) {
        final User user;
        try {
            user = userRepository.findById((long) id).get();

            if (user == null) {
                logger.info("Такой пользователь не существует");
                return false;
            }
            logger.info("Пользователь успешно удалён");
            userRepository.delete(user);
        } catch (Exception e) {
            logger.info("Пользователь не удалён");
            return false;
        }
        return true;
    }

    public User updateUser(Long id, String name, String lastname, String login, String phone, String password, String email, String deportamentName) {
         User user;
        final Deportament deportament;
        try {
            user = userRepository.findById(id).get();
            if (user == null) {
                logger.info("Такой пользователь не существует");
                throw new NotFoundException();
            }
            deportament = deportamentService.findByName(deportamentName);
            if (deportament == null) {
                logger.info("Такого депортамента не существует");
                throw new NotFoundException();
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
        } catch (Exception e) {
            logger.info("Пользователь не обновлён");
            return null;
        }

        logger.info("Пользователь успешно обновлён");
        return user;
    }

    public List<User> findAll() {
      final List<User> list;
        try {
            list = userRepository.findAll();
            logger.info("Все пользователи найдены");
        }
        catch (Exception ex){
            logger.info("Пользователи не найдены");
            return null;
        }
        return list;
    }

    public boolean saveUser(User user) {
        try {
            userRepository.save(user);
            logger.info("Пользователь успешно сохранён");
        } catch (Exception e) {

            logger.info("Пользователь не сохранён");
            return false;
        }

        return true;
    }

    public User findEmail(String email) {
        final User user;
        try {
            user = userRepository.findByEmail(email);
            logger.info("Пользователь успешно найден");

        } catch (Exception ex) {
            logger.info("Пользователь не найден");
            return null;
        }
        return user;
    }

    public List<User> findAllDeportamentId(Long id){
        final List<User> list;
        try {
            list = userRepository.findAllByDeportamentId(id);
            logger.info("Все пользователи найдены");
        }
        catch (Exception ex){
            logger.info("Пользователи не найдены");
            return null;
        }
        return list;
    }
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findByUsername(s);
    }
}