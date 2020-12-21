package com.alisha.wddily.film.controller;

import com.alisha.wddily.film.controller.vo.DescribeActorsRespVO;
import com.alisha.wddily.film.controller.vo.DescribeFilmRespVO;
import com.alisha.wddily.film.controller.vo.DescribeFilmsRespVO;
import com.alisha.wddily.film.controller.vo.FilmSavedReqVO;
import com.alisha.wddily.film.service.FilmService;
import com.alisha.wddily.utils.common.vo.BasePageVO;
import com.alisha.wddily.utils.common.vo.BaseResponseVO;
import com.alisha.wddily.utils.exception.CommonServiceException;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @since
 */
@RestController
@RequestMapping(value = "/films")
public class FilmController {

    private final FilmService filmService;

            @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    // 获取演员列表
    @RequestMapping(value = "/actors", method = RequestMethod.GET)
    public BaseResponseVO describeActors(BasePageVO basePageVO) throws CommonServiceException {
        basePageVO.checkParam();
        IPage<DescribeActorsRespVO> results = filmService.describeActors(basePageVO.getNowtPage(), basePageVO.getPageSize());

        return BaseResponseVO.success(describePageResult(results, "actors"));
    }

    @RequestMapping(value = "/films", method = RequestMethod.GET)
    public BaseResponseVO describeFilms(BasePageVO basePageVO) throws CommonServiceException {
        basePageVO.checkParam();
        IPage<DescribeFilmsRespVO> results = filmService.describeFilms(basePageVO.getNowtPage(), basePageVO.getPageSize());

        return BaseResponseVO.success(describePageResult(results, "films"));
    }

    @RequestMapping(value = "/{filmId}", method = RequestMethod.GET)
    public BaseResponseVO describeFilmById(@PathVariable("filmId") String filmId) throws CommonServiceException {

        DescribeFilmRespVO describeFilmRespVO = filmService.describeFilmById(filmId);

        if (describeFilmRespVO == null) {
            return BaseResponseVO.success();
        } else {
            return BaseResponseVO.success(describeFilmRespVO);
        }
    }


    @RequestMapping(value = "/film:add", method = RequestMethod.POST)
    public BaseResponseVO saveFilmInfo(@RequestBody FilmSavedReqVO filmSavedReqVO) throws CommonServiceException {

        filmService.saveFilm(filmSavedReqVO);
        return BaseResponseVO.success();
    }

    // 获取分页对象公共接口
    private Map<String, Object> describePageResult(IPage page, String title) {

        Map<String, Object> result = Maps.newHashMap();
        result.put("totalSize", page.getTotal());
        result.put("totalPages", page.getPages());
        result.put("pageSize", page.getSize());
        result.put("nowPage", page.getCurrent());
        result.put(title, page.getRecords());
        return result;
    }

}
