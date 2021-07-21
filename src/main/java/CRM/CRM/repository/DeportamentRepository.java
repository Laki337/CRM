package CRM.CRM.repository;

import CRM.CRM.model.Deportament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeportamentRepository extends JpaRepository<Deportament, Long> {
    Deportament findByName(String name);
}
