package team1.dataCrawling;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class KakaoDataCrawling {
	
	/**
	 * REST API로 통신하여 받은 JSON형태의 데이터를 String으로 받아오는 메소드
	 */
	private static String getJSONData(String apiUrl) throws Exception {
		HttpURLConnection conn = null;
		StringBuffer response = new StringBuffer();

		// 인증키 - KakaoAK하고 한 칸 띄워주셔야해요!
		String auth = "KakaoAK " + "인증키";

		// URL 설정
		URL url = new URL(apiUrl);

		conn = (HttpURLConnection) url.openConnection();

		// Request 형식 설정
		conn.setRequestMethod("GET");
		conn.setRequestProperty("X-Requested-With", "curl");
		conn.setRequestProperty("Authorization", auth);

		// request에 JSON data 준비
		conn.setDoOutput(true);

		// 보내고 결과값 받기
		int responseCode = conn.getResponseCode();
		if (responseCode == 400) {
			System.out.println("400:: 해당 명령을 실행할 수 없음");
		} else if (responseCode == 401) {
			System.out.println("401:: Authorization가 잘못됨");
		} else if (responseCode == 500) {
			System.out.println("500:: 서버 에러, 문의 필요");
		} else { // 성공 후 응답 JSON 데이터받기

			Charset charset = Charset.forName("UTF-8");
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), charset));

			String inputLine;
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
		}

		return response.toString();
	}

	/**
	 * usage 주석내의 변수값 조정(검색갯수, 검색 키워드) 실행 결과의 포매터 결과 콘솔에 찍힌 내용을 그대로 소스코드에 붙여넣기 의존
	 * 라이브러리 gson 2.8.9이상
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// 검색 갯수
		int size = 10;

		// 검색 키워드
		String keyword = "문학동네";

		String result = getJSONData(String.format("https://dapi.kakao.com/v3/search/book?query=%s&size=%d",
				URLEncoder.encode(keyword, "utf-8"), size));
		Gson gson = new Gson();
		Map<String, ?> map = gson.fromJson(result, Map.class);

		((List<?>) (map.get("documents"))).forEach(o -> {
			if (o instanceof Map) {
				Map<String, ?> m = (Map<String, ?>) o;

				// 제목
				String title = m.get("title").toString();

				// 내용 (길이가 좀있음)
				String contents = m.get("contents").toString();

				// isbn 문자열 자름(공백까지)
				String isbn = m.get("isbn").toString();
				isbn = isbn.substring(0, isbn.indexOf(" "));

				// 출판사
				String publisher = m.get("publisher").toString();

				// 가격정보 double to int
				int price = (int) Double.parseDouble(m.get("price").toString());

				// 저자 문자열 배열 생성
				String authors = m.get("authors").toString();
				authors = authors.replace("[", "").replace("]", "");
				String[] at = authors.split(",");
				for (int i = 0; i < at.length; i++) {
					at[i] = "\"" + at[i] + "\"";
				}
				authors = "new String[] {" + String.join(",", at) + "}";

				String format = String.format("new Book(\"%s\", \"%s\", %s, \"%s\", \"%s\", %d);", title, contents,
						authors, publisher, isbn, price);
				System.out.println(format);
			}

		});
	}
}
