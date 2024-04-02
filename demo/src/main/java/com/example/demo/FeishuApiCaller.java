package com.example.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;

public class FeishuApiCaller {
    private static final String FEISHU_API_URL = "https://open.feishu.cn/open-apis/bitable/v1/apps/XtDhb6jugaGCbKs0XvmcVUT0nqh/tables/tblOYX3gECGLecFt/records?client_token=d576a948-a989-46ce-b549-ceee5ae232a6&user_id_type=open_id";
    private static final String ACCESS_TOKEN = "t-g1043q9aDVLHS5BMFP6DCHMS4I2RWHOHGFTZSUIQ"; // 替换为你的access_token

    public static void main(String[] args) throws Exception {
        String uuid = UUID.randomUUID().toString();
        String postBody = "{\n" +
                "  \"fields\": {\n" +
                "    \"文本\": \"2222\"\n" +
                "  }\n" +
                "}"; // 替换为你的请求体
        HttpURLConnection connection = sendPostRequest(FEISHU_API_URL, postBody);

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            connection.disconnect();

            // 打印API响应
            System.out.println(response.toString());
        } else {
            System.out.println("GET request not worked");
        }
    }

    private static HttpURLConnection sendPostRequest(String urlStr, String postBody) throws Exception {
        URL url = new URL(urlStr);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Authorization", "Bearer " + ACCESS_TOKEN);
        connection.setDoOutput(true);

        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = postBody.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        return connection;
    }
}
