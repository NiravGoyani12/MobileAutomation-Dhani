package com.dhaniMobile.utilities;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ApiHelpers {

    // TODO: as it depends on a VPN connection, clarify if we can use it for automated tests
    public String getOTPNumber() {
        Response response = given()
                .when()
                .get(""); // TODO: add the URL

        response.then().statusCode(200);

        String otp = response.then().extract().path("");
        System.out.println("OTP: " + otp);
        assertThat(otp, not(isEmptyString()));

        return otp;
    }
}
