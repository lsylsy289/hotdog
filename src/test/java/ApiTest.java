import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ApiTest {

	@Test(timeout=5000)
	public void httpClient() throws ClientProtocolException, IOException, URISyntaxException, ParseException {

//		String apiBaseUri = "https://openapi.gg.go.kr/HotSpringStatus";
		String apiBaseUri = "https://openapi.naver.com/v1/search/blog.json";

		CloseableHttpClient httpClient = HttpClients.createDefault();

		URIBuilder builder = new URIBuilder(apiBaseUri);

//		builder.addParameter("KEY", "58ce374c6476493894a0dd36d9f6a3a9");
//		builder.addParameter("pIndex", "1");
//		builder.addParameter("Size", "100");
		builder.addParameter("query", "서울시");
		builder.addParameter("display", "3");
		builder.addParameter("start", "1");

		HttpGet httpGet = new HttpGet(builder.build().toString());

//		httpGet.addHeader("User-Agent", "Mozila/5.0");
//		httpGet.addHeader("Content-type", "application/json");
		httpGet.addHeader("X-Naver-Client-Id", "hicXDVYJaKtzUkiJ2BRI");
		httpGet.addHeader("X-Naver-Client-Secret", "XJygSnwus9");

		CloseableHttpResponse httpResponse = httpClient.execute(httpGet);

		System.out.println("::GET Response Status::");
		System.out.println(httpResponse.getStatusLine().getStatusCode());
		String json = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");

		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObj = (JSONObject) jsonParser.parse(json);

//		System.out.println(jsonObj.get("HotSpringStatus"));

//		System.out.println(json);

//		BufferedReader reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
//
//		String inputLine;
//		StringBuffer response = new StringBuffer();
//
//		while ( (inputLine = reader.readLine()) != null) {
//
//			response.append(inputLine);
//		}
//
//		reader.close();
		httpClient.close();
//
//		System.out.println(response.toString());
	}

	@Test(timeout=5000)
	public void restTemplate() throws URISyntaxException {

		URI url = new URI("https://openapi.naver.com/v1/search/blog.json?query=서울&display=5&start=1");

		HttpHeaders headers = new HttpHeaders();

		headers.set("X-Naver-Client-Id", "hicXDVYJaKtzUkiJ2BRI");
		headers.set("X-Naver-Client-Secret", "XJygSnwus9");

		ResponseEntity<String> response = new RestTemplate().exchange(url, HttpMethod.GET, new HttpEntity<String>(headers), String.class);

		System.out.println(response);
	}
}
