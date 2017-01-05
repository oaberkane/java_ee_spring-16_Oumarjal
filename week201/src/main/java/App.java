
import java.sql.Connection;
import java.sql.SQLException;
import org.sqlite.*;
import org.sqlite.SQLiteDataSource;


 import java.sql.ResultSet;
    import java.sql.SQLException;
    import javax.swing.JOptionPane;
    import org.sqlite.SQLiteDataSource;
    import org.sqlite.SQLiteJDBCLoader;
    import org.sqlite.*;


    public class App {


        public static void main(String[] args) throws Exception{

            boolean initialize = SQLiteJDBCLoader.initialize();

            SQLiteDataSource dataSource = new SQLiteDataSource();
            dataSource.setUrl("jdbc:sqlite:data.db");
            int i=0;
            try {
                ResultSet executeQuery = dataSource.getConnection()
                        .createStatement().executeQuery("select * from \"user\"");
                while (executeQuery.next()) {
                    i++;
                    System.out.println("out: "+executeQuery.getMetaData().getColumnLabel(i));

                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }

        }  
        
        
     }      
       


