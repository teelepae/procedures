package procedures.example.procedures_backend.dto;

import lombok.Builder;

@Builder
public record ProcedureRecord(int id, String firstName, String lastName, long idCode, String email, String reason, Boolean letter) {
}
