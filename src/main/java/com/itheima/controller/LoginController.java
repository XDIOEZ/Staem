package com.itheima.controller;

import com.itheima.service.UserService;
import com.itheima.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/login",method= RequestMethod.POST)
    public String login(User user, HttpServletRequest request) {
        try {
            // 1. 打印用户输入的参数（如用户名和密码）
            System.out.println("接收到用户登录请求，用户名：" + user.getUsername() + "，密码：" + user.getPassword());

            // 2. 调用服务层方法前打印
            System.out.println("调用 userService.login(user)");
            User u = userService.login(user);

            // 3. 判断登录结果
            if (u != null) {
                System.out.println("登录成功，用户ID：" + u.getId() + "，用户名：" + u.getUsername());
                request.getSession().setAttribute("USER_SESSION", u);
                return "redirect:/jsp/main.jsp";
            } else {
                System.out.println("登录失败，用户不存在或密码错误");
                request.setAttribute("msg", "用户名或密码错误");
                return "forward:/login.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("登录过程中发生异常：" + e.getMessage());
            request.setAttribute("msg", "系统错误");
            return "forward:/login.jsp";
        }
    }
}
