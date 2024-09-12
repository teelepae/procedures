package procedures.example.procedures_backend.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import procedures.example.procedures_backend.dto.ProcedureDto;
import procedures.example.procedures_backend.dto.ProcedureRecord;
import procedures.example.procedures_backend.entity.Procedure;
import procedures.example.procedures_backend.repository.ProcedureRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ProcedureService {

    private final ProcedureRepository procedureRepository;

    private RabbitMQProducer producer;

    @PersistenceContext
    private EntityManager entityManager;


    public List<ProcedureRecord> getProcedures() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ProcedureRecord> query = criteriaBuilder.createQuery(ProcedureRecord.class);
        Root<Procedure> root = query.from(Procedure.class);
        query.select(criteriaBuilder.construct(ProcedureRecord.class, root.get("id"), root.get("firstName"), root.get("lastName"),
                root.get("idCode"), root.get("email"), root.get("reason"), root.get("letter")));
        return entityManager.createQuery(query).getResultList();
    }

    public ResponseEntity<String> saveProcedure(ProcedureDto procedureDto) {
        procedureRepository.save(convertToProcedureEntity(procedureDto));
        updateProcedureLetter(procedureDto.getEmail());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private void updateProcedureLetter(String email) {
        if(producer.sendMessage(email)) {
            Procedure procedure = procedureRepository.findByEmail(email);
            procedure.setLetter(true);
            procedureRepository.save(procedure);
        }
    }

    private Procedure convertToProcedureEntity(ProcedureDto procedureDto) {
        Procedure procedure = new Procedure();
        procedure.setFirstName(procedureDto.getFirstName());
        procedure.setLastName(procedureDto.getLastName());
        procedure.setIdCode(procedureDto.getIdCode());
        procedure.setEmail(procedureDto.getEmail());
        procedure.setReason(procedureDto.getReason());
        procedure.setLetter(false);
        return procedure;
    }
}
