package de.dhbw.mannheim.database.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import de.dhbw.mannheim.database.entities.enums.Gender;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class Citizen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 11, nullable = false)
    private String taxId;
    private String email;
    private String password;
    private String title;
    private String name;
    private String birthName;
    private String firstName;
    private String birthPlace;
    private String birthCountry;
    private Date birthday;

    @Enumerated(EnumType.ORDINAL)
    private Gender gender;

    @OneToOne
    private Citizen mother;

    @OneToOne
    private Citizen father;

    @OneToMany(mappedBy = "citizen")
    @JsonIgnore
    private List<Message> messages;

    @OneToMany(mappedBy = "citizen")
    @JsonIgnore
    private List<Process> processes;

    @OneToMany(mappedBy = "citizen")
    @JsonIgnore
    private List<AuthorityResponsibleCitizen> authorityResponsibleCitizens;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTitle() {
        return title;
    }

    public void setTitel(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthName() {
        return birthName;
    }

    public void setBirthName(String birthName) {
        this.birthName = birthName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getBirthCountry() {
        return birthCountry;
    }

    public void setBirthCounty(String birthCounty) {
        this.birthCountry = birthCounty;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Citizen getMother() {
        return mother;
    }

    public void setMother(Citizen mother) {
        this.mother = mother;
    }

    public Citizen getFather() {
        return father;
    }

    public void setFather(Citizen father) {
        this.father = father;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Process> getProcesses() {
        return processes;
    }

    public void setProcesses(List<Process> processes) {
        this.processes = processes;
    }

    public List<AuthorityResponsibleCitizen> getAuthorityResponsibleCitizens() {
        return authorityResponsibleCitizens;
    }

    public void setAuthorityResponsibleCitizens(List<AuthorityResponsibleCitizen> authorityResponsibleCitizens) {
        this.authorityResponsibleCitizens = authorityResponsibleCitizens;
    }
}
