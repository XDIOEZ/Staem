package com.itheima;

import java.math.BigDecimal;

public class Game {
    private Integer id;
    private String name;
    private BigDecimal price;
    private String description;
    private String comment;
    private String pictures;

    // 构造方法
    public Game() {
    }

    public Game(Integer id, String name, BigDecimal price, String description, String comment, String pictures) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.comment = comment;
        this.pictures = pictures;
    }

    // Getter 和 Setter 方法
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getPictures() {
        return pictures;
    }

    public void setPictures(String pictures) {
        this.pictures = pictures;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", comment='" + comment + '\'' +
                ", pictures='" + pictures + '\'' +
                '}';
    }
}
