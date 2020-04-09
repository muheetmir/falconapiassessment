package com.falcon.api.get.testscripts.employeeservice;

import static com.jayway.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.falcon.api.testsuite.TestSuiteBase;
import com.falcon.api.utility.STATUS_CODE;
import com.falcon.api.utility.Util;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class GetAllEmployees extends TestSuiteBase {
	
	Map<String, String> headers = new HashMap<>();
	String url = null;
	
	@Test
	public void getAllEmployees(){
	report = extent.createTest("GetEmployees", "Employee-Service");
	report.info("Verify to Get all Employees");
	url = Util.buildURI(config.getString("getListOfEmployees"));
	//report.info("INFO:Get the added Employee");
	System.out.println(url);
	Response response = given()
	.headers(headers)
	.contentType(ContentType.JSON)
	.get(url)
	.andReturn();
	System.out.println("Status code:"+response.getStatusCode());
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
