package springtutorial;

public class Contract
{
    private int _id;
    private String _code;
    private String _status;

    public int getId()
    {
        return _id;
    }
    public String getCode()
    {
        return _code;
    }
    public String getStatus()
    {
        return _status;
    }
    public void setId(int pId)
    {
        _id = pId;
    }
    public void setCode(String pCode)
    {
        _code = pCode;
    }
    public void setStatus(String pStatus)
    {
        _status = pStatus;
    }
    @Override
    public String toString()
    {
        return "Contract [_id=" + _id + ", _code=" + _code + ", _status=" + _status + "]";
    }
    
    

}
