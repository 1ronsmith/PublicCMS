package com.publiccms.entities.cms;

// Generated 2016-3-4 22:54:05 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.publiccms.common.generator.annotation.GeneratorColumn;

/**
 * CmsPlaceAttribute generated by hbm2java
 */
@Entity
@Table(name = "cms_place_attribute")
@DynamicUpdate
public class CmsPlaceAttribute implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * place id<p>
     * 推荐位id
     */
    @GeneratorColumn(title = "分类")
    private long placeId;
    /**
     * extend data<p>
     * 扩展数据
     */
    @GeneratorColumn(title = "扩展数据")
    private String data;

    public CmsPlaceAttribute() {
    }

    public CmsPlaceAttribute(long placeId) {
        this.placeId = placeId;
    }

    public CmsPlaceAttribute(long placeId, String data) {
        this.placeId = placeId;
        this.data = data;
    }

    @Id

    @Column(name = "place_id", unique = true, nullable = false)
    public long getPlaceId() {
        return this.placeId;
    }

    public void setPlaceId(long placeId) {
        this.placeId = placeId;
    }

    @Column(name = "data")
    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
