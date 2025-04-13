import com.itheima.Interface.GameMapper;
import com.itheima.Interface.UserMapper;
import com.itheima.entity.Game;
import com.itheima.entity.User;
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
    public void testFindAllGames() throws IOException
    {

        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");

        SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);

        SqlSession session = sqlMapper.openSession();

        try {

            GameMapper gameMapper = session.getMapper(GameMapper.class);

            UserMapper userMapper = session.getMapper(UserMapper.class);

            User _user = new User();

            _user.setUsername("Ikun");

            _user =  userMapper.login(_user);

            System.out.println(_user.toString());

            List<Game> games = gameMapper.findAllGames();

            games.forEach(System.out::println);  // 简洁输出，每个对象调用 toString()

        }
        finally
        {
            session.close();
        }
    }
}
