import com.yicen.myBatis.dto.CategoryDTO;
import com.yicen.myBatis.entity.Goods;
import com.yicen.myBatisUtils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    @Test
    public void testSelectById() throws Exception{
        SqlSession session = null;
        try {
            session = MyBatisUtils.getSqlSession();
            Goods goods = session.selectOne("goods.selectById",1234);
            System.out.println(goods.getTitle());
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }finally {
            MyBatisUtils.closeSession(session);
        }
    }

    @Test
    public void testSearchPriceByRange() throws Exception{
        SqlSession session = null;
        try {
            session = MyBatisUtils.getSqlSession();
            Map map = new HashMap();
            map.put("min",100);
            map.put("max",1000);
            map.put("limit",10);
            List<Goods> goods = session.selectList("goods.searchPriceByRange", map);
            for (Goods g:goods){
                System.out.println(g.getTitle());
            }
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }finally {
            MyBatisUtils.closeSession(session);
        }
    }

    @Test
    public void testSelectGoodsMap(){
        SqlSession session = null;
        try {
            session = MyBatisUtils.getSqlSession();
            List<Map> maps = session.selectList("goods.selectGoodsMap");
            for (Map g:maps){
                System.out.println(g);
            }
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }finally {
            MyBatisUtils.closeSession(session);
        }
    }

    @Test
    public void testSelectGoodsDTO(){

        SqlSession session = null;
        try {
            session = MyBatisUtils.getSqlSession();
            List<CategoryDTO> maps = session.selectList("goods.selectGoodsDTO");
            for (CategoryDTO c:maps){
                System.out.println(c.getGoods().getTitle() +":"+ c.getCategory().getCategoryName());

            }
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }finally {
            MyBatisUtils.closeSession(session);
        }
    }

    @Test
    public void testInsert(){
        SqlSession session = null;
        try {
            session = MyBatisUtils.getSqlSession();
            Goods goods = new Goods();
            goods.setTitle("测试1");
            goods.setSubTitle("测试商品1");
            goods.setCategoryId("45");
            goods.setIsFreeDelivery(1);
            goods.setOriginalCost(Float.valueOf(1000));
            goods.setCurrentPrice(Float.valueOf(100));
            goods.setDiscount(goods.getCurrentPrice()/goods.getOriginalCost());
            int count = session.insert("goods.insertGoods",goods);
            System.out.println(goods.getGoodsId());
            session.commit();
        }catch (Exception e){
            if (session != null){
                session.rollback();
            }
            e.printStackTrace();
            throw e;
        }finally {
            MyBatisUtils.closeSession(session);
        }
    }
}
