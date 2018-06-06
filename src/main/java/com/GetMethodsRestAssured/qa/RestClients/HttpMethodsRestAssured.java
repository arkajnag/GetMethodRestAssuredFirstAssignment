package com.GetMethodsRestAssured.qa.RestClients;

import com.GetMethodsRestAssured.qa.TestBase.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class HttpMethodsRestAssured extends TestBase{

	public Response GetMethodsRestAssured(String URI)
	{
		Response httpresponse=RestAssured.get(URI);
		return httpresponse;
	}
	
}
