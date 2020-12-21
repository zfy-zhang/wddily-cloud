package com.alisha.wddily.film.service;

import com.alisha.wddily.film.controller.vo.DescribeActorsRespVO;
import com.alisha.wddily.film.controller.vo.DescribeFilmRespVO;
import com.alisha.wddily.film.controller.vo.DescribeFilmsRespVO;
import com.alisha.wddily.film.controller.vo.FilmSavedReqVO;
import com.alisha.wddily.utils.exception.CommonServiceException;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * @Description: 影片逻辑层
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @since
 */
public interface FilmService {

    IPage<DescribeActorsRespVO> describeActors(int nowPage, int pageSize) throws CommonServiceException;

    IPage<DescribeFilmsRespVO> describeFilms(int nowPage, int pageSize) throws CommonServiceException;

    DescribeFilmRespVO describeFilmById(String filmId) throws CommonServiceException;

    void saveFilm(FilmSavedReqVO filmSavedReqVO) throws CommonServiceException;
}
