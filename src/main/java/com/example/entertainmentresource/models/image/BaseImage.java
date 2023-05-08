package com.example.entertainmentresource.models.image;

import com.example.entertainmentresource.models.entertainment.EntertainmentData;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@MappedSuperclass
public abstract class BaseImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "link_id")
    private String linkId;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private int width;

    @Column(nullable = false)
    private int height;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entertainment_id", nullable = false)
    @JsonIgnore
    private EntertainmentData entertainmentData;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLinkId() {
        return linkId;
    }

    public void setLinkId(String linkId) {
        this.linkId = linkId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public EntertainmentData getEntertainmentData() {
        return entertainmentData;
    }

    public void setEntertainmentData(EntertainmentData entertainmentData) {
        this.entertainmentData = entertainmentData;
    }
}
