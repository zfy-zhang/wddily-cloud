package com.alisha.wddily.film.service.impl;
import java.time.LocalDateTime;

import com.alisha.wddily.film.controller.vo.DescribeActorsRespVO;
import com.alisha.wddily.film.controller.vo.DescribeFilmRespVO;
import com.alisha.wddily.film.controller.vo.DescribeFilmsRespVO;
import com.alisha.wddily.film.controller.vo.FilmSavedReqVO;
import com.alisha.wddily.film.dao.entity.WddilyFilmActorT;
import com.alisha.wddily.film.dao.entity.WddilyFilmInfoT;
import com.alisha.wddily.film.dao.entity.WddilyFilmT;
import com.alisha.wddily.film.dao.mapper.WddilyActorTMapper;
import com.alisha.wddily.film.dao.mapper.WddilyFilmActorTMapper;
import com.alisha.wddily.film.dao.mapper.WddilyFilmInfoTMapper;
import com.alisha.wddily.film.dao.mapper.WddilyFilmTMapper;
import com.alisha.wddily.film.service.FilmService;
import com.alisha.wddily.utils.exception.CommonServiceException;
import com.alisha.wddily.utils.util.ToolUtils;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @since
 */
@Service
public class FilmServiceImpl implements FilmService {

    @Autowired
    private WddilyActorTMapper wddilyActorTMapper;

    @Autowired
    WddilyFilmActorTMapper wddilyFilmActorTMapper;

    @Autowired
    WddilyFilmInfoTMapper wddilyFilmInfoTMapper;

    @Autowired
    WddilyFilmTMapper wddilyFilmTMapper;


    /**
     * @Description 演员列表查询
     * @param nowPage
     * @param pageSize
     * @return
     * @throws CommonServiceException
     */
    @Override
    public IPage<DescribeActorsRespVO> describeActors(int nowPage, int pageSize) throws CommonServiceException {
        return wddilyActorTMapper.describeActors(new Page<>(nowPage, pageSize));
    }

    /**
     * @Description 影片别表查询
     * @param nowPage
     * @param pageSize
     * @return
     * @throws CommonServiceException
     */
    @Override
    public IPage<DescribeFilmsRespVO> describeFilms(int nowPage, int pageSize) throws CommonServiceException {
        return wddilyFilmTMapper.describeFilms(new Page<>(nowPage, pageSize));
    }

    /**
     * @Description
     * @param filmId
     * @return
     * @throws CommonServiceException
     */
    @Override
    public DescribeFilmRespVO describeFilmById(String filmId) throws CommonServiceException {
        return wddilyFilmTMapper.describeFileById(filmId);
    }

    /**
     * @Description 保存电影信息
     * @param filmSavedReqVO
     * @throws CommonServiceException
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveFilm(FilmSavedReqVO filmSavedReqVO) throws CommonServiceException {
        try {

            // 保存电影主表
            WddilyFilmT film = new WddilyFilmT();
            film.setFilmName(filmSavedReqVO.getFilmName());
            film.setFilmType(ToolUtils.str2Int(filmSavedReqVO.getFilmTypeId()));
            film.setImgAddress(filmSavedReqVO.getMainImgAddress());
            film.setFilmScore(filmSavedReqVO.getFilmScore());
            film.setFilmPresalenum(ToolUtils.str2Int(filmSavedReqVO.getPreSaleNum()));
            film.setFilmBoxOffice(ToolUtils.str2Int(filmSavedReqVO.getBoxOffice()));
            film.setFilmSource(ToolUtils.str2Int(filmSavedReqVO.getFilmSourceId()));
            film.setFilmCats(filmSavedReqVO.getFilmCatIds());
            film.setFilmArea(ToolUtils.str2Int(filmSavedReqVO.getAreaId()));
            film.setFilmDate(ToolUtils.str2Int(filmSavedReqVO.getDateId()));
            film.setFilmTime(ToolUtils.str2LocalDateTime(filmSavedReqVO.getFilmTime() + " 00:00:00"));
            film.setFilmStatus(ToolUtils.str2Int(filmSavedReqVO.getFilmStatus()));

            wddilyFilmTMapper.insert(film);

            // 保存电影子表
            WddilyFilmInfoT filmInfo = new WddilyFilmInfoT();
            filmInfo.setFilmId(film.getUuid() + "");
            filmInfo.setFilmEnName(filmSavedReqVO.getFilmEnName());
            filmInfo.setFilmScore(filmSavedReqVO.getFilmScore());
            filmInfo.setFilmScoreNum(ToolUtils.str2Int(filmSavedReqVO.getPreSaleNum()));
            filmInfo.setFilmLength(ToolUtils.str2Int(filmSavedReqVO.getFilmLength()));
            filmInfo.setBiography(filmSavedReqVO.getBiography());
            filmInfo.setDirectorId(ToolUtils.str2Int(filmSavedReqVO.getDirectorId()));
            filmInfo.setFilmImgs(filmSavedReqVO.getFilmImgs());

            wddilyFilmInfoTMapper.insert(filmInfo);

            String[] actorId = filmSavedReqVO.getActIds().split("#");
            String[] roleNames = filmSavedReqVO.getRoleNames().split("#");

            if (actorId.length != roleNames.length) {
                throw new CommonServiceException(500, "演员与角色名数量不匹配");
            }

            for (int i = 0; i < actorId.length; i++) {

                // 保存演员映射表
                WddilyFilmActorT filmActor = new WddilyFilmActorT();
                filmActor.setFilmId(film.getUuid());
                filmActor.setActorId(ToolUtils.str2Int(actorId[i]));
                filmActor.setRoleName(roleNames[i]);

                wddilyFilmActorTMapper.insert(filmActor);
            }

        } catch (Exception e) {
            throw new CommonServiceException(500, e.getMessage());
        }
    }
}
