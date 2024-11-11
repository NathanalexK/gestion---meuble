package com.source.meuble.talent.personnel;

import com.source.meuble.util.Redirection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/personnel")
public class PersonnelController {
    @Autowired
    PersonnelService personnelService;

    @GetMapping("/embaucher")
    public void embaucher(
            Personnel personnel
    ) throws Exception{
        Personnel embauche = personnelService.insertPersonnel(personnel);
    }
}
