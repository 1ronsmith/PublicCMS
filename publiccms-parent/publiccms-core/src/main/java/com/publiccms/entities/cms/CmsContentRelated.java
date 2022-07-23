package com.publiccms.entities.cms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import com.publiccms.common.database.CmsUpgrader;
import com.publiccms.common.generator.annotation.GeneratorColumn;

/**
 * CmsContentRelated generated by hbm2java
 */
/**
 * CmsContentRelated
 * 
 */
@Entity
@Table(name = "cms_content_related")
@DynamicUpdate
public class CmsContentRelated implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    @GeneratorColumn(title = "ID")
    private Long id;
    /**
     * content id
     * <p>
     * 内容id
     */
    @GeneratorColumn(title = "内容", condition = true)
    private long contentId;
    /**
     * relation type
     * <p>
     * 关系类型
     */
    @GeneratorColumn(title = "关系类型", condition = true)
    private String relationType;
    /**
     * relation
     * <p>
     * 关系
     */
    @GeneratorColumn(title = "关系", condition = true)
    private String relation;
    /**
     * related content id
     * <p>
     * 推进内容id
     */
    @GeneratorColumn(title = "推荐内容", condition = true)
    private Long relatedContentId;
    /**
     * related user id
     * <p>
     * 推进用户id
     */
    @GeneratorColumn(title = "推荐用户", condition = true)
    private long userId;
    /**
     * url
     * <p>
     * 链接地址
     */
    @GeneratorColumn(title = "推荐地址")
    private String url;
    /**
     * title
     * <p>
     * 标题
     */
    @GeneratorColumn(title = "推荐标题")
    private String title;
    /**
     * description
     * <p>
     * 描述
     */
    @GeneratorColumn(title = "推荐描述")
    private String description;
    /**
     * sort
     * <p>
     * 排序
     */
    @GeneratorColumn(title = "排序")
    private int sort;

    public CmsContentRelated() {
    }

    public CmsContentRelated(long contentId, long userId, int sort) {
        this.contentId = contentId;
        this.userId = userId;
        this.sort = sort;
    }

    public CmsContentRelated(long contentId, String relationType, String relation, Long relatedContentId, long userId, String url,
            String title, String description, int sort) {
        this.contentId = contentId;
        this.relationType = relationType;
        this.relation = relation;
        this.relatedContentId = relatedContentId;
        this.userId = userId;
        this.url = url;
        this.title = title;
        this.description = description;
        this.sort = sort;
    }

    @Id
    @GeneratedValue(generator = "cmsGenerator")
    @GenericGenerator(name = "cmsGenerator", strategy = CmsUpgrader.IDENTIFIER_GENERATOR)
    @Column(name = "id", unique = true, nullable = false)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "content_id", nullable = false)
    public long getContentId() {
        return this.contentId;
    }

    public void setContentId(long contentId) {
        this.contentId = contentId;
    }

    @Column(name = "relation_type")
    public String getRelationType() {
        return this.relationType;
    }

    public void setRelationType(String relationType) {
        this.relationType = relationType;
    }

    @Column(name = "relation")
    public String getRelation() {
        return this.relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    @Column(name = "related_content_id")
    public Long getRelatedContentId() {
        return this.relatedContentId;
    }

    public void setRelatedContentId(Long relatedContentId) {
        this.relatedContentId = relatedContentId;
    }

    @Column(name = "user_id", nullable = false)
    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Column(name = "url", length = 1000)
    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Column(name = "title")
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "description", length = 300)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "sort", nullable = false)
    public int getSort() {
        return this.sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

}
