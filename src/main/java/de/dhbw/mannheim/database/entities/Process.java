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

    private Long progress;


    @OneToMany(mappedBy = "process")
    @JsonIgnore
    private List<Message> messages;

    @OneToMany(mappedBy = "process")
    @JsonIgnore
    private List<AuthorityInvolvedProcess> authorityInvolvedProcesses;

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

    public List<AuthorityInvolvedProcess> getAuthorityInvolvedProcesses() {
        return authorityInvolvedProcesses;
    }

    public void setAuthorityInvolvedProcesses(List<AuthorityInvolvedProcess> authorityInvolvedProcesses) {
        this.authorityInvolvedProcesses = authorityInvolvedProcesses;
    }

    public Long getProgress() {
        return progress;
    }

    public void setProgress(Long progress) {
        this.progress = progress;
    }
}
