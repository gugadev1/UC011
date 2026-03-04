
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */
public class conectaDAO {
    
    public Connection connectDB(){
        Connection conn = null;
        
        try {
            String dbUser = System.getenv().getOrDefault("DB_USER", "leiloes");
            String dbPassword = System.getenv().getOrDefault("DB_PASSWORD", "123456");
            String dbName = System.getenv().getOrDefault("DB_NAME", "locale");
            String url = "jdbc:mysql://localhost:3306/" + dbName + "?connectTimeout=5000&socketTimeout=5000&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

            conn = DriverManager.getConnection(url, dbUser, dbPassword);
            
        } catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ConectaDAO" + erro.getMessage());
        }
        return conn;
    }
    
}
