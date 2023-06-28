package com.production.erp.ERPController;

import com.production.erp.container.PolishContainer;
import com.production.erp.model.PolishModel;
import com.production.erp.service.PolishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PolishController {
    private final PolishService polishService;

    @Autowired
    public PolishController(PolishService polishService) {
        this.polishService = polishService;
    }

    @RequestMapping("/polish")
    public String polishHome(Model model){
        PolishContainer polishContainer = new PolishContainer();
        List<PolishModel> polish = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            polish.add(new PolishModel());
        }

        polishContainer.setPolishList(polish);

        model.addAttribute("polish", polish);
        model.addAttribute("polishContainer", polishContainer);

        return "ERP/polish/home";
    }
}
