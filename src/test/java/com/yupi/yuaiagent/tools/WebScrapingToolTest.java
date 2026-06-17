package com.yupi.yuaiagent.tools;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class WebScrapingToolTest {

    @Test
    void scrapWebPage() {
        WebScrapingTool webScrapingTool = new WebScrapingTool();
        String url="https://www.codefather.cn";
        String result = webScrapingTool.scrapWebPage(url);
        Assertions.assertNotNull(result);
    }
}