package com.alisha.wddily.film.controller.vo;

import lombok.Data;

/**
 * @Description: 根据主键获取影片返回对象
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @since
 */
@Data
public class DescribeFilmRespVO {

        private String filmId;
        private String filmName;
        private String filmLength;
        private String filmCats;
        private String actors;
        private String imgAddress;
        private String subAddress;

}
