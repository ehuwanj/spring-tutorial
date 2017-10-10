package springtutorial;

import java.util.logging.Logger;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        ContractDao contractDao = context.getBean(ContractDao.class);
        Contract contract = contractDao.getContract(1);
        _logger.info(contract.toString());
        
        contractDao.suspendContract(1);
        
        contract = contractDao.getContract(1);
        _logger.info(contract.toString());
        context.close();
    }
}
  