package net.proselyte.springbootdemo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "interview")
public class Interview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name = "skills")
    private Integer skills;

    @Column(name = "communication")
    private Integer communication;

    @Column(name = "intellect")
    private Integer intellect;

    @Column(name = "passed_date")
    private Date passedDate;
}
