package net.prosetlyte.springbootdemo.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Data
@Entity
@Table(name = "grops")
public class Group {
    @Id
    @Column(name = "idgroup")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idGroup;

    @Column(name = "dateofcreatgroup")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @NotNull(message = "Not null")
    private Date created;


    @Column(name = "amountstudents")
    @NotNull(message = "Not null")
    @Min(value = 1)
    private Integer countStud;


    @Column(name = "namegroup")
    @NotNull(message = "Not null")
    @Size(min = 2,max = 10)
    private String nameGroup;

    public Integer getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(Integer idGroup) {
        this.idGroup = idGroup;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Integer getCountStud() {
        return countStud;
    }

    public void setCountStud(Integer countStud) {
        this.countStud = countStud;
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }

    @Override
    public String toString() {
        return "Group{" +
                "idGroup=" + idGroup +
                ", created='" + created + '\'' +
                ", countStud=" + countStud +
                ", nameGroup='" + nameGroup + '\'' +
                '}';
    }
}
