package com.falcon.api.delete.testscripts.employeeservice;

import static com.jayway.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.falcon.api.testsuite.TestSuiteBase;
import com.falcon.api.utility.STATUS_CODE;
import com.falcon.api.utility.Util;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;


public class DeleteEmployee extends TestSuiteBase {
	Map<String, String> headers = new HashMap<>();
	String url = null;

	@Test
	public void deleteEmployeeWithValidData()	throws Exception {
				
				report = extent.createTest("Delete Employee By Id", "Employee-Service");
				report.info("Verify to Delete Employee with id");
				url = Util.buildURI(config.getString("deleteEmployee"));
				System.out.println(url);
				Response resp = given()
				.headers(headers)
				.contentType(ContentType.JSON)
				.pathParam("id", testdata.getString("id"))
				.delete(url)
				.andReturn();
				System.out.println("Status code:" + resp.getStatusCode());
		
	}

	
}
