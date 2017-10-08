package springtutorial;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

public class Contract 
{
    final Logger _logger = LoggerFactory.getLogger(Contract.class);

    public void activate()
    {
        _logger.info("contract is activated!");
    }
}
