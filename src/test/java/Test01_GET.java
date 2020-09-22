import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

import  io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Test01_GET {

	@Test
	void test_01()
	{
		Response response = get("https://reqres.in/api/users?page=2");
		System.out.println(response.prettyPrint());
		System.out.println("Response as String[prettyPeek] : "+response.prettyPeek().asString());
		System.out.println("Response as Server : "+response.getHeader("Server"));
		System.out.println("Response Body : "+response.getBody().asString());
		System.out.println("Response as String : "+response.asString());
		System.out.println("Response Status code : "+response.getStatusCode());
		System.out.println("Response Status Line : "+response.getStatusLine());
		System.out.println("Response Header : "+response.getHeader("content-type"));
		System.out.println("Response get Time : "+response.getTime());


		int status_code = response.getStatusCode();
		Assert.assertEquals(status_code, 200);
	}
	@Test
	void test_02()
	{
		given().
			get("https://reqres.in/api/users?page=2").
		then()
			.statusCode(200)
			.body("data.id[0]",equalTo(7));

	}
	@Test
	void test_03()
	{
		given().
			get("https://reqres.in/api/users?page=2").
		then()
			.statusCode(200)
			.body("data.email[0]",equalTo("michael.lawson@reqres.in"));

	}
	@Test
	void test_04()
	{
		given().
			get("https://reqres.in/api/users?page=2").
		then()
			.statusCode(200)
			.body("data.avatar[0]",equalTo("https://s3.amazonaws.com/uifaces/faces/twitter/follettkyle/128.jpg"));

	}
}
