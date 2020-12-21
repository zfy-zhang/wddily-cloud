package com.alisha.wddily.film.controller.vo;

import lombok.Data;

/**
 * @Description: 获取影片列表返回对象
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @since
 */
@Data
public class DescribeFilmsRespVO {

        private String filmId;
    	private String filmStatus;
        private String filmName;
        private String filmEnName;
        private String filmScore;
        private String preSaleNum;
        private String boxOffice;
        private String filmTime;
        private String filmLength;
        private String mainImg;

}
