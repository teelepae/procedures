package procedures.example.procedures_backend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProcedureDto {
    private String firstName;
    private String lastName;
    private long idCode;
    private String email;
    private String reason;
}
