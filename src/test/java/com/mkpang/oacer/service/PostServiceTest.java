package com.mkpang.oacer.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mkpang.oacer.model.dto.post.PostQueryRequest;
import com.mkpang.oacer.model.entity.Post;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * 帖子服务测试
 *
 * @author <a href="https://github.com/k9evin">Mingkai Pang</a>
 */
@SpringBootTest
class PostServiceTest {

    @Resource
    private PostService postService;

    @Test
    void searchFromEs() {
        PostQueryRequest postQueryRequest = new PostQueryRequest();
        postQueryRequest.setUserId(1L);
        Page<Post> postPage = postService.searchFromEs(postQueryRequest);
        Assertions.assertNotNull(postPage);
    }

}