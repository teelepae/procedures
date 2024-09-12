package procedures.example.procedures_backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "PROCEDURE")
public class Procedure {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String firstName;
    private String lastName;
    private long idCode;
    @Column(unique=true)
    private String email;
    private String reason;
    private boolean letter;

}