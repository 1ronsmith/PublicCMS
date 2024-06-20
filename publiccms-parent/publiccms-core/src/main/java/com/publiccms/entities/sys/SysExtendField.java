package com.publiccms.entities.sys;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;

// Generated 2016-3-2 13:36:22 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.publiccms.common.generator.annotation.GeneratorColumn;

/**
 * SysExtendField generated by hbm2java
 */
@Entity
@Table(name = "sys_extend_field")
@DynamicUpdate
@JsonIgnoreProperties(ignoreUnknown = true)
public class SysExtendField implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    private SysExtendFieldId id;
    /**
     * required
     * <p>
     * 必填
     */
    @GeneratorColumn(title = "必填")
    private boolean required;
    /**
     * searchable
     * <p>
     * 可搜索
     */
    @GeneratorColumn(title = "可搜索")
    private boolean searchable;
    /**
     * sortable field
     * <p>
     * 排序字段
     */
    @GeneratorColumn(title = "可排序")
    private String sortable;
    /**
     * max length
     * <p>
     * 最大长度
     */
    @GeneratorColumn(title = "最大长度")
    private Integer maxlength;
    /**
     * image width
     * <p>
     * 图片宽度
     */
    @GeneratorColumn(title = "宽度")
    private Integer width;
    /**
     * image height
     * <p>
     * 图片高度
     */
    @GeneratorColumn(title = "高度")
    private Integer height;
    /**
     * name
     * <p>
     * 名称
     */
    @GeneratorColumn(title = "名称")
    @NotNull
    @Length(max = 20)
    private String name;
    /**
     * description
     * <p>
     * 描述
     */
    @GeneratorColumn(title = "描述")
    @Length(max = 300)
    private String description;
    /**
     * input type
     * <p>
     * 表单类型
     */
    @GeneratorColumn(title = "表单类型")
    private String inputType;
    /**
     * default value
     * <p>
     * 默认值
     */
    @GeneratorColumn(title = "默认值")
    private String defaultValue;
    /**
     * dictionary id
     * <p>
     * 数据字典
     */
    @GeneratorColumn(title = "数据字典")
    private String dictionaryId;
    /**
     * multiple
     * <p>
     * 多选
     */
    @GeneratorColumn(title = "多选")
    private boolean multiple;
    /**
     * sort
     * <p>
     * 排序
     */
    @GeneratorColumn(title = "顺序", order = true)
    private int sort;

    public SysExtendField() {
    }

    public SysExtendField(String code, String inputType, String name, String description) {
        this.id = new SysExtendFieldId(0, code);
        this.inputType = inputType;
        this.name = name;
        this.description = description;
    }

    public SysExtendField(String code, String inputType, boolean required, String name, String description, String defaultValue) {
        this.id = new SysExtendFieldId(0, code);
        this.inputType = inputType;
        this.required = required;
        this.name = name;
        this.description = description;
        this.defaultValue = defaultValue;
    }

    public SysExtendField(SysExtendFieldId id, boolean required, boolean searchable, String sortable, Integer maxlength,
            Integer width, Integer height, String name, String description, String inputType, String defaultValue,
            String dictionaryId, boolean multiple, int sort) {
        this.id = id;
        this.required = required;
        this.searchable = searchable;
        this.sortable = sortable;
        this.maxlength = maxlength;
        this.width = width;
        this.height = height;
        this.name = name;
        this.description = description;
        this.inputType = inputType;
        this.defaultValue = defaultValue;
        this.dictionaryId = dictionaryId;
        this.multiple = multiple;
        this.sort = sort;
    }

    @EmbeddedId
    @AttributeOverrides({ @AttributeOverride(name = "extendId", column = @Column(name = "extend_id", nullable = false)),
            @AttributeOverride(name = "code", column = @Column(name = "code", nullable = false, length = 20)) })
    public SysExtendFieldId getId() {
        return this.id;
    }

    public void setId(SysExtendFieldId id) {
        this.id = id;
    }

    @Column(name = "required", nullable = false)
    public boolean isRequired() {
        return this.required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    @Column(name = "searchable", nullable = false)
    public boolean isSearchable() {
        return this.searchable;
    }

    public void setSearchable(boolean searchable) {
        this.searchable = searchable;
    }

    @Column(name = "sortable", length = 20)
    public String getSortable() {
        return this.sortable;
    }

    public void setSortable(String sortable) {
        this.sortable = sortable;
    }

    @Column(name = "maxlength")
    public Integer getMaxlength() {
        return this.maxlength;
    }

    public void setMaxlength(Integer maxlength) {
        this.maxlength = maxlength;
    }

    @Column(name = "width")
    public Integer getWidth() {
        return this.width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    @Column(name = "height")
    public Integer getHeight() {
        return this.height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    @Column(name = "name", nullable = false, length = 20)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description", length = 100)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "input_type", nullable = false, length = 20)
    public String getInputType() {
        return this.inputType;
    }

    public void setInputType(String inputType) {
        this.inputType = inputType;
    }

    @Column(name = "default_value", length = 50)
    public String getDefaultValue() {
        return this.defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    @Column(name = "dictionary_id", length = 20)
    public String getDictionaryId() {
        return this.dictionaryId;
    }

    public void setDictionaryId(String dictionaryId) {
        this.dictionaryId = dictionaryId;
    }

    @Column(name = "multiple", nullable = false)
    public boolean isMultiple() {
        return this.multiple;
    }

    public void setMultiple(boolean multiple) {
        this.multiple = multiple;
    }

    @Column(name = "sort", nullable = false)
    public int getSort() {
        return this.sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

}
