package com.itheima.Interface;

import com.itheima.entity.Game;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GameMapper {

    // 查询所有游戏
    @Select("SELECT * FROM game")
    List<Game> findAllGames();

    // 根据游戏名模糊查询
    @Select("SELECT * FROM game WHERE name LIKE CONCAT('%', #{name}, '%')")
    List<Game> findGamesByName(@Param("name") String name);

    // 根据 ID 查询游戏详情
    @Select("SELECT * FROM game WHERE id = #{id}")
    Game findGameById(@Param("id") Integer id);
}
