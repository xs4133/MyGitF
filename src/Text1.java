import java.sql.*;

/**
 * Created by Administrator on 2018/5/8.
 */
public class Text1
{
    public static void main(String[] args)
    {
        //1加载数据库驱动到内存
        Connection conn=null;
        PreparedStatement ps=null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            //2获取数据库连接
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/neuedu", "root", "root");
            System.out.println(conn);
            //3创建preparedstatement
            ps=conn.prepareStatement("insert into sorder VALUES (null,?,?,?,?,?,?,?,?)");
            //替换？，执行sql语句
            ps.setInt(1,1);
            ps.setString(2,"opending");
            ps.setDouble(3,10000.55);
            ps.setString(4,null);
            ps.setDouble(5,8000.55);
            ps.setString(6,"a");
            // java.sql.date:年月日没有时分秒 ,java.util.date()：年月日有时分秒
            //时间原点：1970-1-1 0:0:0
            //currentTimeMillis()
            Timestamp now=new Timestamp(System.currentTimeMillis());
            ps.setTimestamp(7,now);
            ps.setInt(8,1);

            //执行sql语句
            int s=ps.executeUpdate();
            if(s>0){
                System.out.println("执行成功");
            }else{
                System.out.println("执行失败");
            }

            //关闭连接



        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }finally
        {
            try
            {
                ps.close();
                conn.close();
            } catch (SQLException e)
            {
                e.printStackTrace();
            }

        }


    }
}
