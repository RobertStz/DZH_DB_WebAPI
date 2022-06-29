package de.dhbw.mannheim.database.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;


@Entity
public class Process {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;


    @OneToMany(mappedBy = "process")
    @JsonIgnore
    private List<Message> messages;

    @OneToMany(mappedBy = "process")
    @JsonIgnore
    private List<Involvement> involvements;

    @ManyToOne
    private Citizen citizen;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public Citizen getCitizen() {
        return citizen;
    }

    public void setCitizen(Citizen citizen) {
        this.citizen = citizen;
    }

    public List<Involvement> getAuthorityInvolvedProcesses() {
        return involvements;
    }

    public void setAuthorityInvolvedProcesses(List<Involvement> involvements) {
        this.involvements = involvements;
    }

}
