package com.amirdehi.quvo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
@Table(name = "TBL_VOTE_OPTIONS")
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int uniqueId;
    //@ManyToOne
    //@JoinColumn(name = "vote_uniqueId")
    //@Column(name = "VOTE_FK", nullable = false)
    @OneToOne(cascade = CascadeType.ALL)
    private Vote voteFK;
    @Column(name = "TEXT", nullable = false)
    private String text;
    @Column(name = "COUNT", nullable = false)
    private int votesCount;
}
