package com.publiccms.logic.component.parameter;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Priority;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.publiccms.common.api.Config;
import com.publiccms.common.base.AbstractLongParameterHandler;
import com.publiccms.common.tools.CmsUrlUtils;
import com.publiccms.common.tools.ExtendUtils;
import com.publiccms.entities.cms.CmsContent;
import com.publiccms.entities.sys.SysSite;
import com.publiccms.logic.component.config.ContentConfigComponent;
import com.publiccms.logic.component.site.FileUploadComponent;
import com.publiccms.logic.component.site.StatisticsComponent;
import com.publiccms.logic.service.cms.CmsContentAttributeService;
import com.publiccms.logic.service.cms.CmsContentService;
import com.publiccms.views.pojo.entities.ClickStatistics;

/**
 * ContentParameterHandlerComponent 内容参数处理组件
 */
@Component
@Priority(3)
public class ContentParameterComponent extends AbstractLongParameterHandler<CmsContent> {
    @Resource
    private CmsContentService service;
    @Resource
    private CmsContentAttributeService attributeService;
    @Resource
    protected FileUploadComponent fileUploadComponent;
    @Resource
    protected ContentConfigComponent contentConfigComponent;
    @Resource
    private StatisticsComponent statisticsComponent;

    @Override
    public String getType() {
        return Config.INPUTTYPE_CONTENT;
    }

    @Override
    public List<CmsContent> getParameterValueList(SysSite site, Long[] ids) {
        List<CmsContent> entityList = service.getEntitys(ids);
        entityList = entityList.stream().filter(entity -> site.getId() == entity.getSiteId()).collect(Collectors.toList());
        entityList.forEach(e -> {
            ClickStatistics statistics = statisticsComponent.getContentStatistics(e.getId());
            if (null != statistics) {
                e.setClicks(e.getClicks() + statistics.getClicks());
            }
            CmsUrlUtils.initContentUrl(site, e);
            fileUploadComponent.initContentCover(site, e);
        });
        return entityList;
    }

    @Override
    public CmsContent getParameterValue(SysSite site, Long id) {
        CmsContent entity = service.getEntity(id);
        if (null != entity && !entity.isDisabled() && entity.getSiteId() == site.getId()) {
            ClickStatistics statistics = statisticsComponent.getContentStatistics(entity.getId());
            if (null != statistics) {
                entity.setClicks(entity.getClicks() + statistics.getClicks());
            }
            CmsUrlUtils.initContentUrl(site, entity);
            fileUploadComponent.initContentCover(site, entity);
            entity.setAttribute(ExtendUtils.getAttributeMap(attributeService.getEntity(entity.getId()),
                    contentConfigComponent.getKeywordsConfig(site.getId())));
            return entity;
        }
        return null;
    }
}
