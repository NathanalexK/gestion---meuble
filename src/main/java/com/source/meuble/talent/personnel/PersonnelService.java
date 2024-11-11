package com.source.meuble.talent.personnel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonnelService {
    @Autowired
    PersonnelRepository personnelRepository;

    public Personnel insertPersonnel(Personnel personnel)throws Exception{
        return personnelRepository.save(personnel);
    }

}
