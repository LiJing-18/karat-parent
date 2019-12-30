package com.example.socket.business.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
/**
 * Banner信息Entity
 * @author L
 * @Date 2019-12-30 14:16:29
 */
@Getter
@Setter
@NoArgsConstructor
public class BannerInfo{

    private static final long serialVersionUID = 1L;
     /** 主键id */
    private String id;
    /** 位置(1=租客、2=管家、3=社长、4=领导、5=物业) */
    private int position;
    /** 内容类型(1=富文本、2=超链接、3=业务) */
    private int contentType;
    /** 内容 */
    private String content = "";
    /** 业务Id */
    private String businessId = "";
    /** 业务类型(1=房源、2=活动、3=新闻) */
    private int businessType;
    /** Banner图片地址 */
    private String imageUrl = "";
    /** 是否发布(1=是、2=否) */
    private int isOnline;
    /** 排序 */
    private int sort;


}
