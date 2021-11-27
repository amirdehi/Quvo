package com.amirdehi.quvo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
@Table(name = "TBL_VOTES")
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int uniqueId;
    @Column(name = "TITLE", nullable = false)
    private String title;
    @Column(name = "SUBTITLE")
    private String subtitle;
    //@ManyToOne
    //@JoinColumn(name = "user_uniqueId")
    //@Column(name = "CREATOR", nullable = false)
    @OneToOne(cascade = CascadeType.ALL)
    private Users creator;
    @Column(name = "CREATION_DATE", nullable = false)
    private Date creationDate;
    @Column(name = "EXPIRE_DATE", nullable = false)
    private Date expireDate;
    //@OneToMany(mappedBy = "vote")
    @ManyToOne(cascade = CascadeType.ALL)
    private Option option;
}