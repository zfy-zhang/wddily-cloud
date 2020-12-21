package com.alisha.wddily.cinema.controller;

import com.alisha.wddily.cinema.service.CinemaService;
import com.alisha.wddily.cinema.controller.vo.CinemaSaveReqVO;
import com.alisha.wddily.utils.common.vo.BasePageVO;
import com.alisha.wddily.utils.common.vo.BaseResponseVO;
import com.alisha.wddily.utils.exception.CommonServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 应援表现层
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @since
 */
@RestController
@RequestMapping("/cinemas")
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;

    @RequestMapping(value = "cinema:add", method = RequestMethod.POST)
    public BaseResponseVO saveCinema(@RequestBody CinemaSaveReqVO cinemaSaveReqVO) throws CommonServiceException {
        cinemaSaveReqVO.checkParam();
        cinemaService.saveCinema(cinemaSaveReqVO);
        return BaseResponseVO.success();
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public BaseResponseVO describeCinemas(BasePageVO basePageVO) throws CommonServiceException {

        cinemaService.describeCinemas(basePageVO.getNowtPage(), basePageVO.getPageSize());

        // TODO 调用封装的分页返回方法

        return BaseResponseVO.success();
    }



}
