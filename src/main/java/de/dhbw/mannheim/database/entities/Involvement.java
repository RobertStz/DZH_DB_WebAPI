package de.dhbw.mannheim.database.entities;


import de.dhbw.mannheim.database.entities.enums.Permission;

import javax.persistence.*;

@Entity
@Table(name = "authority_involved_process")
public class Involvement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    private Authority sourceAuthority;

    @ManyToOne
    private Authority targetAuthority;

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

    public Authority getSourceAuthority() {
        return sourceAuthority;
    }

    public void setSourceAuthority(Authority sourceAuthority) {
        this.sourceAuthority = sourceAuthority;
    }

    public Authority getTargetAuthority() {
        return targetAuthority;
    }

    public void setTargetAuthority(Authority targetAuthority) {
        this.targetAuthority = targetAuthority;
    }
}
