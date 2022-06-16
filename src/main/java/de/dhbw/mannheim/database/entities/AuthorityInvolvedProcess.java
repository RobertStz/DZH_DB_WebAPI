package de.dhbw.mannheim.database.entities;


import de.dhbw.mannheim.database.entities.enums.Permission;

import javax.persistence.*;

@Entity
public class AuthorityInvolvedProcess {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    private Authority authority;

    @ManyToOne
    private Process process;

    @Enumerated(EnumType.ORDINAL)
    private Permission permission;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }
}
