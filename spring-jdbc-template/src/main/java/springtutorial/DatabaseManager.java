package springtutorial;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DatabaseManager {

    private static String INITIALIZE_URL = "jdbc:derby:testdb;create=true";
    private static String SHUTDOWN_URL = "jdbc:derby:;shutdown=true";
    private static String DB_TABLE = "CARS";

    Logger _logger = Logger.getLogger(DatabaseManager.class.getName());

    private Connection _connection;
    
    public DatabaseManager()
    {
        _connection = initialzeConection();
        try {
            DatabaseMetaData metaData = _connection.getMetaData();
            ResultSet rs = metaData.getTables(null, null, DB_TABLE, null);
            if(!rs.next())
            {
                InitializeDatabaseTable();
            }
        }
        catch (SQLException e) 
        {
            e.printStackTrace();
        }

    }
    private Connection initialzeConection()
    {
        Connection connection = null;
        try 
        {
            connection = DriverManager.getConnection(INITIALIZE_URL);
            _logger.log(Level.INFO, "Successfully connect to the Derby database...");

        }catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return connection;
    }

    public void InitializeDatabaseTable()
    {
        try (Statement st = _connection.createStatement();)
        {
            st.executeUpdate("CREATE TABLE CARS(ID INT PRIMARY KEY, NAME VARCHAR(30), PRICE INT)");
            st.executeUpdate("INSERT INTO CARS VALUES(1, 'Audi', 52642)");
            st.executeUpdate("INSERT INTO CARS VALUES(2, 'Mercedes', 57127)");
            st.executeUpdate("INSERT INTO CARS VALUES(3, 'Skoda', 9000)");
            st.executeUpdate("INSERT INTO CARS VALUES(4, 'Volvo', 29000)");
            st.executeUpdate("INSERT INTO CARS VALUES(5, 'Bentley', 350000)");
            st.executeUpdate("INSERT INTO CARS VALUES(6, 'Citroen', 21000)");
            st.executeUpdate("INSERT INTO CARS VALUES(7, 'Hummer', 41400)");
            st.executeUpdate("INSERT INTO CARS VALUES(8, 'Volkswagen', 21600)");

        } catch (SQLException e)
        {
            e.printStackTrace();
        } 
    }

    public void close()
    {
        try 
        {
            DriverManager.getConnection(SHUTDOWN_URL);
        } 
        catch (SQLException e) 
        {
            if (((e.getErrorCode() == 50000) && ("XJ015".equals(e.getSQLState()))))
            {
                _logger.log(Level.INFO, "Derby shut down normally", e);
            }
            else 
            {
                _logger.log(Level.SEVERE, e.getMessage(), e);
            }
        }
    }
    
    public void queryCarPrice(String pName)
    {
        String sql = "SELECT * FROM CARS WHERE NAME=\'" + pName + "\'";
        _logger.info(sql);
        try(PreparedStatement st = _connection.prepareStatement(sql);)
        {
            ResultSet resultSet = st.executeQuery();
            while(resultSet.next())
            {
                _logger.info(resultSet.getString("name") + " price is: " + resultSet.getString("price"));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        } 
    }
}