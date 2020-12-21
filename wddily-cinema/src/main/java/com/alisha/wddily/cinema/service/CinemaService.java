package com.alisha.wddily.cinema.service;

import com.alisha.wddily.cinema.controller.vo.CinemaSaveReqVO;
import com.alisha.wddily.cinema.controller.vo.DescribeCinemasRespVO;
import com.alisha.wddily.utils.exception.CommonServiceException;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @since
 */
public interface CinemaService {

    // 保存影院
    void saveCinema(CinemaSaveReqVO cinemaSaveReqVO) throws CommonServiceException;

    // 获取影院列表
    IPage<DescribeCinemasRespVO> describeCinemas(int nowPage, int pageSize) throws CommonServiceException;

}
