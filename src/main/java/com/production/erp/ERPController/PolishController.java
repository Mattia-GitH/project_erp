package com.production.erp.ERPController;

import com.production.erp.container.PolishContainer;
import com.production.erp.model.PolishModel;
import com.production.erp.model.StatusModel;
import com.production.erp.model.TestingModel;
import com.production.erp.service.IssueListService;
import com.production.erp.service.PolishService;
import com.production.erp.service.StatusService;
import com.production.erp.service.TestingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Controller
public class PolishController {
    private final PolishService polishService;
    private final StatusService statusService;
    private final IssueListService issueListService;
    private final TestingService testingService;

    @Autowired
    public PolishController(PolishService polishService, StatusService statusService, IssueListService issueListService, TestingService testingService) {
        this.polishService = polishService;
        this.statusService = statusService;
        this.issueListService = issueListService;
        this.testingService = testingService;
    }

    @RequestMapping("/polish")
    public String polishHome(Model model) {
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

    @RequestMapping("/polishing")
    public String polishing(@ModelAttribute("polishContainer") PolishContainer polishContainer, Model model) {
        List<PolishModel> polish = new ArrayList<>();
        List<String> msg = new ArrayList<>();
        List<List<PolishModel>> timesPolish = new ArrayList<>();

        for (PolishModel p : polishContainer.getPolishList()) {
            if (p.getImei() != null) {
                if (Objects.equals(statusService.findByImeiOrderByDateDesc(p.getImei()).getSend_to(), "POLISH")) {
                    polish.add(p);
                    timesPolish.add(polishService.allPolishByImei(p.getImei()));
                } else {
                    msg.add("Imei not found in polish. IMEI: " + p.getImei());
                }
            }
        }

        model.addAttribute("issues", issueListService.listIssues());
        model.addAttribute("timesPolish", timesPolish);
        model.addAttribute("msg", msg);
        model.addAttribute("polish", polish);
        model.addAttribute("polishContainer", new PolishContainer());

        return "ERP/polish/polishing";
    }

    @RequestMapping("/polish/save")
    public String polishSave(@ModelAttribute("polishContainer") PolishContainer polishContainer, Model model,
                             @RequestParam(name = "time0", required = false) String time0, @RequestParam(name = "time1", required = false) String time1,
                             @RequestParam(name = "time2", required = false) String time2, @RequestParam(name = "time3", required = false) String time3,
                             @RequestParam(name = "time4", required = false) String time4, @RequestParam(name = "time5", required = false) String time5,
                             @RequestParam(name = "time6", required = false) String time6, @RequestParam(name = "time7", required = false) String time7,
                             @RequestParam(name = "send_to0", required = false) String send_to0, @RequestParam(name = "send_to1", required = false) String send_to1,
                             @RequestParam(name = "send_to2", required = false) String send_to2, @RequestParam(name = "send_to3", required = false) String send_to3,
                             @RequestParam(name = "send_to4", required = false) String send_to4, @RequestParam(name = "send_to5", required = false) String send_to5,
                             @RequestParam(name = "send_to6", required = false) String send_to6, @RequestParam(name = "send_to7", required = false) String send_to7,
                             @RequestParam(name = "tlList0", required = false) String tlList0, @RequestParam(name = "tlList1", required = false) String tlList1,
                             @RequestParam(name = "tlList2", required = false) String tlList2, @RequestParam(name = "tlList3", required = false) String tlList3,
                             @RequestParam(name = "tlList4", required = false) String tlList4, @RequestParam(name = "tlList5", required = false) String tlList5,
                             @RequestParam(name = "tlList6", required = false) String tlList6, @RequestParam(name = "tlList7", required = false) String tlList7
    ) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        List<String> time = new ArrayList<>();
        if (time0 != null) time.add(time0);
        if (time1 != null) time.add(time1);
        if (time2 != null) time.add(time2);
        if (time3 != null) time.add(time3);
        if (time4 != null) time.add(time4);
        if (time5 != null) time.add(time5);
        if (time6 != null) time.add(time6);
        if (time7 != null) time.add(time7);

        List<String> send_to = new ArrayList<>();
        if (send_to0 != null) send_to.add(send_to0);
        if (send_to1 != null) send_to.add(send_to1);
        if (send_to2 != null) send_to.add(send_to2);
        if (send_to3 != null) send_to.add(send_to3);
        if (send_to4 != null) send_to.add(send_to4);
        if (send_to5 != null) send_to.add(send_to5);
        if (send_to6 != null) send_to.add(send_to6);
        if (send_to7 != null) send_to.add(send_to7);

        List<String> tlList = new ArrayList<>();
        if (tlList0 != null) tlList.add(tlList0);
        if (tlList1 != null) tlList.add(tlList1);
        if (tlList2 != null) tlList.add(tlList2);
        if (tlList3 != null) tlList.add(tlList3);
        if (tlList4 != null) tlList.add(tlList4);
        if (tlList5 != null) tlList.add(tlList5);
        if (tlList6 != null) tlList.add(tlList6);
        if (tlList7 != null) tlList.add(tlList7);

        createPolish(polishContainer, authentication, time, send_to, tlList);

        return "redirect:/polish";
    }

