package restAssuredFilters;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RequestFilter implements Filter {

    public static final Logger logger = LogManager.getLogger(RequestFilter.class);

    @Override
    public Response filter(FilterableRequestSpecification requestSpec,
                           FilterableResponseSpecification responseSpec,
                           FilterContext context) {

        String originalEndpoint = requestSpec.getBasePath();

        logger.info("Original API Endpoint: " + originalEndpoint);
        logger.info("Modified API Endpoint: " + "/ecom/order/get-orders-for-customer/mubbc34a568c3e9fb1f0fadd");

        String modifiedEndpoint = originalEndpoint.replace
                (originalEndpoint, "/ecom/order/get-orders-for-customer/mubbc34a568c3e9fb1f0fadd");

        requestSpec.basePath(modifiedEndpoint);
        logger.info("API Endpoint modified successfully.");

        return context.next(requestSpec,responseSpec);
    }

}
