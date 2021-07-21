package CRM.CRM.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table
@Data
public class Deportament {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;



    public Deportament(String name){
        this.name = name;
    }

    public Deportament() {

    }
}
