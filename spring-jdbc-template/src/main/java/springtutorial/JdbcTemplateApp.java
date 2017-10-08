package springtutorial;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcTemplateApp 
{

    public static void main(String[] args)
    {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("/application-context.xml");
        DatabaseManager databaseManager = context.getBean(DatabaseManager.class);

        
        context.close();
    }

}
  