package com.ssm.utils;

import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author quandaoran
 * @date 2021/7/26 9:14 上午
 * @describe com.naruto.common.OkhttpUtils
 **/
@Slf4j
@Component
public class OkhttpUtil {

    private static final MediaType JSON_TYPE = MediaType.parse("application/json; charset=utf-8");
    private static OkHttpClient okHttpClient;



    public static String post(String url, String body, Headers headers) {
        RequestBody requestBody = RequestBody.create(body, JSON_TYPE);
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .headers(headers)
                .build();
        return doRequest(request);
    }


    private Headers buildHeader(String key, String value) {
        return new Headers.Builder().add(key, value).build();
    }

    private static String doRequest(Request request) {
        Response response = null;
        try {
            response = okHttpClient.newCall(request).execute();
            if (response.isSuccessful()) {
                return Objects.requireNonNull(response.body()).string();
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            if (response != null) {
                response.close();
            }
        }
        return null;
    }


    public static String get(String url) {
        Request request = new Request.Builder()
                .url(url)
                .build();
        return doRequest(request);
    }


    public void setOkHttpClient() {
        OkhttpUtil.okHttpClient = new OkHttpClient();
    }
}
