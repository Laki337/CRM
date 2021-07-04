package CRM.CRM.model;


import lombok.Data;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private  String full_text;
    private LocalDateTime localDateTimeStart;
    private LocalDateTime localDateTimeEnd;


    public Task(String title, String full_text, LocalDateTime localDateTimeEnd ){
        this.title = title;
        this.full_text = full_text;
        this.localDateTimeStart = LocalDateTime.now();
        this.localDateTimeEnd = localDateTimeEnd;

    }


    public Task() {

    }
}