    public void createPolish(PolishContainer polishContainer, Authentication authentication, List<String> time, List<String> send_to, List<String> tlList) {
        for (PolishModel p : polishContainer.getPolishList()) {
            int index = polishContainer.polishList.indexOf(p);
            int send_toIndex = 0;
            int tlListIndex = 0;

            p.setOperator(authentication.getName());
            p.setDate(new Date(new java.util.Date().getTime()));

            if (time.get(index).length() == 1) {
                p.setTime(Time.valueOf("00:0" + time.get(index) + ":00"));
            } else if (time.get(index).length() == 2) {
                p.setTime(Time.valueOf("00:" + time.get(index) + ":00"));
            }

            StatusModel status = new StatusModel();
            status.setImei(p.getImei());
            status.setActual_status("POLISH");
            status.setOperator(authentication.getName());
            status.setDate(new java.util.Date());
            status.setTimer(LocalTime.MIN);
            status.setSend_to("PACKING");
            if (Objects.equals(p.getResult(), "FAIL")) {
                status.setSend_to(send_to.get(send_toIndex));
                send_toIndex = send_toIndex + 1;
            }

            List<String> tl = Arrays.asList(tlList.get(tlListIndex).split(","));

            TestingModel testing = new TestingModel();

            if (tl.size() > 1){
                for (String issue : tl) {
                    if (Objects.equals(issue, "TL0")) testing.setTL0(true);
                    if (Objects.equals(issue, "TL1")) testing.setTL1(true);
                    if (Objects.equals(issue, "TL2")) testing.setTL2(true);
                    if (Objects.equals(issue, "TL2T")) testing.setTL2T(true);
                    if (Objects.equals(issue, "TL4")) testing.setTL4(true);
                    if (Objects.equals(issue, "TL5")) testing.setTL5(true);
                    if (Objects.equals(issue, "TL5A")) testing.setTL5A(true);
                    if (Objects.equals(issue, "TL5B")) testing.setTL5B(true);
                    if (Objects.equals(issue, "TL8P")) testing.setTL8P(true);
                    if (Objects.equals(issue, "TL8")) testing.setTL8(true);
                    if (Objects.equals(issue, "TL9")) testing.setTL9(true);
                    if (Objects.equals(issue, "TL9T")) testing.setTL9T(true);
                    if (Objects.equals(issue, "TL10")) testing.setTL10(true);
                    if (Objects.equals(issue, "TL10G")) testing.setTL10G(true);
                    if (Objects.equals(issue, "TL10T")) testing.setTL10T(true);
                    if (Objects.equals(issue, "TL11")) testing.setTL11(true);
                    if (Objects.equals(issue, "TL11G")) testing.setTL11G(true);
                    if (Objects.equals(issue, "TL12")) testing.setTL12(true);
                    if (Objects.equals(issue, "TL13")) testing.setTL13(true);
                    if (Objects.equals(issue, "TL14")) testing.setTL14(true);
                    if (Objects.equals(issue, "TL14P")) testing.setTL14P(true);
                    if (Objects.equals(issue, "TL14A")) testing.setTL14A(true);
                    if (Objects.equals(issue, "TL14B")) testing.setTL14B(true);
                    if (Objects.equals(issue, "TL14T")) testing.setTL14T(true);
                    if (Objects.equals(issue, "TL15")) testing.setTL15(true);
                    if (Objects.equals(issue, "TL16")) testing.setTL16(true);
                    if (Objects.equals(issue, "TL17")) testing.setTL17(true);
                    if (Objects.equals(issue, "TL18")) testing.setTL18(true);
                    if (Objects.equals(issue, "TL19")) testing.setTL19(true);
                    if (Objects.equals(issue, "TL19A")) testing.setTL19A(true);
                    if (Objects.equals(issue, "TL21")) testing.setTL21(true);
                    if (Objects.equals(issue, "TL22")) testing.setTL22(true);
                    if (Objects.equals(issue, "TL22T")) testing.setTL22T(true);
                    if (Objects.equals(issue, "TL24")) testing.setTL24(true);
                    if (Objects.equals(issue, "TL26")) testing.setTL26(true);
                    if (Objects.equals(issue, "TL26T")) testing.setTL26T(true);
                    if (Objects.equals(issue, "TL27")) testing.setTL27(true);
                    if (Objects.equals(issue, "TL27T")) testing.setTL27T(true);
                    if (Objects.equals(issue, "TL28")) testing.setTL28(true);
                    if (Objects.equals(issue, "TL28T")) testing.setTL28T(true);
                    if (Objects.equals(issue, "TL29")) testing.setTL29(true);
                    if (Objects.equals(issue, "TL29A")) testing.setTL29A(true);
                    if (Objects.equals(issue, "TL29B")) testing.setTL29B(true);
                    if (Objects.equals(issue, "TL29C")) testing.setTL29C(true);
                    if (Objects.equals(issue, "TL30")) testing.setTL30(true);
                    if (Objects.equals(issue, "TL32")) testing.setTL32(true);
                    if (Objects.equals(issue, "TL36")) testing.setTL36(true);
                    if (Objects.equals(issue, "TL36T")) testing.setTL36T(true);
                    if (Objects.equals(issue, "TL37")) testing.setTL37(true);
                    if (Objects.equals(issue, "TL38")) testing.setTL38(true);
                    if (Objects.equals(issue, "TL39")) testing.setTL39(true);
                    if (Objects.equals(issue, "TL40")) testing.setTL40(true);
                    if (Objects.equals(issue, "TL41")) testing.setTL41(true);
                    if (Objects.equals(issue, "TL42")) testing.setTL42(true);
                    if (Objects.equals(issue, "TL42A")) testing.setTL42A(true);
                }
                testing.setImei(p.getImei());
                testing.setDate(new java.util.Date());
                testing.setOperator(authentication.getName());

                statusService.createStatus(status);
                testingService.createTest(testing);
            }
            tlListIndex = tlListIndex + 1;

            polishService.createPolish(p);
        }
    }
}
