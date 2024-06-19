package com.example.gamevibe.model.vo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

@Data
public class PageVO<T, E> implements Serializable {

    /**
     * 当前页
     */
    @ApiModelProperty(value = "当前页", example = "1")
    private long current;

    /**
     * 页大小
     */
    @ApiModelProperty(value = "页大小", example = "10")
    private long size;

    /**
     * 总数
     */
    @ApiModelProperty(value = "总数", example = "24")
    private long total;

    /**
     * 记录
     */
    @ApiModelProperty(value = "响应数据")
    private T records;

    public PageVO<T, E> objToVO(Page<E> page) {
        PageVO<T, E> pageVO = new PageVO<>();
        BeanUtils.copyProperties(page, pageVO);
        return pageVO;
    }

}
