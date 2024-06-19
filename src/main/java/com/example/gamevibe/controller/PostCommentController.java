package com.example.gamevibe.controller;

import com.example.gamevibe.common.BaseResponse;
import com.example.gamevibe.common.ResultUtils;
import com.example.gamevibe.model.dto.PostCommentQueryRequest;
import com.example.gamevibe.model.vo.PageResult;
import com.example.gamevibe.service.PostCommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Api(tags = "帖子评论模块")
@RestController
@RequestMapping("/post_comment")
@Slf4j
public class PostCommentController {
    @Resource
    PostCommentService postCommentService;

    /**
     * 根据 帖子id 分页查询
     *
     * @param postCommentQueryRequest
     * @return
     */
    @ApiOperation(value = "获取帖子评论")
    @PostMapping("/list")
    public BaseResponse<PageResult> listCommentsVOByPage(@RequestBody PostCommentQueryRequest postCommentQueryRequest, HttpServletRequest request) {
        return ResultUtils.success(postCommentService.listCommentsByPage(postCommentQueryRequest, request));
    }


}