package com.example.entertainmentresource.models.slider;

import com.example.entertainmentresource.models.entertainment.EntertainmentData;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "slider_data")
public class SliderData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column( nullable = false)
    private String header;

    @Enumerated(EnumType.STRING)
    @Column(name = "card_type", nullable = false)
    private CardType cardType;

    @Column(nullable = false, name = "sort_id")
    private int sortId;
    @Enumerated(EnumType.STRING)
    @Column( nullable = false)
    private PageType page;
    @ManyToMany
    @JoinTable(name = "slider_entertainment",
            joinColumns =   @JoinColumn(name = "slider_id"),
            inverseJoinColumns = @JoinColumn(name = "entertainment_id")
    )
    private List<EntertainmentData> entertainmentData;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public PageType getPage() {
        return page;
    }

    public void setPage(PageType page) {
        this.page = page;
    }

    public List<EntertainmentData> getEntertainmentData() {
        return entertainmentData;
    }

    public void setEntertainmentData(List<EntertainmentData> entertainmentData) {
        this.entertainmentData = entertainmentData;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public int getSortId() {
        return sortId;
    }

    public void setSortId(int sortId) {
        this.sortId = sortId;
    }
}
