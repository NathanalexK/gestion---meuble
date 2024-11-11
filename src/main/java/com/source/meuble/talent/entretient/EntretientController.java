package com.source.meuble.talent.entretient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/entretient")
public class EntretientController {

    @Autowired
    EntretientService entretientService;

}
