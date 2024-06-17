package com.example.gamevibe.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.gamevibe.context.BaseContext;
import com.example.gamevibe.mapper.FocusUserMapper;
import com.example.gamevibe.model.dto.PageRequest;
import com.example.gamevibe.model.entity.FocusUser;
import com.example.gamevibe.model.vo.FocusUserVO;
import com.example.gamevibe.model.vo.PageVO;
import com.example.gamevibe.service.FocusUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author ZML
* @description 针对表【focus_user(关注用户表)】的数据库操作Service实现
* @createDate 2024-06-11 21:18:53
*/
@Slf4j
@Service
public class FocusUserServiceImpl extends ServiceImpl<FocusUserMapper, FocusUser> implements FocusUserService {

    @Autowired
    private FocusUserMapper focusUserMapper;

    @Override
    public PageVO<List<FocusUserVO>, FocusUserVO> getFocusUserVOPage(PageRequest pageRequest) {
        long current = pageRequest.getCurrent();
        long size = pageRequest.getPageSize();
        String user_id = BaseContext.getCurrentId();

        Page<FocusUserVO> focusUserPage = focusUserMapper.getFocusUserVOPage(user_id, new Page<>(current, size));

        return new PageVO<List<FocusUserVO>, FocusUserVO>().objToVO(focusUserPage);
    }

    @Override
    public PageVO<List<FocusUserVO>, FocusUserVO> getFocusUserVOPage(PageRequest pageRequest, String query_user_id) {
        long current = pageRequest.getCurrent();
        long size = pageRequest.getPageSize();
        String user_id = BaseContext.getCurrentId();

        Page<FocusUserVO> focusUserPage = focusUserMapper.getFocusUserVOPage(user_id, query_user_id, new Page<>(current, size));

        return new PageVO<List<FocusUserVO>, FocusUserVO>().objToVO(focusUserPage);
    }

    @Override
    public void focus(String focus_id) {
        String user_id = BaseContext.getCurrentId();
        focusUserMapper.saveFocus(user_id, focus_id);
    }

    @Override
    public void unFocus(String focus_id) {
        String user_id = BaseContext.getCurrentId();
        focusUserMapper.cancelFocus(user_id, focus_id);
    }



}



