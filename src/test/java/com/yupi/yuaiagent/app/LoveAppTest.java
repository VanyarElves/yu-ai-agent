package com.yupi.yuaiagent.app;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LoveAppTest {

    @Resource
    private LoveApp loveApp;

    @Test
    void testChat() {
        String chatID = UUID.randomUUID().toString();
        //第一轮
        String message="你好，我是程序员张小凡";
        String answer=loveApp.doChat(message,chatID);
        //第二轮
        message="我想让另一半(程序员陆雪琪)更爱我";
        answer=loveApp.doChat(message,chatID);
        Assertions.assertNotNull(answer);
        //第三轮
        message="我的另一半叫什么来着，刚跟你说过，帮我回忆一下";
        answer=loveApp.doChat(message,chatID);
        Assertions.assertNotNull(answer);
    }

    @Test
    void doChatWithReport() {
        String chatID = UUID.randomUUID().toString();
        String message="你好，我是程序员张小凡，我想让另一半(程序员陆雪琪)更爱我，但我不知道该怎么做";
        LoveApp.LoveReport loveReport = loveApp.doChatWithReport(message, chatID);
        Assertions.assertNotNull(loveReport);
    }

    @Test
    void doChatWithRAG() {
        String chatID = UUID.randomUUID().toString();
        String message="我现在想玩3A游戏怎么办？";
        String answer = loveApp.doChatWithRAG(message, chatID);
        Assertions.assertNotNull(answer);
    }
}