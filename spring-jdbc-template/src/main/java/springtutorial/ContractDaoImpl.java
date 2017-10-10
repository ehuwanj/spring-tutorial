package springtutorial;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component("ContractDao")
public class ContractDaoImpl implements ContractDao{

    private JdbcTemplate _jdbcTemplate;

    @Resource
    public void setJdbcTemplate(JdbcTemplate pJdbcTemplate)
    {
        _jdbcTemplate = pJdbcTemplate;
    }

    public Contract getContract(int pId)
    {
        String sql = "SELECT * FROM contracts WHERE id=" + 1;
        return  _jdbcTemplate.queryForObject(sql, new ContractMapper());
    }

    public List<Contract> getAllContracts()
    {
        String sql = "SELECT * FROM contracts";
        return  _jdbcTemplate.query(sql, new ContractMapper());
    }
    
    public void suspendContract(int pId)
    {
        String sql = "UPDATE contracts SET status='suspended' WHERE id=" + 1;
        _jdbcTemplate.update(sql);
    }
}
