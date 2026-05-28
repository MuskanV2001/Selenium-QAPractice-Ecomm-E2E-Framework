package restAssuredFilters;

import io.restassured.builder.ResponseBuilder;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class ResponseFilter implements Filter {

    public Response filter(FilterableRequestSpecification requestSpec,
                           FilterableResponseSpecification responseSpec,
                           FilterContext context){

        Response originalResponse = context.next(requestSpec, responseSpec);
        System.out.println("\n--- ORIGINAL RESPONSE ---");
        System.out.println("Status Code: " + originalResponse.getStatusCode());
        System.out.println("Body: " + originalResponse.getBody().asString());

        String modifiedBody = """
                {
                    "data" : [],
                    "message" : "No Orders"
                }
                """;

        ResponseBuilder modifiedResponse = new ResponseBuilder();
        modifiedResponse.clone(originalResponse);
        modifiedResponse.setBody(modifiedBody);

        return modifiedResponse.build();
    }

}