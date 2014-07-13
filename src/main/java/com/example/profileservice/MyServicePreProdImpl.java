package com.example.profileservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("preprod")
public class MyServicePreProdImpl implements MyService {

    private final Logger LOG = LoggerFactory.getLogger(MyServicePreProdImpl.class);

    @Override
    public void doSomething() {
        LOG.debug("Doing something in " + MyServicePreProdImpl.class.getName());
    }

}
