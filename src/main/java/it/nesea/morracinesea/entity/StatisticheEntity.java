package it.nesea.morracinesea.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table
@Entity
public class StatisticheEntity {


    @Id
    private Long id;

    private Long totalePartite;
    private Long partitePerse;
    private Long partiteVinte;

    public StatisticheEntity() {
    }

    public StatisticheEntity(Long id, Long totalePartite, Long partitePerse, Long partiteVinte) {
        this.id = id;
        this.totalePartite = totalePartite;
        this.partitePerse = partitePerse;
        this.partiteVinte = partiteVinte;
    }

    public Long getTotalePartite() {
        return totalePartite;
    }

    public void setTotalePartite(Long totalePartite) {
        this.totalePartite = totalePartite;
    }

    public Long getPartitePerse() {
        return partitePerse;
    }

    public void setPartitePerse(Long partitePerse) {
        this.partitePerse = partitePerse;
    }

    public Long getPartiteVinte() {
        return partiteVinte;
    }

    public void setPartiteVinte(Long partiteVinte) {
        this.partiteVinte = partiteVinte;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
