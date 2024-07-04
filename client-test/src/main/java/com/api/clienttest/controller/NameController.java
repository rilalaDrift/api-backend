package com.api.clienttest.controller;

import com.api.apiclientsdk.client.ApiClient;
import com.api.apiclientsdk.model.NumOfString;
import com.api.apiclientsdk.model.User;
import com.api.apiclientsdk.model.Year;
import com.api.apiclientsdk.utils.SignUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/name")
public class NameController {

    @Autowired
    private ApiClient apiClient;

//    @GetMapping("/get")
//    public String getNameByGet(String name, HttpServletRequest request) {
//        System.out.println(request.getHeader("source"));
//        return "GET 你的名字是" + name;
//    }
//
//    @PostMapping("/post")
//    public String getNameByPost(@RequestParam String name) {
//        return "POST 你的名字是" + name;
//    }

    @PostMapping("/user")
    public String getUsernameByPost(@RequestBody User user, HttpServletRequest request) {
//        String accessKey = request.getHeader("accessKey");
//        String nonce = request.getHeader("nonce");
//        String timestamp = request.getHeader("timestamp");
//        String sign = request.getHeader("sign");
//        String body = request.getHeader("body");
        // todo 实际情况应该是去数据库中查是否已分配给用户
//        if (!accessKey.equals("abcdefgh")) {
//            throw new RuntimeException("无权限");
//        }
//        if (Long.parseLong(nonce) > 10000) {
//            throw new RuntimeException("无权限");
//        }
         //todo 时间和当前时间不能超过 5 分钟
//        if (timestamp) {
//
//        }
         //todo 实际情况中是从数据库中查出 secretKey
//        String serverSign = SignUtils.genSign(body, "abcdefgh");
//        if (!sign.equals(serverSign)) {
//            throw new RuntimeException("无权限");
//        }
        // todo 调用次数 + 1 invokeCount
        String result = "POST 用户名字是" + user.getUsername();
        return result;
    }
    @PostMapping("/year")
    public String getYear(@RequestBody Year year){

        int years =Integer.parseInt(year.getYear());
        if((years % 4 ==0 && years % 100 !=0) || years%400 ==0){
            return "这个年份是闰年";
        }else{
            return "这个年份不是闰年";
        }
    }


    @PostMapping("/numOfString")
    public String getNumOfString(@RequestBody NumOfString numOfString){
        String s=numOfString.getText();
        int charCount=0,numberCout=0,blankCount=0,otherCount=0;
        for (int i=0;i<s.length();i++){
            //英文字母
            char temp=s.charAt(i);
            if (('a'<=temp&& temp<='z')||('A'<=temp&&temp<='Z')){
                charCount++;
                //数字类型
            }else if('0'<=temp&&temp<='9'){
                numberCout++;
                //空格类型(不全)
            }else if(temp=='\t'||temp=='\n'||temp==' '){
                blankCount++;
                //其它类型
            }else {
                otherCount++;
            }
        }

       String res= "英文字母出现的次数："+charCount+ "\n"+
         "数字出现的次数："+numberCout+"\n"+
        "空格字符出现的次数："+blankCount+"\n"+
        "其它字符："+otherCount;
        return res;
     }
  }

