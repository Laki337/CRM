package CRM.CRM.service;

import CRM.CRM.model.Deportament;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface DeportamentService{

     Deportament createDeportament(String name);
     void update(Deportament deportament , String name);
     boolean deleteDeportament(Long id);
     Deportament find(Long id);
     Deportament findByName(String name);
     List<Deportament> findAll();

}
