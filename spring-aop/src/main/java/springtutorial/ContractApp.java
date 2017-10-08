package springtutorial;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContractApp
{
    public static void main(String[] args)
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/application-context.xml");
        
        Contract contract = ctx.getBean("contractProxy", Contract.class);

        contract.activate();
    }

}
