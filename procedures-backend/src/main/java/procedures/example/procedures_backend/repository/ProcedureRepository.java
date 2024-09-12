package procedures.example.procedures_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import procedures.example.procedures_backend.entity.Procedure;

public interface ProcedureRepository extends JpaRepository<Procedure, Integer> {

    @Query(value = "SELECT * FROM procedure WHERE email=?",nativeQuery = true)
    public Procedure findByEmail(String email);
}