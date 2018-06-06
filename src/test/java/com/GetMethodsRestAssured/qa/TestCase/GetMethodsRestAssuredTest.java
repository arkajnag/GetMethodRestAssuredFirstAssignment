package com.GetMethodsRestAssured.qa.TestCase;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.GetMethodsRestAssured.qa.RestClients.HttpMethodsRestAssured;
import com.GetMethodsRestAssured.qa.TestBase.TestBase;
import com.GetMethodsRestAssured.qa.TestUtil.TestUtil;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class GetMethodsRestAssuredTest extends TestBase{

	public GetMethodsRestAssuredTest()
	{
		super();
	}
	
	String HostingURL;
	String ServiceURL;
	String URI;
	HttpMethodsRestAssured httpRestAssured;
	Response httpGetRestAssuredresponse;
	TestUtil Util;
	
	@BeforeMethod
	public void SetUp()
	{
		HostingURL=prop.getProperty("hostingurl");
		ServiceURL=prop.getProperty("serviceurl");
		URI=HostingURL+ServiceURL;
		httpRestAssured=new HttpMethodsRestAssured();
		httpGetRestAssuredresponse= httpRestAssured.GetMethodsRestAssured(URI);
		System.out.println("Response of GET API Call::"+httpGetRestAssuredresponse);
		Util=new TestUtil();
	}
	@Test(priority=1)
	public void GetStatusResponse()
	{
		int code=httpGetRestAssuredresponse.getStatusCode();
		String StatusLine=httpGetRestAssuredresponse.getStatusLine();
		System.out.println("Status Line of the GET Response API::"+StatusLine);
		Assert.assertEquals(code, 200, "Status Code is Matching");
	}
	
	@Test(priority=2)
	public void GetHeadersResponse()
	{
		Headers headerResponse= httpGetRestAssuredresponse.getHeaders();
		for(Header hearderMap: headerResponse)
		{
			System.out.println("Key:"+hearderMap.getName()+"   & Value:"+hearderMap.getValue());
		}
		
	}
	
	@Test(priority=3)
	public void GetStringResponse()
	{
		String httpGetRestAssuredBodyResponse=httpGetRestAssuredresponse.asString();
		System.out.println("Response Body::"+httpGetRestAssuredBodyResponse);
		JSONObject JSONResponse=new JSONObject(httpGetRestAssuredBodyResponse);
		String Total_Response=Util.getValueByJPath(JSONResponse, "/total");
		Assert.assertEquals(Integer.parseInt(Total_Response), 12, "Total is Matched in Response");
		String ID=Util.getValueByJPath(JSONResponse, "/data[2]/id");
		Assert.assertEquals(Integer.parseInt(ID), 3, "ID Value is present");
	}
}
