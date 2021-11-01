package CRM.CRM.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table
@Data
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String content;
    private Long senderId;
    private  Long chatId;
    private Date creationDate;
    private boolean status;

  

    public Message() {

    }
    
    public Message(String content, Long senderId, Long chatId, Date creationDate, boolean status) {
        this.content = content;
        this.senderId = senderId;
        this.chatId = chatId;
        this.creationDate = creationDate;
        this.status = status;
    }
}
