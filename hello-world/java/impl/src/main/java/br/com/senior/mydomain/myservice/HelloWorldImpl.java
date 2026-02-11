package br.com.senior.mydomain.myservice;

import br.com.senior.messaging.ErrorCategory;
import br.com.senior.messaging.model.HandlerImpl;
import br.com.senior.messaging.model.ServiceException;

@HandlerImpl
public class HelloWorldImpl implements HelloWorld {

    @Override
    public HelloWorldOutput helloWorld(HelloWorldInput request) {

        if (request == null) {
            throw new ServiceException(ErrorCategory.BAD_REQUEST,"request is null");
        }

        HelloWorldOutput ret = new HelloWorldOutput();
        ret.helloWorldMessage = String.format("Hello World, %s!", request.who);
        return ret;
    }
}
