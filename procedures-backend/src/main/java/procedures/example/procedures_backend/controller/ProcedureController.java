package procedures.example.procedures_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import procedures.example.procedures_backend.dto.ProcedureDto;
import procedures.example.procedures_backend.dto.ProcedureRecord;
import procedures.example.procedures_backend.service.ProcedureService;

import java.util.List;

@RestController
public class ProcedureController {

    @Autowired
    private ProcedureService procedureService;

    @PostMapping("/procedure")
    public ResponseEntity<String> saveProcedure(@RequestBody ProcedureDto procedureDto)
    {
        return procedureService.saveProcedure(procedureDto);
    }

    @GetMapping("/procedures")
    private List<ProcedureRecord> getProcedures()
    {
        return procedureService.getProcedures();
    }

}