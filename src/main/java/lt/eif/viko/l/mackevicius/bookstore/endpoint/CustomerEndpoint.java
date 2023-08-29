package lt.eif.viko.l.mackevicius.bookstore.endpoint;

import lt.eif.viko.l.mackevicius.bookstore.service.ServiceInitialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.schema.web_services.GetCustomerRequest;
import org.springframework.schema.web_services.GetCustomerResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CustomerEndpoint {

    @Autowired
    private ServiceInitialize customerService;

    @PayloadRoot(namespace = "http://www.springframework.org/schema/web-services",
            localPart = "getCustomerRequest")
    @ResponsePayload
    public GetCustomerResponse getCustomerRequest(@RequestPayload GetCustomerRequest request){
        GetCustomerResponse response = new GetCustomerResponse();
        response.setCustomer(customerService.getCustomers(request.getId()));

        return response;
    }

}
