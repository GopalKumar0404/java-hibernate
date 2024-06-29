package org.gopal.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Certificate {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String course;
    private String duration;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Student> students;
    public Certificate(String course, String duration) {
        this.course = course;
        this.duration = duration;
    }
}
