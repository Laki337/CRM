package CRM.CRM.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Vector;

@Entity
@Table
@Data
@Embeddable
public class Deportament {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Date dataCreate;

    public Deportament(String name, Date dataCreate){
        this.name = name;
        this.dataCreate = dataCreate;
    }



    public Deportament() {

    }
}
