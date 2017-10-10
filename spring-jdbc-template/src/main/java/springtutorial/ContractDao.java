package springtutorial;

import java.util.List;

public interface ContractDao
{
    Contract getContract(int pId);

    List<Contract> getAllContracts();

    void suspendContract(int pId);
}
