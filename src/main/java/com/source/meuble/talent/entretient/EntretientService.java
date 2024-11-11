package com.source.meuble.talent.entretient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntretientService {
    @Autowired
    EntretientRepository entretientRepository;
}
