package org.maid.maid_library_management_system.service;


import lombok.RequiredArgsConstructor;
import org.maid.maid_library_management_system.controllers.DTO.response.OutputStringDTO;
import org.maid.maid_library_management_system.entity.Patron;
import org.maid.maid_library_management_system.repository.PatronRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PatronService {

    private final PatronRepository patronRepository;

    public List<Patron> fetchAllPatrons() {
        return patronRepository.findAll();
    }

    public Patron fetchById(Integer id) {
        return patronRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patron not found with id: " + id));
    }

    public Patron updatePatron(Patron patron, Integer id) {
        Patron patronToUpdate = patronRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patron not found with id: " + id));
       patronToUpdate.setContactName(patron.getContactName());
       patronToUpdate.setContactNumber(patron.getContactNumber());
       patronToUpdate.setEmail(patron.getEmail());
       return patronRepository.save(patronToUpdate);
    }


    public Patron addPatron(Patron patron) {
        return patronRepository.save(patron);
    }

    public OutputStringDTO deletePatron(Integer id) {
        Patron patron = patronRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patron id not found - " + id));
        patronRepository.delete(patron);
        OutputStringDTO outputStringDTO = new OutputStringDTO();
        outputStringDTO.setMessage("Patron Deleted with id: " + id);
        return outputStringDTO;
    }
}
