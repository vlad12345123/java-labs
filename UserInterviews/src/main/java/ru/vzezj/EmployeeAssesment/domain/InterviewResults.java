package ru.vzezj.EmployeeAssesment.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "interviewResults")
public class InterviewResults {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // all int columns have a grade from 1 to 10

    @Column(name = "skills")
    private Integer skills;

    @Column(name = "communication")
    private Integer communication;

    @Column(name = "intellect")
    private Integer intellect;

    @Column(name = "passedDate")
    private Date passedDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InterviewResults interviewResults = (InterviewResults) o;
        return interviewResults.equals(interviewResults.skills) && communication.equals(interviewResults.communication)
                && interviewResults.equals(interviewResults.intellect) && interviewResults.equals(interviewResults.passedDate);
    }

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_interviewResults_user_id"))
    private InterviewResults interviewResults;

    @Override
    public int hashCode() {
        return Objects.hash(skills, communication, intellect, passedDate);
    }

    @Override
    public String toString() {
        return "InterviewResults{" +
                "id=" + id +
                ", skills='" + skills + '\'' +
                ", communication='" + communication + '\'' +
                ", intellect='" + intellect + '\'' +
                ", passedDate='" + passedDate + '\'' +
                '}';
    }
}
