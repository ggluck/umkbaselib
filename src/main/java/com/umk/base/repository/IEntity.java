package com.umk.base.repository;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public abstract class IEntity implements Serializable{
	private static final long serialVersionUID = -6397862328171978378L;
    protected Long id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
