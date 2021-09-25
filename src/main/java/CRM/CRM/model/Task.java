package CRM.CRM.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private  String full_text;
    private String  localDateTimeStart;
     private String localDateTimeEnd;
     private String priority;
    private Long userId;
    private  Long departamentId;
    private  boolean active;

    public Task(){

    }
    public Task( String title, String full_text, String localDateTimeStart, String localDateTimeEnd, String priority,boolean active, Long userId) {
        this.title = title;
        this.full_text = full_text;
        this.localDateTimeStart = localDateTimeStart;
        this.localDateTimeEnd = localDateTimeEnd;
        this.priority = priority;
        this.userId = userId;
        this.active = active;
    }
    public Task( String title, String full_text, String localDateTimeStart, String localDateTimeEnd, String priority, Long departamentId,  boolean active) {
        this.title = title;
        this.full_text = full_text;
        this.localDateTimeStart = localDateTimeStart;
        this.localDateTimeEnd = localDateTimeEnd;
        this.priority = priority;
        this.departamentId = departamentId;
        this.active = active;
    }
}