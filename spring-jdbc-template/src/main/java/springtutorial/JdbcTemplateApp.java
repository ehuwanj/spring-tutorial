package springtutorial;

import java.util.Map;
import java.util.logging.Logger;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateApp 
{
    private static Logger _logger = Logger.getLogger(JdbcTemplateApp.class.getName());

    public static void main(String[] args)
    {
       // testDatabaseManager();
        
        testJdbcTemplate();

    }

    public static void testDatabaseManager()
    {
        DatabaseManager databaseManager = new DatabaseManager();
        databaseManager.queryCarPrice("Audi");
    }
    
    public static void testJdbcTemplate()
    {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("/application-context.xml");
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
        String sql = "SELECT * FROM CONTRACTS WHERE ID=" + 1;
        _logger.info(sql);
        Map<String, Object> result = jdbcTemplate.queryForList(sql).get(0);
        _logger.info(result.toString());
        context.close();
    }
}
  