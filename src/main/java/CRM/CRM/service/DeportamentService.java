package CRM.CRM.service;

import CRM.CRM.model.Deportament;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface DeportamentService {

     void add(Deportament deportament);
     void update(Deportament deportament , String name);
     void delete(Deportament deportament);
     Deportament find(Long id);
     Deportament findByName(String name);
     List<Deportament> findAll();
}
