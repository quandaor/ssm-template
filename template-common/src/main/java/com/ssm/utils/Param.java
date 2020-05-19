package com.ssm.utils;

import java.util.List;

/**
 * @author quandaoran
 * @date 2020-02-04
 * @description 参数
 */
public class Param {


    /**
     * 商品名称(模糊)
     */
    private String goodsName;
    /**
     * 商品名称(精确)
     */
    private List<String> goodsNames;
    /**
     * 新商品编码 前缀模糊搜
     */
    private String newGoodsSn;
    /**
     * 新商品编码 精确搜索
     */
    private List<String> newGoodsSns;
    /**
     * 是否删除 不传全部，可传值0或1 默认未删除0
     */
    private Integer isDelete;
    /**
     * 多个oe码 精确搜索
     */
    private List<String> oeNums;
    /**
     * 商品质量
     */
    private List<String> goodsQualityTypes;
    /**
     * 商品规格 前缀模糊搜索
     */
    private String goodsFormat;
    /**
     * 商家id
     */
    private List<String> sellerIds;
    /**
     * 分类ID
     */
    private List<String> catIds;
    /**
     * 品牌id
     */
    private List<String> brandIds;
    /**
     * 品牌零件号
     */
    private String brandPartCode;

    //    联盟上下价状态：上架/下架
    private String onShelf;

    //    联盟上下价Id：联盟ID
    private String leagueId;
}