/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBConnection;


import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.Connection;

/**
 *
 * @author Nong_Tien_Son
 */
public class DatabaseConnection {
   
    public static Connection getConnection() {
        SQLServerDataSource dataSource = new SQLServerDataSource();

        dataSource.setUser("sa");
        dataSource.setDatabaseName("SD18312_TEAM_6");
        dataSource.setPassword("Ok1234@4321");//Đổi mật khẩu ở đây nếu cần
        dataSource.setPortNumber(1433);//Nếu kết nỗi lỗi có thể do cổng 1433 đóng
        dataSource.setEncrypt(false);
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    
    
    //Chạy thử main ở dưới để biết đã kết nối SQL thành 
    //công hay chưa nếu chưa thì hãy thử đổi mật khẩu SQL Server
    
    
    
//    public static void main(String[] args) {
//        System.out.println(getconConnection());
//        if(!getconConnection().equals("")){
//            System.out.println("Ket noi SQL Server thanh cong rui nha Baby !");
//        }
//    }
    
    
    
}
