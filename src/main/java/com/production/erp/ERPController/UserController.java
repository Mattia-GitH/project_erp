package com.production.erp.ERPController;

import com.production.erp.model.UserModel;
import com.production.erp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping("/users")
    public String userList(Model model) {
        List<UserModel> listUsers = userService.listUsers();
        model.addAttribute("listUsers", listUsers);

        return "ERP/user/home";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping("/create")
    public String addUser(Model model) {
        UserModel user = new UserModel();
        model.addAttribute("user", user);

        return "ERP/user/newUser";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") UserModel user) {
        userService.createUser(user);

        return "redirect:/";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping("/edit/{username}")
    public String editUser(Model model, @PathVariable(name = "username") String username) {
        UserModel user = userService.userByUsername(username);
        user.setPassword(null);
        model.addAttribute("user", user);

        return "ERP/user/editUser";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/update/{username}", method = RequestMethod.POST)
    public String updateUser(@PathVariable(name = "username") String username, @ModelAttribute("user") UserModel user) {
        userService.updateUser(user, username);

        return "redirect:/";
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/change_password/{username}", method = RequestMethod.POST)
    public String updatePassword(@PathVariable(name = "username") String username, @ModelAttribute("user") UserModel user) {
        user.setRoles(userService.userByUsername(username).getRoles());
        userService.updateUser(user, username);

        return "redirect:/";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/delete/{username}", method = RequestMethod.GET)
    public String delete(@PathVariable String username) {
        userService.delete(username);

        return "redirect:/";
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping("/change_password")
    public String changePassword(Model model) {
        model.addAttribute("user", new UserModel());

        return "ERP/user/changePassword";
    }

    @GetMapping("/login")
    public String login() {
        return "ERP/user/login";
    }
}
