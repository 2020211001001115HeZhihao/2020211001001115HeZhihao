package week4;
import java.sql.*;
public class JDBCtext {
    public static void main(String[] a) throws SQLException,ClassNotFoundException{
        String URL = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String Cons = "jdbc:sqlserver://localhost;databaseName = Takeaway_Ordering_System";
        String root = "sa";
        String pas = "123";
        try{
            Class.forName(URL);
            System.out.println("jzqdcg");
            Connection con = DriverManager.getConnection(Cons,root,pas);
            System.out.println(con);
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("失败哈哈哈");
        }
    }
}
