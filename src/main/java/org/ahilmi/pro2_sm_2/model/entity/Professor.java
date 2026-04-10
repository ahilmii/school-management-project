package org.ahilmi.pro2_sm_2.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ahilmi.pro2_sm_2.dto.RequestCourseDTO;
import org.ahilmi.pro2_sm_2.dto.RequestProfessorDTO;
import org.ahilmi.pro2_sm_2.dto.ResponseCourseDTO;
import org.ahilmi.pro2_sm_2.dto.ResponseProfessorDTO;

import java.util.List;

@Entity
@Table(name = "professors")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Professor {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "department")
    private String department;

    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Teaches> teaches;



    // yeni kayıt oluştururken Request DTO'yu Entity'ye çeviren Constructor
    public Professor(RequestProfessorDTO requestDTO) {
        this.name = requestDTO.getName();
        this.department = requestDTO.getDepartment();
    }

    public ResponseProfessorDTO viewAsProfessorDTO() { // entity'den response'a
        ResponseProfessorDTO dto = new ResponseProfessorDTO();
        dto.setId(this.id);
        dto.setName(this.name);
        dto.setDepartment(this.department);

        if (this.teaches != null) {
            dto.setTeaches(this.teaches.stream().map(Teaches::viewAsTeachesDTO).toList());
        }

        return dto;
    }
}
