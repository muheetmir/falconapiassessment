package com.falcon.api.get.testscripts.employeeservice;

import static com.jayway.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.falcon.api.testsuite.TestSuiteBase;
import com.falcon.api.utility.EmployeeServiceHelper;
import com.falcon.api.utility.STATUS_CODE;
import com.falcon.api.utility.Util;
import com.jayway.restassured.http.ContentType;

import com.jayway.restassured.response.Response;

public class GetEmployeeWithID extends TestSuiteBase {
	Map<String, String> headers = new HashMap<>();
	String url = null;
	

	@SuppressWarnings("unused")
	@Test
	public void GetEmployeeWithValidID() throws Exception {
		
		report = extent.createTest("GetEmployeeWithID", "Employee-Service");
		report.info("Verify to Get Employee with id");
		url = Util.buildURI(config.getString("getEmployeeById"));
		report.info("INFO:Get the added Employee");
		Response response = given()
		.headers(headers)
		.contentType(ContentType.JSON)
		.pathParam("id", testdata.getString("id"))
		.get(url)
		.andReturn();
		report.info("Status code:" + response.getStatusCode());
		report.info("Verify the status code:" + response.statusCode());
		assertEquals(response.getStatusCode(), STATUS_CODE.STATUS_200.getValue(),
		"ERROR: Status Code Validation Failed.");
		if (response.getStatusCode() == STATUS_CODE.STATUS_200.getValue()) {
		report.log(Status.INFO, "Status Code Validated Sucessfully as :" + response.getStatusCode());
		} else {
		report.log(Status.ERROR, "Status Code Validation Failed :" + response.getStatusCode());
		}

	
	}

}
