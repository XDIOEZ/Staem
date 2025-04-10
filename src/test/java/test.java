import Interface.GameMapper;
import com.itheima.Game;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class test {

    @Test
    public void testFindAllGames() throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlMapper.openSession();

        try {
            GameMapper gameMapper = session.getMapper(GameMapper.class);
            List<Game> games = gameMapper.findAllGames();
            games.forEach(System.out::println);  // 简洁输出，每个对象调用 toString()
        } finally {
            session.close();
        }
    }
}
