package lt.eif.viko.l.mackevicius.bookstore.endpoint;

import lt.eif.viko.l.mackevicius.bookstore.service.ServiceInitialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.schema.web_services.GetBookOrderRequest;
import org.springframework.schema.web_services.GetBookOrderResponse;

@Endpoint
public class BookOrderEndpoint {

    @Autowired
    private ServiceInitialize bookOrderService;

    @PayloadRoot(namespace = "http://www.springframework.org/schema/web-services",
    localPart = "getBookOrderRequest")
    @ResponsePayload
    public GetBookOrderResponse getBookOrderRequest(@RequestPayload GetBookOrderRequest request){
        GetBookOrderResponse response = new GetBookOrderResponse();
        response.setOrder(bookOrderService.getOrders(request.getId()));

        return response;
    }
}
