package com.yupi.yuaiagent.demo.invoke;

import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
/**
 * HTTP方式调用AI
 */
public class HttpAiInvoke {

    public static void main(String[] args) {
        String url = "https://dashscope.aliyuncs.com/api/v1/services/aigc/text-generation/generation";
        String apiKey = TestApiKey.API_KEY;

        JSONArray messages = JSONUtil.createArray();
        messages.add(JSONUtil.createObj()
                .set("role", "system")
                .set("content", "You are a helpful assistant."));
        messages.add(JSONUtil.createObj()
                .set("role", "user")
                .set("content", "你是谁？"));

        JSONObject body = JSONUtil.createObj()
                .set("model", "qwen-plus")
                .set("input", JSONUtil.createObj().set("messages", messages))
                .set("parameters", JSONUtil.createObj().set("result_format", "message"));

        String responseBody = HttpRequest.post(url)
                .header("Authorization", "Bearer " + apiKey)
                .header("Content-Type", "application/json; charset=UTF-8")
                .body(body.toString())
                .timeout(60_000)
                .execute()
                .body();

        System.out.println(responseBody);
    }
}