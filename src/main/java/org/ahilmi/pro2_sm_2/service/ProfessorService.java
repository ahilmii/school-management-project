package org.ahilmi.pro2_sm_2.service;


import org.ahilmi.pro2_sm_2.dto.RequestProfessorDTO;
import org.ahilmi.pro2_sm_2.dto.ResponseProfessorDTO;
import org.ahilmi.pro2_sm_2.exception.ErrorMessages;
import org.ahilmi.pro2_sm_2.exception.ResourceAlreadyExistsException;
import org.ahilmi.pro2_sm_2.exception.ResourceNotFoundException;
import org.ahilmi.pro2_sm_2.model.entity.Professor;
import org.ahilmi.pro2_sm_2.repository.ProfessorRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.ahilmi.pro2_sm_2.model.entity.Teaches;
import java.util.List;

@Service
public class ProfessorService implements IProfessorService{

    private final ProfessorRepository professorRepository;

    public ProfessorService(ProfessorRepository professorRepository){
        this.professorRepository =professorRepository;
    }

    public ResponseProfessorDTO saveProfessor(RequestProfessorDTO requestProfessorDTO) {
        if (professorRepository.existsByName(requestProfessorDTO.getName())) {
            throw new ResourceAlreadyExistsException(ErrorMessages.ERROR_PROFESSOR_ALREADY_EXIST);
        }

        Professor professor = new Professor(requestProfessorDTO);
        Professor dbProfessor = professorRepository.save(professor);

        System.out.println("LOG INFO: professor added -> ID: " + dbProfessor.getId() + ", Professor: " + dbProfessor.getName());
        return dbProfessor.viewAsProfessorDTO();
    }


    public List<ResponseProfessorDTO> getAllProfessor() {
        return professorRepository.findAll().stream().map(Professor::viewAsProfessorDTO).toList();
    }


    public ResponseProfessorDTO getProfessorById(Integer id) {
        return professorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorMessages.ERROR_PROFESSOR_NOT_FOUND))
                .viewAsProfessorDTO();
    }

    public void deleteProfessor(Integer id) {
        professorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorMessages.ERROR_PROFESSOR_NOT_FOUND));

        professorRepository.deleteById(id);
        System.out.println("LOG INFO: professor deleted -> ID: " + id);
    }


    public ResponseProfessorDTO updateProfessor(Integer id, RequestProfessorDTO requestProfessorDTO) {
        Professor dbProfessor = professorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorMessages.ERROR_PROFESSOR_NOT_FOUND));


        // request'den gelen bilgiler ile güncelle
        dbProfessor.setName(requestProfessorDTO.getName());
        dbProfessor.setDepartment(requestProfessorDTO.getDepartment());

        Professor updatedProfessor = professorRepository.save(dbProfessor);
        System.out.println("LOG INFO: professor updated -> ID: " + updatedProfessor.getId());

        return updatedProfessor.viewAsProfessorDTO();
    }


}