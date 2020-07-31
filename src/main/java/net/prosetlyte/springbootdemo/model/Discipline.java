package net.prosetlyte.springbootdemo.model;



import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table(name = "disciplines")
public class Discipline {
    @Id
    @Column(name = "iddiscipline")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDiscipline;

    @NotEmpty(message = "Not null")
    @Column(name = "namediscipline",length = 20)
    private String nameDiscipline;

    @NotNull(message = "Not null")
    @Column(name = "amounthours")
    @Min(value = 1)
    private Integer studyHours;

    public Integer getIdDiscipline() {
        return idDiscipline;
    }

    public void setIdDiscipline(Integer idDiscipline) {
        this.idDiscipline = idDiscipline;
    }

    public String getNameDiscipline() {
        return nameDiscipline;
    }

    public void setNameDiscipline(String nameDiscipline) {
        this.nameDiscipline = nameDiscipline;
    }

    public Integer getStudyHours() {
        return studyHours;
    }

    public void setStudyHours(Integer studyHours) {
        this.studyHours = studyHours;
    }
}
