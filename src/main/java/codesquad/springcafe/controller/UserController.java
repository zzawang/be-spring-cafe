package codesquad.springcafe.controller;

import codesquad.springcafe.dto.User;
import codesquad.springcafe.service.UserService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/join")
    public String joinForm() {
        return "user/join";
    }

    @PostMapping("/join")
    public String join(@ModelAttribute User user) {
        userService.addUser(user);
        logger.info("[사용자 생성 완료] - " + user.toString());
        return "redirect:/users/list";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "user/login";
    }

    @PostMapping("/login")
    public String login() {
        // TODO: login 기능
        return null;
    }

    @GetMapping("/list")
    public String listForm(Model model) {
        List<User> users = userService.findAllUser();
        model.addAttribute("userListSize", users.size());
        model.addAttribute("userList", users);
        return "user/list";
    }

    @GetMapping("/profile/{userId}")
    public String profileForm(Model model, @PathVariable String userId) throws Exception {
        User user = userService.findUserByUserId(userId);
        logger.info("[사용자 가져오기 성공] - " + user.toString());
        model.addAttribute("user", user);
        return "user/profile";
    }
}