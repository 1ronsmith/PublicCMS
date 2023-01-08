package com.publiccms.entities.cms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.publiccms.common.database.CmsUpgrader;
import com.publiccms.common.generator.annotation.GeneratorColumn;

/**
 * CmsCategory generated by hbm2java
 */
@Entity
@Table(name = "cms_category", uniqueConstraints = @UniqueConstraint(columnNames = { "site_id", "code" }))
@DynamicUpdate
public class CmsCategory implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    @GeneratorColumn(title = "ID")
    private Integer id;
    @GeneratorColumn(title = "站点", condition = true)
    @JsonIgnore
    private short siteId;
    /**
     * name
     * <p>
     * 名称
     */
    @GeneratorColumn(title = "名称")
    private String name;
    /**
     * parent id
     * <p>
     * 父id
     */
    @GeneratorColumn(title = "父分类", condition = true)
    private Integer parentId;
    /**
     * type id
     * <p>
     * 分类类型id
     */
    @GeneratorColumn(title = "分类类型", condition = true)
    private String typeId;
    /**
     * child ids
     * <p>
     * 子分类id
     */
    @GeneratorColumn(title = "子分类")
    private String childIds;
    /**
     * tag type ids
     * <p>
     * 标签类型id
     */
    @GeneratorColumn(title = "标签")
    private String tagTypeIds;
    /**
     * code
     * <p>
     * 编码
     */
    @GeneratorColumn(title = "编码")
    private String code;

    /**
     * custom path
     * <p>
     * 自定义访问路径
     */
    private boolean customPath;
    @JsonIgnore
    @GeneratorColumn(title = "模板路径")
    private String templatePath;
    @JsonIgnore
    @GeneratorColumn(title = "路径")
    private String path;
    /**
     * extend link
     * <p>
     * 外链
     */
    @GeneratorColumn(title = "外链")
    private boolean onlyUrl;
    /**
     * has static file
     * <p>
     * 有静态化文件
     */
    @GeneratorColumn(title = "有静态化")
    private boolean hasStatic;
    /**
     * url
     * <p>
     * 链接地址
     */
    @GeneratorColumn(title = "地址")
    private String url;
    /**
     * custom content path
     * <p>
     * 自定义内容访问路径
     */
    private boolean customContentPath;
    @JsonIgnore
    @GeneratorColumn(title = "内容路径")
    private String contentPath;
    /**
     * contain child content
     * <p>
     * 包含子分类内容
     */
    @GeneratorColumn(title = "包含子分类内容")
    private boolean containChild;
    /**
     * content page size
     * <p>
     * 内容分页大小
     */
    @GeneratorColumn(title = "每页数据")
    private Integer pageSize;
    /**
     * allow contribute
     * <p>
     * 允许投稿
     */
    @GeneratorColumn(title = "允许投稿", condition = true)
    private boolean allowContribute;
    /**
     * sort
     * <p>
     * 排序
     */
    @GeneratorColumn(title = "排序")
    private int sort;
    /**
     * hidden
     * <p>
     * 前台隐藏
     */
    @GeneratorColumn(title = "是否隐藏", condition = true)
    private boolean hidden;
    @GeneratorColumn(title = "是否删除", condition = true)
    @JsonIgnore
    private boolean disabled;
    @GeneratorColumn(title = "扩展")
    @JsonIgnore
    private Integer extendId;

    public CmsCategory() {
    }

    public CmsCategory(short siteId, String name, String code, boolean customPath, boolean onlyUrl, boolean hasStatic,
            boolean customContentPath, boolean containChild, boolean allowContribute, int sort, boolean hidden,
            boolean disabled) {
        this.siteId = siteId;
        this.name = name;
        this.code = code;
        this.customPath = customPath;
        this.onlyUrl = onlyUrl;
        this.hasStatic = hasStatic;
        this.customContentPath = customContentPath;
        this.containChild = containChild;
        this.allowContribute = allowContribute;
        this.sort = sort;
        this.hidden = hidden;
        this.disabled = disabled;
    }

    public CmsCategory(short siteId, String name, Integer parentId, String typeId, String childIds, String tagTypeIds,
            String code, boolean customPath, String templatePath, String path, boolean onlyUrl, boolean hasStatic, String url,
            boolean customContentPath, String contentPath, boolean containChild, Integer pageSize, boolean allowContribute,
            int sort, boolean hidden, boolean disabled, Integer extendId) {
        this.siteId = siteId;
        this.name = name;
        this.parentId = parentId;
        this.typeId = typeId;
        this.childIds = childIds;
        this.tagTypeIds = tagTypeIds;
        this.code = code;
        this.customPath = customPath;
        this.templatePath = templatePath;
        this.path = path;
        this.onlyUrl = onlyUrl;
        this.hasStatic = hasStatic;
        this.url = url;
        this.customContentPath = customContentPath;
        this.contentPath = contentPath;
        this.containChild = containChild;
        this.pageSize = pageSize;
        this.allowContribute = allowContribute;
        this.sort = sort;
        this.hidden = hidden;
        this.disabled = disabled;
        this.extendId = extendId;
    }

    @Id
    @GeneratedValue(generator = "cmsGenerator")
    @GenericGenerator(name = "cmsGenerator", strategy = CmsUpgrader.IDENTIFIER_GENERATOR)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "site_id", nullable = false)
    public short getSiteId() {
        return this.siteId;
    }

    public void setSiteId(short siteId) {
        this.siteId = siteId;
    }

    @Column(name = "name", nullable = false, length = 50)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "parent_id")
    public Integer getParentId() {
        return this.parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Column(name = "type_id", length = 20)
    public String getTypeId() {
        return this.typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    @Column(name = "child_ids", length = 65535)
    public String getChildIds() {
        return this.childIds;
    }

    public void setChildIds(String childIds) {
        this.childIds = childIds;
    }

    @Column(name = "tag_type_ids", length = 65535)
    public String getTagTypeIds() {
        return this.tagTypeIds;
    }

    public void setTagTypeIds(String tagTypeIds) {
        this.tagTypeIds = tagTypeIds;
    }

    @Column(name = "code", nullable = false, length = 50)
    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name = "custom_path", nullable = false)
    public boolean isCustomPath() {
        return this.customPath;
    }

    public void setCustomPath(boolean customPath) {
        this.customPath = customPath;
    }

    @Column(name = "template_path")
    public String getTemplatePath() {
        return this.templatePath;
    }

    public void setTemplatePath(String templatePath) {
        this.templatePath = templatePath;
    }

    @Column(name = "path", length = 1000)
    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Column(name = "only_url", nullable = false)
    public boolean isOnlyUrl() {
        return this.onlyUrl;
    }

    public void setOnlyUrl(boolean onlyUrl) {
        this.onlyUrl = onlyUrl;
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

    @Column(name = "custom_content_path", nullable = false)
    public boolean isCustomContentPath() {
        return this.customContentPath;
    }

    public void setCustomContentPath(boolean customContentPath) {
        this.customContentPath = customContentPath;
    }

    @Column(name = "content_path", length = 1000)
    public String getContentPath() {
        return this.contentPath;
    }

    public void setContentPath(String contentPath) {
        this.contentPath = contentPath;
    }

    @Column(name = "contain_child", nullable = false)
    public boolean isContainChild() {
        return this.containChild;
    }

    public void setContainChild(boolean containChild) {
        this.containChild = containChild;
    }

    @Column(name = "page_size")
    public Integer getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Column(name = "allow_contribute", nullable = false)
    public boolean isAllowContribute() {
        return this.allowContribute;
    }

    public void setAllowContribute(boolean allowContribute) {
        this.allowContribute = allowContribute;
    }

    @Column(name = "sort", nullable = false)
    public int getSort() {
        return this.sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    @Column(name = "hidden", nullable = false)
    public boolean isHidden() {
        return this.hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    @Column(name = "disabled", nullable = false)
    public boolean isDisabled() {
        return this.disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    @Column(name = "extend_id")
    public Integer getExtendId() {
        return this.extendId;
    }

    public void setExtendId(Integer extendId) {
        this.extendId = extendId;
    }

}
