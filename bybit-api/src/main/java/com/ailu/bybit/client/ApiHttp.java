package com.ailu.bybit.client;

import com.ailu.bybit.config.APIConfiguration;
import com.ailu.bybit.constant.APIConstants;
import com.ailu.bybit.exception.APIException;
import com.ailu.bybit.utils.DateUtils;
import com.alibaba.fastjson.JSONObject;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Http
 *
 * @author Tony Tian
 * @version 1.0.0
 * @date 2018/6/5 11:19
 */
public class ApiHttp {

    private static final Logger LOG = LoggerFactory.getLogger(ApiHttp.class);

    private OkHttpClient client;
    private APIConfiguration config;

    static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public ApiHttp(APIConfiguration config, OkHttpClient client) {
        this.config = config;
        this.client = client;
    }

    public String get(String url) {
        Request request = new Request.Builder()
                .url(url(url))
                .build();
        return execute(request);
    }

    public String post(String url, JSONObject params) {
        String body = params.toJSONString();
        RequestBody requestBody = RequestBody.create(JSON, body);
        Request request = new Request.Builder()
                .url(url(url))
                .post(requestBody)
                .build();
        return execute(request);
    }

    public String delete(String url, JSONObject params) {
        String body = params.toJSONString();
        RequestBody requestBody = RequestBody.create(JSON, body);
        Request request = new Request.Builder()
                .url(url(url))
                .delete(requestBody)
                .build();
        return execute(request);
    }

    public String execute(Request request) {
        try {
            Response response = this.client.newCall(request).execute();
            int status = response.code();
            String bodyString = response.body().string();
            boolean responseIsNotNull = response != null;
            if (this.config.isPrint()) {
                printResponse(status, response.message(), bodyString, responseIsNotNull);
            }
            String message = new StringBuilder().append(response.code()).append(" / ").append(response.message()).toString();
            if (response.isSuccessful()) {
                return bodyString;
            } else if (APIConstants.resultStatusArray.contains(status)) {
//                HttpResult result = com.alibaba.fastjson.JSON.parseObject(bodyString, HttpResult.class);
 //               throw new APIException(result.getCode(), result.getMessage());
                throw new APIException(message);
            } else {
                throw new APIException(message);
            }
        } catch (IOException e) {
            throw new APIException("APIClient executeSync exception.", e);
        }
    }

    private void printResponse(int status, String message, String body, boolean responseIsNotNull) {
        StringBuilder responseInfo = new StringBuilder();
        responseInfo.append("\n\tResponse").append("(").append(DateUtils.timeToString(null, 4)).append("):");
        if (responseIsNotNull) {
            responseInfo.append("\n\t\t").append("Status: ").append(status);
            responseInfo.append("\n\t\t").append("Message: ").append(message);
            responseInfo.append("\n\t\t").append("Body: ").append(body);
        } else {
            responseInfo.append("\n\t\t").append("\n\tRequest Error: response is null");
        }
        LOG.debug(responseInfo.toString());
    }

    public String url(String url) {
        return new StringBuilder(this.config.getEndpoint()).append(url).toString();
    }
}