package org.gopal.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private List<String> phones;
    private String city;
    @ManyToMany(mappedBy = "students", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Certificate> certificates;
    @Lob
    private byte[] image;
    public Student(String name, List<String> phones, String city) {
        this.name = name;
        this.phones = phones;
        this.city = city;
    }
}
