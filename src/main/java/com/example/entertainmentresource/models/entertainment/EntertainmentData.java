package com.example.entertainmentresource.models.entertainment;

import com.example.entertainmentresource.models.image.FocusImage;
import com.example.entertainmentresource.models.image.LogoImage;
import com.example.entertainmentresource.models.image.PosterImage;
import com.example.entertainmentresource.models.image.WideImage;
import com.example.entertainmentresource.models.slider.SliderData;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "entertainment_data")
public class EntertainmentData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;
    @OneToMany(mappedBy = "entertainmentData", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FocusImage> focusImages;
    @OneToMany(mappedBy = "entertainmentData", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WideImage> wideImages;

    @OneToMany(mappedBy = "entertainmentData", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PosterImage> posterImages;

    @OneToMany(mappedBy = "entertainmentData", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LogoImage> logoImages;
    @Lob
    @Column(nullable = false, columnDefinition = "TEXT")
    private String overview;

    @Column(name = "release_date", nullable = false)
    private int releaseDate;
    @Column(nullable = true)
    private int runtime;

    @Column(nullable = false)
    private String status;

    @Column(nullable = true)
    private String rent;
    @Column(nullable = true)
    private String streaming;
    @Column(nullable = true)
    private String buy;

    @Column(nullable = false)
    private String genres;

    @Column(nullable = false, name = "vote_average")
    private int voteAverage;

    @Column(nullable = false, name = "vote_count")
    private int voteCount;

    @Column(nullable = true)
    private String tagline;

    @Column(nullable = true)
    private String mode;

    @Column(nullable = true)
    private String theme;
    @Enumerated(EnumType.STRING)
    @Column(name = "entertainment_type", nullable = false)
    private EntertainmentType entertainmentType;

    @ManyToMany(mappedBy = "entertainmentData")
    @JsonIgnore
    private List<SliderData> sliderData;

    private long popularity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<FocusImage> getFocusImages() {
        return focusImages;
    }

    public void setFocusImages(List<FocusImage> focusImages) {
        this.focusImages = focusImages;
    }

    public List<WideImage> getWideImages() {
        return wideImages;
    }

    public void setWideImages(List<WideImage> wideImages) {
        this.wideImages = wideImages;
    }

    public List<PosterImage> getPosterImages() {
        return posterImages;
    }

    public void setPosterImages(List<PosterImage> posterImages) {
        this.posterImages = posterImages;
    }

    public List<LogoImage> getLogoImages() {
        return logoImages;
    }

    public void setLogoImages(List<LogoImage> logoImages) {
        this.logoImages = logoImages;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRent() {
        return rent;
    }

    public void setRent(String rent) {
        this.rent = rent;
    }

    public String getStreaming() {
        return streaming;
    }

    public void setStreaming(String streaming) {
        this.streaming = streaming;
    }

    public String getBuy() {
        return buy;
    }

    public void setBuy(String buy) {
        this.buy = buy;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genre) {
        this.genres = genre;
    }

    public EntertainmentType getEntertainmentType() {
        return entertainmentType;
    }

    public void setEntertainmentType(EntertainmentType entertainmentType) {
        this.entertainmentType = entertainmentType;
    }

    public int getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(int voteAverage) {
        this.voteAverage = voteAverage;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public List<SliderData> getSliderData() {
        return sliderData;
    }

    public void setSliderData(List<SliderData> sliderData) {
        this.sliderData = sliderData;
    }

    public long getPopularity() {
        return popularity;
    }

    public void setPopularity(long popularity) {
        this.popularity = popularity;
    }
}
