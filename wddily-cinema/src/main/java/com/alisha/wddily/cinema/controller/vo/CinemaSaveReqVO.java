package com.alisha.wddily.cinema.controller.vo;

import com.alisha.wddily.utils.common.vo.BaseRequestVO;
import com.alisha.wddily.utils.exception.CommonServiceException;
import lombok.Data;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @since
 */
@Data
public class CinemaSaveReqVO extends BaseRequestVO {

    private String brandId;
    private String areaId;
    private String hallTypeIds;
    private String cinemaName;
    private String cinemaAddress;
    private String cinemaTele;
    private String cinemaImgAddress;
    private String cinemaPrice;

    @Override
    public void checkParam() throws CommonServiceException {

    }
}
