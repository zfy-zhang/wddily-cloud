package com.alisha.wddily.cinema.service.impl;

import com.alisha.wddily.cinema.controller.vo.CinemaSaveReqVO;
import com.alisha.wddily.cinema.controller.vo.DescribeCinemasRespVO;
import com.alisha.wddily.cinema.dao.mapper.WddilyCinemaTMapper;
import com.alisha.wddily.cinema.service.CinemaService;
import com.alisha.wddily.utils.exception.CommonServiceException;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @since
 */
public class CinemaServiceImpl implements CinemaService {

    @Autowired
    private WddilyCinemaTMapper cinemaTMapper;

    @Override
    public void saveCinema(CinemaSaveReqVO cinemaSaveReqVO) throws CommonServiceException {
//        cinemaTMapper.insert(cinemaSaveReqVO);
    }

    @Override
    public IPage<DescribeCinemasRespVO> describeCinemas(int nowPage, int pageSize) throws CommonServiceException {
        return null;
    }
}
