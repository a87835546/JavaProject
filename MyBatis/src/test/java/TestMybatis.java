import com.yicen.myBatisUtils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class TestMybatis {

    @Test
    public void test(){
        SqlSession session = MyBatisUtils.getSqlSession();
        session.insert("");
    }
}
