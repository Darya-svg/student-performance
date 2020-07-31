package net.prosetlyte.springbootdemo.model;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @Column(name = "idstudent")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idStudent;

    @Size(min = 2, max = 30)
    @Column(name = "namestudent")
    @NotEmpty(message = "Not null")
    private String nameStudent;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name="idgroup", nullable = false)
    private Group group;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @NotNull(message = "Not null")
    @Column(name = "birthdaystudent")
    private Date bDayStudent;

    @NotEmpty(message = "Not null")
    @Column(name = "citystudent", length = 20)
    private String cityStudent;

    @Column(name = "scholarshipstudent")
    private String cashStudent;

    public Student() {

    }

    public Integer getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Integer idStudent) {

        this.idStudent = idStudent;
    }

    public String getNameStudent() {

        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Date getbDayStudent() {
        return bDayStudent;
    }

    public void setbDayStudent(Date bDayStudent) {
        this.bDayStudent = bDayStudent;
    }

    public String getCityStudent() {
        return cityStudent;
    }

    public void setCityStudent(String cityStudent) {
        this.cityStudent = cityStudent;
    }

    public String getCashStudent() {
        return cashStudent;
    }

    public void setCashStudent(String cashStudent) {
        this.cashStudent = cashStudent;
    }

    @Override
    public String toString() {
        return "Student{" +
                "idStudent=" + idStudent +
                ", nameStudent='" + nameStudent + '\'' +
                ", group=" + group + group.getIdGroup()+
                ", bDayStudent=" + bDayStudent +
                ", cityStudent='" + cityStudent + '\'' +
                ", cashStudent='" + cashStudent + '\'' +
                '}';
    }
}
