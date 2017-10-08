package springtutorial;

public class ContractManager {

    /**
     * Must specify the javaagent when running this class, e.g. 
     * -javaagent:~/.m2/repository/org/aspectj/aspectjweaver/1.8.11/aspectjweaver-1.8.11.jar
     */
    public static void main(String[] args)
    {
        Contract contract = new Contract();

        contract.activate();
    }

}
