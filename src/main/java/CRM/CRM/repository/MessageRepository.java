package CRM.CRM.repository;

import CRM.CRM.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
	
	@Query(value = "SELECT *, MAX(creation_date)  FROM spring.message WHERE recipient_id=?1 OR sender_id = ?2",nativeQuery=true)
	List<Message> findBySenderIdAndRecipientId(@Param("sender_id") Long sender_id, @Param("recipient_id") Long recipient_id);
	
}
