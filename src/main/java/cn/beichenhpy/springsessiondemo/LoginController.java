package cn.beichenhpy.springsessiondemo;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {



    @PostMapping("/login")
    public void login(HttpServletRequest request) {
        request.getSession().setAttribute("IS_LOGIN", true);
    }


    @GetMapping("/check")
    public Object check(HttpServletRequest request) {
        return request.getSession().getAttribute("IS_LOGIN");
    }
}
