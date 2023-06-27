package com.production.erp.ERPController;

import com.production.erp.container.ChestsContainer;
import com.production.erp.model.ChestModel;
import com.production.erp.model.PhoneModel;
import com.production.erp.model.StatusModel;
import com.production.erp.model.TestingModel;
import com.production.erp.service.ChestService;
import com.production.erp.service.PhoneService;
import com.production.erp.service.StatusService;
import com.production.erp.service.TestingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Controller
public class ChestController {
    private final ChestService chestService;
    private final TestingService testingService;
    private final PhoneService phoneService;
    private final StatusService statusService;

    @Autowired
    public ChestController(ChestService chestService, TestingService testingService, PhoneService phoneService, StatusService statusService) {
        this.chestService = chestService;
        this.testingService = testingService;
        this.phoneService = phoneService;
        this.statusService = statusService;
    }

    @RequestMapping("/chests")
    public String chestHome(Model model) {
        model.addAttribute("chests", chestService.chestsList());

        ChestsContainer chestsContainer = new ChestsContainer();
        List<ChestModel> chestList = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            chestList.add(new ChestModel());
        }
        chestsContainer.setChestList(chestList);
        model.addAttribute("chestContainer", chestsContainer);

        return "ERP/chest/home";
    }

    @RequestMapping("/chest")
    public String createChest(@ModelAttribute("chestContainer") ChestsContainer chestsContainer, RedirectAttributes redirect) {
        List<TestingModel> test = new ArrayList<>();
        Long number = chestService.findLastChestNumber();
        String phase = chestsContainer.getPhase();
        List<String> msg = new ArrayList<>();

        for (ChestModel c : chestsContainer.getChestList()) {
            if (c.getImei() != null) {
                StatusModel status = statusService.lastStatus(c.getImei());
                if (Objects.equals(status.getSend_to(), phase)) {
                    c.setNumber(number);
                    c.setPhase(phase);
                    chestService.createChest(c);
                } else {
                    msg.add(c.getImei() + " send to: " + status.getSend_to());
                }
            }
        }

        redirect.addAttribute("msg", msg);

        return "redirect:/chest/" + number;
    }

    @RequestMapping("/chest/{number}")
    public String editChest(@PathVariable("number") Long number, Model model, @RequestParam(value = "msg", required = false) List<String> msg) {
        List<ChestModel> chests = chestService.findByNumber(number);
        List<TestingModel> tests = new ArrayList<>();
        List<PhoneModel> phones = new ArrayList<>();

        for (ChestModel p : chests) {
            tests.add(testingService.lastTest(p.getImei()));
            phones.add(phoneService.findByImei(p.getImei()));
        }

        if (chests.size() < 41) {
            ChestsContainer chestsContainer = new ChestsContainer();
            List<ChestModel> chestList = new ArrayList<>();
            int max = 40 - chests.size();
            for (int i = 0; i < max; i++) {
                chestList.add(new ChestModel());
            }
            chestsContainer.setChestList(chestList);
            model.addAttribute("chestContainer", chestsContainer);
        }

        model.addAttribute("msg", msg);
        model.addAttribute("tests", tests);
        model.addAttribute("chests", chests);
        model.addAttribute("phase", chests.get(0).getPhase());
        model.addAttribute("number", chests.get(0).getNumber());
        model.addAttribute("phones", phones);

        return "ERP/chest/edit";
    }

    @RequestMapping("/chest/delete/{number}")
    public String deleteChest(@PathVariable("number") Long number) {
        chestService.deleteChestNumber(number);

        return "redirect:/chests";
    }

    @RequestMapping("chest/deleteID/{id}")
    public String deletePhone(@PathVariable("id") Long id) {
        Long number = chestService.findFirstByIdOrderByIdDesc(id).getNumber();
        chestService.delete(id);

        return "redirect:/chest/" + number;
    }

    @RequestMapping("/chest/add/{number}")
    public String addPhone(@PathVariable("number") Long number, @ModelAttribute("chestContainer") ChestsContainer chestsContainer, RedirectAttributes redirect) {
        String phase = chestsContainer.getPhase().split(",")[0];
        List<String> msg = new ArrayList<>();
        System.out.println("Qui " + phase);

        for (ChestModel c : chestsContainer.getChestList()) {
            if (c.getImei() != null) {
                System.out.println("Phase " + phase);

                StatusModel status = statusService.findByImeiOrderByDateDesc(c.getImei());

                if (status.getSend_to() == null) {
                    status.setSend_to("ITC");
                }

                System.out.println("Here last ");
                if (Objects.equals(status.getSend_to(), phase)) {
                    c.setNumber(number);
                    c.setPhase(phase);
                    chestService.createChest(c);
                } else {
                    msg.add(c.getImei() + " send to: " + status.getSend_to());
                }
            }
        }

        redirect.addAttribute("msg", msg);

        return "redirect:/chest/" + number;
    }
}
