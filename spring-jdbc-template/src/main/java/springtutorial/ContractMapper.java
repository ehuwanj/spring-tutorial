package springtutorial;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ContractMapper implements RowMapper<Contract> 
{
    @Override
    public Contract mapRow(ResultSet pResultSet, int pRowNum) throws SQLException
    {
        Contract contract = new Contract();
        contract.setId(pResultSet.getInt("id"));
        contract.setCode(pResultSet.getString("code"));
        contract.setStatus(pResultSet.getString("status"));
        return contract;
    }
}
