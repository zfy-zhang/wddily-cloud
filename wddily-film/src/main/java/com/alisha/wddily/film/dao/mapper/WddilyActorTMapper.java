package com.alisha.wddily.film.dao.mapper;

import com.alisha.wddily.film.controller.vo.DescribeActorsRespVO;
import com.alisha.wddily.film.dao.entity.WddilyActorT;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * 演员表 Mapper 接口
 * </p>
 *
 * @author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @since 2020-12-12
 */
public interface WddilyActorTMapper extends BaseMapper<WddilyActorT> {

    IPage<DescribeActorsRespVO> describeActors(Page<DescribeActorsRespVO> page);

}
