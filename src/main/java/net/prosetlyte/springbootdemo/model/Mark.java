package net.prosetlyte.springbootdemo.model;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.persistence.*;
import javax.validation.constraints.*;


@Data
@Entity
@Table(name  = "marks")
public class Mark {
    @Id
    @Column(name = "idmark")
    @GeneratedValue
    private Integer idMark;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "idstudent", nullable = false)
    private Student student;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "iddiscipline",nullable = false)
    private Discipline discipline;

    @NotNull(message = "Not null")
    @Column(name = "mark")
    @Min(value = 1)
    @Max(value = 5)
    private Integer mark;

    public Mark(){

    }

    public Integer getIdMark() {
        return idMark;
    }

    public void setIdMark(Integer idMark) {
        this.idMark = idMark;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "idMark=" + idMark +
                ", student=" + student.getIdStudent() +
                ", discipline=" + discipline.getIdDiscipline() +
                ", mark=" + mark +
                '}';
    }
}
