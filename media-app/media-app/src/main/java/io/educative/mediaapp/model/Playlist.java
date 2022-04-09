package io.educative.mediaapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

@Data // lombok annotation for generating getter-setters-toString-hashcode-equals methods
@Entity // denoting this is a JPA entity object
@Table(name = "playlist") // denoting which table this class should be mapped to
public class Playlist {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id // primary key of the table
    private BigInteger id;

    private String name;

    @Column(name = "created_on") // name of the database column this field should be mapped to
    @JsonProperty("created_on") // name of the database column this field should be mapped to
    private Date createdOn;

    @ElementCollection(targetClass = java.util.HashSet.class) // specifies a collection of instances of a basic type or embeddable/nested class
    @OneToMany(cascade = CascadeType.ALL) // specifies a many-valued association with one-to-many multiplicity
    @JoinColumn // specifies a column for joining an entity association or element collection
    private Collection<Song> songs;

}
