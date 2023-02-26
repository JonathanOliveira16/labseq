package io.github.jonathan.sequence.rest;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;


@QuarkusTest
@TestHTTPEndpoint(LabseqResource.class)
class LabseqResourceTest {



    @Test
    @DisplayName("Should return 400 when try to send a negative number to endpoint")
    public void whenSendANegativeNumber(){
        var negativeNumber = -1;
        given().pathParam("n", negativeNumber).when().get().then().statusCode(Response.Status.BAD_REQUEST.getStatusCode());
    }

    @Test
    @DisplayName("Should return the correct sequence number from labseq rule")
    public void whenSendAPositiveNumber(){
        var positiveNumber = 9;
        given().pathParam("n", positiveNumber).when().get().then().statusCode(Response.Status.OK.getStatusCode()).body(Matchers.is("2"));
    }
}