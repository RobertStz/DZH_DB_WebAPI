package de.dhbw.mannheim.database.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "authority")
    @JsonIgnore
    private List<Message> messages;

    @OneToMany(mappedBy = "authority")
    @JsonIgnore
    private List<AuthorityInvolvedProcess> authorityInvolvedProcesses;

    @OneToMany(mappedBy = "authority")
    @JsonIgnore
    private List<AuthorityResponsibleCitizen> authorityResponsibleCitizens;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<AuthorityInvolvedProcess> getAuthorityInvolvedProcesses() {
        return authorityInvolvedProcesses;
    }

    public void setAuthorityInvolvedProcesses(List<AuthorityInvolvedProcess> authorityInvolvedProcesses) {
        this.authorityInvolvedProcesses = authorityInvolvedProcesses;
    }

    public List<AuthorityResponsibleCitizen> getAuthorityResponsibleCitizens() {
        return authorityResponsibleCitizens;
    }

    public void setAuthorityResponsibleCitizens(List<AuthorityResponsibleCitizen> authorityResponsibleCitizens) {
        this.authorityResponsibleCitizens = authorityResponsibleCitizens;
    }
}
