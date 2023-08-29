package lt.eif.viko.l.mackevicius.bookstore.endpoint;

import lt.eif.viko.l.mackevicius.bookstore.service.ServiceInitialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.schema.web_services.GetAllBookRequest;
import org.springframework.schema.web_services.GetAllBookResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class BookEndpoint {

    @Autowired
    private ServiceInitialize bookService;

    @PayloadRoot(namespace = "http://www.springframework.org/schema/web-services",
    localPart = "getAllBookRequest")
    @ResponsePayload
    public GetAllBookResponse getAllBooks(@RequestPayload GetAllBookRequest request){
        GetAllBookResponse response = new GetAllBookResponse();
        response.getAllBooks().addAll(bookService.getAllBooks());

        return response;
    }
}
