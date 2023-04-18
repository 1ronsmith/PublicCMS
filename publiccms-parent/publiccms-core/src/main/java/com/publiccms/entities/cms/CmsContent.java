package com.publiccms.entities.cms;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.search.engine.backend.analysis.AnalyzerNames;
import org.hibernate.search.engine.backend.types.Aggregable;
import org.hibernate.search.engine.backend.types.Projectable;
import org.hibernate.search.engine.backend.types.Sortable;
import org.hibernate.search.mapper.pojo.bridge.mapping.annotation.RoutingBinderRef;
import org.hibernate.search.mapper.pojo.bridge.mapping.annotation.TypeBinderRef;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.GenericField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.TypeBinding;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.publiccms.common.generator.annotation.GeneratorColumn;
import com.publiccms.common.search.CmsContentStatusRoutingBinder;
import com.publiccms.common.search.CmsContentTextBinder;
import com.publiccms.views.pojo.entities.Attribute;

/**
 * CmsContent generated by hbm2java
 */
@Entity
@Table(name = "cms_content")
@DynamicUpdate
@Indexed(routingBinder = @RoutingBinderRef(type = CmsContentStatusRoutingBinder.class))
@TypeBinding(binder = @TypeBinderRef(type = CmsContentTextBinder.class))
public class CmsContent extends Attribute implements java.io.Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    @GeneratorColumn(title = "ID")
    private Long id;
    @GeneratorColumn(title = "站点", condition = true)
    @GenericField
    @JsonIgnore
    private short siteId;
    /**
     * title
     * <p>
     * 标题
     */
    @GeneratorColumn(title = "标题", condition = true, like = true, or = true)
    @FullTextField(analyzer = "cms", projectable = Projectable.YES)
    @NotBlank
    @Length(max = 255)
    private String title;
    /**
     * user id
     * <p>
     * 发布用户ID
     */
    @GeneratorColumn(title = "发布用户", condition = true)
    @GenericField(aggregable = Aggregable.YES, projectable = Projectable.YES)
    private long userId;
    /**
     * dept id
     * <p>
     * 发布用户部门ID
     */
    @GeneratorColumn(title = "发布部门", condition = true)
    private Integer deptId;
    /**
     * check user id
     * <p>
     * 审核用户ID
     */
    @GeneratorColumn(title = "审核用户", condition = true)
    private Long checkUserId;
    /**
     * category id
     * <p>
     * 分类ID
     */
    @GeneratorColumn(title = "分类", condition = true)
    @GenericField(aggregable = Aggregable.YES, projectable = Projectable.YES)
    private int categoryId;
    /**
     * model id
     * <p>
     * 模型ID
     */
    @GeneratorColumn(title = "模型", condition = true)
    @GenericField(aggregable = Aggregable.YES, projectable = Projectable.YES)
    @NotBlank
    @Length(max = 20)
    private String modelId;
    /**
     * parent id
     * <p>
     * 父内容ID
     */
    @GeneratorColumn(title = "父内容", condition = true)
    @GenericField(aggregable = Aggregable.YES, projectable = Projectable.YES)
    private Long parentId;
    /**
     * quote content id
     * <p>
     * 引用内容ID
     */
    @GeneratorColumn(title = "引用内容", condition = true)
    @GenericField(projectable = Projectable.YES)
    private Long quoteContentId;
    /**
     * copied
     * <p>
     * 转载
     */
    @GeneratorColumn(title = "是否转载")
    private boolean copied;
    /**
     * author
     * <p>
     * 作者
     */
    @GeneratorColumn(title = "作者")
    @GenericField(projectable = Projectable.YES)
    private String author;
    /**
     * editor
     * <p>
     * 编辑
     */
    @GeneratorColumn(title = "编辑")
    @GenericField(projectable = Projectable.YES)
    private String editor;
    /**
     * external link
     * <p>
     * 外链
     */
    @GeneratorColumn(title = "外链")
    @GenericField(projectable = Projectable.YES)
    private boolean onlyUrl;
    /**
     * has images
     * <p>
     * 拥有图片列表
     */
    @GeneratorColumn(title = "有图片列表", condition = true)
    @GenericField
    private boolean hasImages;
    /**
     * has files
     * <p>
     * 拥有附件列表
     */
    @GeneratorColumn(title = "有附件列表", condition = true)
    @GenericField
    private boolean hasFiles;
    /**
     * has products
     * <p>
     * 拥有产品列表
     */
    @GeneratorColumn(title = "有产品列表", condition = true)
    @GenericField
    private boolean hasProducts;
    /**
     * has static file
     * <p>
     * 静态化
     */
    @GeneratorColumn(title = "有静态化")
    @GenericField(projectable = Projectable.YES)
    private boolean hasStatic;
    /**
     * url
     * <p>
     * 链接地址
     */
    @GeneratorColumn(title = "地址")
    @GenericField(projectable = Projectable.YES)
    @Length(max = 1000)
    private String url;
    /**
     * description
     * <p>
     * 描述
     */
    @GeneratorColumn(title = "描述")
    @FullTextField(analyzer = "cms", projectable = Projectable.YES)
    @Length(max = 300)
    private String description;
    /**
     * tag ids
     * <p>
     * 多个标签id
     */
    @GeneratorColumn(title = "标签")
    @FullTextField(analyzer = AnalyzerNames.WHITESPACE)
    private String tagIds;
    /**
     * cover
     * <p>
     * 封面图
     */
    @GeneratorColumn(title = "封面")
    private String cover;
    /**
     * childs
     * <p>
     * 子内容数
     */
    @GeneratorColumn(title = "子内容数")
    private int childs;
    /**
     * total scores
     * <p>
     * 总分数
     */
    @GeneratorColumn(title = "总分数")
    private int scores;
    /**
     * score users
     * <p>
     * 评分用户数
     */
    @GeneratorColumn(title = "评分用户数")
    private int scoreUsers;
    /**
     * score
     * <p>
     * 分数
     */
    @GeneratorColumn(title = "分数", order = true)
    @GenericField(sortable = Sortable.YES, projectable = Projectable.YES)
    private BigDecimal score;
    /**
     * comments
     * <p>
     * 评论数
     */
    @GeneratorColumn(title = "评论数", order = true)
    private int comments;
    /**
     * clicks
     * <p>
     * 点击数
     */
    @GeneratorColumn(title = "点击数", order = true)
    @GenericField(sortable = Sortable.YES, projectable = Projectable.YES)
    private int clicks;
    /**
     * publish date
     * <p>
     * 发布日期
     */
    @GeneratorColumn(title = "发布日期", condition = true, order = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @GenericField(sortable = Sortable.YES, projectable = Projectable.YES)
    private Date publishDate;
    /**
     * expiry date
     * <p>
     * 过期日期
     *
     */
    @GeneratorColumn(title = "过期日期", condition = true, order = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @GenericField
    private Date expiryDate;
    /**
     * check date
     * <p>
     * 审核日期
     */
    @GeneratorColumn(title = "审核日期", order = true)
    private Date checkDate;
    /**
     * update user id
     * <p>
     * 更新用户id
     */
    @GeneratorColumn(title = "更新用户")
    private Long updateUserId;
    /**
     * update date
     * <p>
     * 更新日期
     */
    @GeneratorColumn(title = "更新日期", order = true)
    private Date updateDate;
    /**
     * create date
     * <p>
     * 创建日期
     */
    @GeneratorColumn(title = "创建日期")
    private Date createDate;
    /**
     * top
     * <p>
     * 置顶级别
     */
    @GeneratorColumn(title = "排序")
    @GenericField(sortable = Sortable.YES, projectable = Projectable.YES)
    private int sort;
    /**
     * status(0:Draft,1:Published,2:Pending,3:Rejected)
     * <p>
     * 状态(0:草稿,1:已发布,2:待审核,3:驳回)
     */
    @GeneratorColumn(title = "状态", condition = true)
    private int status;
    @GeneratorColumn(title = "已删除", condition = true)
    @JsonIgnore
    private boolean disabled;

    public CmsContent() {
    }

    public CmsContent(short siteId, String title, long userId, int categoryId, String modelId, boolean onlyUrl, boolean hasImages,
            boolean hasFiles, boolean hasProducts, int childs, Date publishDate, Date createDate, int sort, int status) {
        this(siteId, title, userId, categoryId, modelId, false, onlyUrl, hasImages, hasFiles, hasProducts, false, childs, 0, 0,
                BigDecimal.ZERO, 0, 0, publishDate, createDate, sort, status, false);
    }

    public CmsContent(short siteId, String title, long userId, int categoryId, String modelId, boolean copied, boolean onlyUrl,
            boolean hasImages, boolean hasFiles, boolean hasProducts, boolean hasStatic, int childs, int scores, int scoreUsers,
            BigDecimal score, int comments, int clicks, Date publishDate, Date createDate, int sort, int status,
            boolean disabled) {
        this.siteId = siteId;
        this.title = title;
        this.userId = userId;
        this.categoryId = categoryId;
        this.modelId = modelId;
        this.copied = copied;
        this.onlyUrl = onlyUrl;
        this.hasImages = hasImages;
        this.hasFiles = hasFiles;
        this.hasProducts = hasProducts;
        this.hasStatic = hasStatic;
        this.childs = childs;
        this.scores = scores;
        this.scoreUsers = scoreUsers;
        this.score = score;
        this.comments = comments;
        this.clicks = clicks;
        this.publishDate = publishDate;
        this.createDate = createDate;
        this.sort = sort;
        this.status = status;
        this.disabled = disabled;
    }

    @Id
    @Column(name = "id", unique = true, nullable = false)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "site_id", nullable = false)
    public short getSiteId() {
        return this.siteId;
    }

    public void setSiteId(short siteId) {
        this.siteId = siteId;
    }

    @Column(name = "title", nullable = false)
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "user_id", nullable = false)
    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Column(name = "dept_id")
    public Integer getDeptId() {
        return this.deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    @Column(name = "check_user_id")
    public Long getCheckUserId() {
        return this.checkUserId;
    }

    public void setCheckUserId(Long checkUserId) {
        this.checkUserId = checkUserId;
    }

    @Column(name = "category_id", nullable = false)
    public int getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Column(name = "model_id", nullable = false, length = 20)
    public String getModelId() {
        return this.modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    @Column(name = "parent_id")
    public Long getParentId() {
        return this.parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @Column(name = "quote_content_id")
    public Long getQuoteContentId() {
        return this.quoteContentId;
    }

    public void setQuoteContentId(Long quoteContentId) {
        this.quoteContentId = quoteContentId;
    }

    @Column(name = "copied", nullable = false)
    public boolean isCopied() {
        return this.copied;
    }

    public void setCopied(boolean copied) {
        this.copied = copied;
    }

    @Column(name = "author", length = 50)
    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Column(name = "editor", length = 50)
    public String getEditor() {
        return this.editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    @Column(name = "only_url", nullable = false)
    public boolean isOnlyUrl() {
        return this.onlyUrl;
    }

    public void setOnlyUrl(boolean onlyUrl) {
        this.onlyUrl = onlyUrl;
    }

    @Column(name = "has_images", nullable = false)
    public boolean isHasImages() {
        return this.hasImages;
    }

    public void setHasImages(boolean hasImages) {
        this.hasImages = hasImages;
    }

    @Column(name = "has_files", nullable = false)
    public boolean isHasFiles() {
        return this.hasFiles;
    }

    public void setHasFiles(boolean hasFiles) {
        this.hasFiles = hasFiles;
    }

    @Column(name = "has_products", nullable = false)
    public boolean isHasProducts() {
        return this.hasProducts;
    }

    public void setHasProducts(boolean hasProducts) {
        this.hasProducts = hasProducts;
    }

    @Column(name = "has_static", nullable = false)
    public boolean isHasStatic() {
        return this.hasStatic;
    }

    public void setHasStatic(boolean hasStatic) {
        this.hasStatic = hasStatic;
    }

    @Column(name = "url", length = 1000)
    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Column(name = "description", length = 300)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "tag_ids", length = 65535)
    public String getTagIds() {
        return this.tagIds;
    }

    public void setTagIds(String tagIds) {
        this.tagIds = tagIds;
    }

    @Column(name = "cover")
    public String getCover() {
        return this.cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    @Column(name = "childs", nullable = false)
    public int getChilds() {
        return this.childs;
    }

    public void setChilds(int childs) {
        this.childs = childs;
    }

    @Column(name = "scores", nullable = false)
    public int getScores() {
        return this.scores;
    }

    public void setScores(int scores) {
        this.scores = scores;
    }

    @Column(name = "score_users", nullable = false)
    public int getScoreUsers() {
        return this.scoreUsers;
    }

    public void setScoreUsers(int scoreUsers) {
        this.scoreUsers = scoreUsers;
    }

    @Column(name = "score", nullable = false)
    public BigDecimal getScore() {
        return this.score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    @Column(name = "comments", nullable = false)
    public int getComments() {
        return this.comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    @Column(name = "clicks", nullable = false)
    public int getClicks() {
        return this.clicks;
    }

    public void setClicks(int clicks) {
        this.clicks = clicks;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "publish_date", nullable = false, length = 19)
    public Date getPublishDate() {
        return this.publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "expiry_date", length = 19)
    public Date getExpiryDate() {
        return this.expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "check_date", length = 19)
    public Date getCheckDate() {
        return this.checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    @Column(name = "update_user_id")
    public Long getUpdateUserId() {
        return this.updateUserId;
    }

    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_date", length = 19)
    public Date getUpdateDate() {
        return this.updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", nullable = false, length = 19)
    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Column(name = "sort", nullable = false)
    public int getSort() {
        return this.sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    @Column(name = "status", nullable = false)
    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Column(name = "disabled", nullable = false)
    public boolean isDisabled() {
        return this.disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

}
