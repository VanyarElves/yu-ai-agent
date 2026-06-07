package com.yupi.yuaiagent.rag;

import org.springframework.ai.document.Document;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class MyTokenTextSplitter {
    public List<Document> splitDocuments(List<Document> documents) {
        TokenTextSplitter splitter = new TokenTextSplitter();
        return splitter.apply(documents);
    }

    public List<Document> splitCustomized(List<Document> documents) {
        TokenTextSplitter splitter = TokenTextSplitter.builder()
                .withChunkSize(200)              // 每个切片的最大 Token 数量
                .withMinChunkSizeChars(100)      // 切片的最小字符数
                .withMinChunkLengthToEmbed(10)   // 触发 embedding 的最小 chunk 长度
                .withMaxNumChunks(5000)          // 最大切片数量
                .withKeepSeparator(true)         // 是否保留分隔符
                .build();
        return splitter.apply(documents);
    }
}
