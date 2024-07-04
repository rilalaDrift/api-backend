package com.api.apiclientsdk.client;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.api.apiclientsdk.model.User;


import java.util.HashMap;
import java.util.Map;

import static com.api.apiclientsdk.utils.SignUtils.genSign;


/**
 * 调用第三方接口的客户端
 *

 */
public class ApiClient {

    private static final String GATEWAY_HOST = "http://localhost:8090";

    private String accessKey;

    private String secretKey;

    public ApiClient(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

//    public String getNameByGet(String name) {
//        //可以单独传入http参数，这样参数会自动做URL编码，拼接在URL中
//        HashMap<String, Object> paramMap = new HashMap<>();
//        paramMap.put("name", name);
//        String result = HttpUtil.get(GATEWAY_HOST + "/api/name/", paramMap);
//        System.out.println(result);
//        return result;
//    }
//
//    public String getNameByPost(String name) {
//        //可以单独传入http参数，这样参数会自动做URL编码，拼接在URL中
//        HashMap<String, Object> paramMap = new HashMap<>();
//        paramMap.put("name", name);
//        String result = HttpUtil.post(GATEWAY_HOST + "/api/name/", paramMap);
//        System.out.println(result);
//        return result;
//    }

    private Map<String, String> getHeaderMap(String body) {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("accessKey", accessKey);
        // 一定不能直接发送
//        hashMap.put("secretKey", secretKey);
        hashMap.put("nonce", RandomUtil.randomNumbers(4));
        hashMap.put("body", body);
        hashMap.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        hashMap.put("sign", genSign(body, secretKey));
        return hashMap;
    }

//    public String getUsernameByPost(User user) {
//        String json = JSONUtil.toJsonStr(user);
//        HttpResponse httpResponse = HttpRequest.post(GATEWAY_HOST + "/api/name/user")
//                .addHeaders(getHeaderMap(json))
//                .body(json)
//                .execute();
//        System.out.println(httpResponse.getStatus());
//        String result = httpResponse.body();
//        System.out.println(result);
//        return result;
//    }

    private String getUsernameByPost(String json) {
       return executeJson(json,"/api/name/user");
    }


    private String getYear (String json){
        return executeJson(json,"/api/name/year");
    }

    private  String getNumOfString (String json){
        return executeJson(json,"/api/name/numOfString");
    }






    public String executeJson(String json,String host) {
        host=GATEWAY_HOST+host;
        HttpResponse httpResponse = HttpRequest.post(host)
                .addHeaders(getHeaderMap(json))
                .body(json)
                .execute();
        System.out.println(httpResponse.getStatus());
        String result = httpResponse.body();
        System.out.println(result);
        return result;
    }


    public String mainInvoke (String json,String name) {
        if (name.equals("getUsernameByPost")){

            return getUsernameByPost(json);
        }

        if (name.equals("getYear")){
           return getYear(json);
        }
        if (name.equals("getNumOfString")){
            return getNumOfString(json);
        }

        return  null;

    }

    public String TestExist(String name){
        if (name.equals("getUsernameByPost")){
            String res ="{\"username\": \"uaxxx\"}";
            return getUsernameByPost(res);
        }
        if (name.equals("getYear")){
            String res ="{\"year\": \"2024\"}";
            return getYear(res);
        }
        if (name.equals("getNumOfString")){
            String res ="{\"text\": \"abc123\"}";
            return getNumOfString(res);
        }


        return  null;
    }


}
