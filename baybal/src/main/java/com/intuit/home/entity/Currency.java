package com.intuit.home.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * +-------------+--------------+------+-----+---------+-------+
 * | Field       | Type         | Null | Key | Default | Extra |
 * +-------------+--------------+------+-----+---------+-------+
 * | iso_name    | varchar(3)   | NO   | PRI | NULL    |       |
 * | description | varchar(100) | YES  |     | NULL    |       |
 * +-------------+--------------+------+-----+---------+-------+
 */
@Entity
@Table
public class Currency {
    @Id //must be initialized by the application
    @Column
    private String isoName;

    @Column
    private String description;


    public String getIsoName() {
        return isoName;
    }

    public Currency setIsoName(String isoName) {
        this.isoName = isoName;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Currency setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{isoName='").append(isoName).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
