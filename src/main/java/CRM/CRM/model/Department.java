package CRM.CRM.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "post")
@Data
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private  String full_text;
    private LocalDateTime localDateTimeStart;
    private LocalDateTime localDateTimeEnd;

    public Department(String title, String full_text, LocalDateTime localDateTimeEnd){
        this.title = title;
        this.full_text = full_text;
        this.localDateTimeStart = LocalDateTime.now();
        this.localDateTimeEnd = localDateTimeEnd;
    }

    public Department() {

    }
}
