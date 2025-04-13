package com.itheima.controller;

import com.itheima.entity.Game;
import com.itheima.Interface.GameMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
public class GameController {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    // 当访问 "/games" 路径时，调用此方法
    @RequestMapping("/games")
    public String showGames(Model model) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            GameMapper mapper = session.getMapper(GameMapper.class);
            List<Game> games = mapper.findAllGames();
            // 将查询结果放入模型，用于 JSP 展示
            model.addAttribute("games", games);
        }
        return "games";  // 返回的视图名称对应 /WEB-INF/jsp/games.jsp 页面
    }
}
