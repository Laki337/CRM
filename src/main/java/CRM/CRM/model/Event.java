package CRM.CRM.model;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table
@Data
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    String name;
    Long userId;
    String dateStart;
    String dateEnd;
    String type;

    public Event(String name, Long userId, String dateStart, String dateEnd, String type) {
        this.name = name;
        this.userId = userId;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.type = type;
    }

    public Event(String name, String dateStart) {
        this.name = name;
        this.dateStart = dateStart;
    }

    public Event(String name, Long userId, String type) {
        this.name = name;
        this.userId = userId;
        this.type = type;
    }

    public Event() {

    }
    
    
}
