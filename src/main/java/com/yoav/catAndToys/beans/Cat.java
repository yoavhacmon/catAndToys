package com.yoav.catAndToys.beans;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Getter
@Setter
@ToString
public class Cat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (length = 40, nullable = false)
    private String name;
    private float weight;
    @Singular("toy")
    @ManyToMany(fetch = FetchType.EAGER ,cascade = CascadeType.MERGE)
//    @JoinColumn(name = "cat", referencedColumnName = "id")
    private List<Toy> toys;
}
