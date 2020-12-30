package com.yicen.myBatis.dto;

import com.yicen.myBatis.entity.Category;
import com.yicen.myBatis.entity.Goods;

public class CategoryDTO {
    private Category category;
    private Goods goods;
    private String test;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
