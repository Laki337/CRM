package CRM.CRM.service;

import CRM.CRM.model.Deportament;
import CRM.CRM.model.Role;
import CRM.CRM.model.User;
import CRM.CRM.repository.DeportamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@Service
public class DeportamentServiceImpl implements  DeportamentService{

    @Autowired
    DeportamentRepository deportamentRepository;

    @Autowired
    Logger logger;


    @Override
    public Deportament createDeportament(String name) {
        final Deportament deportament;
        try {
            final Deportament fakeDeportament = deportamentRepository.findByName(name);
            if (fakeDeportament != null) {
                logger.info("Такой отдел не существует");
            }


            deportament = new Deportament(name, new Date());
            deportamentRepository.save(deportament);
            logger.info("Пользователь успешно создан");
        } catch (Exception ex) {
            logger.info("Пользователь не найден");
            return  null;
        }
        return deportament;
    }



    @Override
    public void update(Deportament deportament, String name) {
       deportament.setName(name);
      deportament = deportamentRepository.save(deportament);

    }



    @Override
    public boolean deleteDeportament(final Long id) {
        final  Deportament deportament;
        try {
            deportament = deportamentRepository.findById((long) id).get();

            if (deportament == null) {
                logger.info("Такой Депортамент не существует");
                return false;
            }
            logger.info("Депортамент успешно удалён");
            deportamentRepository.delete(deportament);
        } catch (Exception e) {
            logger.info("Депортамент не удалён");
            return false;
        }
        return true;
    }

    @Override
    public Deportament find(Long id ) {
       final Deportament deportament;
        try {
            deportament = deportamentRepository.findById((long) id).get();

            if (deportament == null) {
                logger.info("Депортамент не найден");
                return null;
            }
            logger.info("Депортамент успешно найден");
        } catch (Exception e) {
            logger.info("Депортамент не найден");
            return null;
        }
        return deportament;
    }


    @Override
    public Deportament findByName(String name) {
        final Deportament deportament;
        try {
            deportament = deportamentRepository.findByName(name);

            if (deportament == null) {
                logger.info("Депортамент не найден");
                return null;
            }
            logger.info("Депортамент успешно найден");
        } catch (Exception e) {
            logger.info("Депортамент не найден");
            return null;
        }
        return deportament;
    }


    @Override
    public List<Deportament> findAll() {
        final List<Deportament> list;
        System.err.println("list");
        try {
            list = deportamentRepository.findAll();
            logger.info("Все депортаменты найдены");
            
        }
        catch (Exception ex){
            logger.info("Депортаменты не найдены");
            return null;
        }
        System.err.println(list);
        return list;
    }
}
