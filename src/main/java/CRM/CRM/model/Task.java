package CRM.CRM.model;


import lombok.Data;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private  String full_text;
    private Date  localDateTimeStart;
     private Date localDateTimeEnd;
    private long userId;
    private  long departamentId;

    public Task(String title, String full_text, Date localDateTimeStart,Date localDateTimeEnd,long userId ){
        this.title = title;
        this.full_text = full_text;
        this.localDateTimeStart = localDateTimeStart;
       this.localDateTimeEnd = localDateTimeEnd;
        this.userId = userId;

    }


    public Task(String title, String full_text, Date localDateTimeStart,long departamentId ,Date localDateTimeEnd){
        this.title = title;
        this.full_text = full_text;
        this.localDateTimeStart = localDateTimeStart;
      this.localDateTimeEnd = localDateTimeEnd;
        this.departamentId = departamentId;
    }

    public Task(){

    }
}