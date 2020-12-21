package com.alisha.wddily.film.controller.vo;

import com.alisha.wddily.utils.common.vo.BaseRequestVO;
import com.alisha.wddily.utils.exception.CommonServiceException;
import lombok.Data;

/**
 * @Description: 保存电影信息
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @since
 */
@Data
public class FilmSavedReqVO extends BaseRequestVO {

    private String filmStatus;
    private String filmName;
    private String filmEnName;
    private String mainImgAddress;
    private String filmScore;
    private String filmScorers;
    private String preSaleNum;
    private String boxOffice;
    private String filmTypeId;
    private String filmSourceId;
    private String filmCatIds;
    private String areaId;
    private String dateId;
    private String filmTime;
    private String directorId;
    private String actIds;
    private String roleNames;
    private String filmLength;
    private String biography;
    private String filmImgs;


    @Override
    public void checkParam() throws CommonServiceException {

    }

}
