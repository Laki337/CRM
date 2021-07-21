package CRM.CRM.service;

import CRM.CRM.model.Deportament;
import CRM.CRM.repository.DeportamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeportamentServiceImpl implements  DeportamentService{

    @Autowired
    DeportamentRepository deportamentRepository;



    @Override
    public void add(Deportament deportament) {
        deportamentRepository.save(deportament);
    }

    @Override
    public void update(Deportament deportament, String name) {
        System.out.println(deportament.getId());
       deportament.setName(name);
      deportament = deportamentRepository.save(deportament);
        System.out.println(deportament);

    }

    @Override
    public void delete(Deportament deportament) {
        deportamentRepository.delete(deportament);
    }

    @Override
    public Deportament find(Long id ) {

        return deportamentRepository.findById(id).get();
    }

    @Override
    public Deportament findByName(String name) {
        return deportamentRepository.findByName(name);
    }


    @Override
    public List<Deportament> findAll() {

        List<Deportament> list = deportamentRepository.findAll();
        return list;
    }
}
