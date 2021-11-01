package CRM.CRM.repository;

import CRM.CRM.model.Chat;
import CRM.CRM.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface ChatRepository extends JpaRepository<Chat,Long> {

}
