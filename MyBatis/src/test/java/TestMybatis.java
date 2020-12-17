import com.yicen.myBatis.entity.Goods;
import com.yicen.myBatisUtils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class TestMybatis {

    @Test
    public void test(){
        SqlSession session = null;
        try {
          session =  MyBatisUtils.getSqlSession();
            System.out.println(session);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MyBatisUtils.closeSession(session);
        }
    }

    @Test
    public void testSelectAll() throws Exception{
        SqlSession session = null;
        try {
            session = MyBatisUtils.getSqlSession();
            List<Goods> list = session.selectList("goods.selectAll");
            for (Goods d: list){
                System.out.println(d.getTitle());
            }
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }finally {
            MyBatisUtils.closeSession(session);
        }
    }
}
