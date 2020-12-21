package com.alisha.wddily.film.dao.mapper;

import com.alisha.wddily.film.controller.vo.DescribeFilmRespVO;
import com.alisha.wddily.film.controller.vo.DescribeFilmsRespVO;
import com.alisha.wddily.film.dao.entity.WddilyFilmT;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 影片主表 Mapper 接口
 * </p>
 *
 * @author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @since 2020-12-12
 */
public interface WddilyFilmTMapper extends BaseMapper<WddilyFilmT> {
    IPage<DescribeFilmsRespVO> describeFilms(Page<DescribeFilmsRespVO> page);
    DescribeFilmRespVO describeFileById(@Param("filmId") String filmId);
}
