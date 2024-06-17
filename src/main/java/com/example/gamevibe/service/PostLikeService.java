package com.example.gamevibe.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.gamevibe.model.dto.PageRequest;
import com.example.gamevibe.model.vo.PostLikeVO;
import com.example.gamevibe.model.entity.PostLike;
import com.example.gamevibe.model.vo.PageVO;

import java.util.List;

/**
* @author ZML
* @description 针对表【post_price(帖子点赞表)】的数据库操作Service
* @createDate 2024-06-11 21:18:53
*/
public interface PostLikeService extends IService<PostLike> {

    PageVO<List<PostLikeVO>, PostLikeVO> getLikePostVOPage(PageRequest pageRequest);

    void like(String post_id);

    void unLike(String post_id);
}
