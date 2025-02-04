package com.publiccms.logic.dao.cms;

// Generated 2020-3-26 11:46:48 by com.publiccms.common.generator.SourceGenerator

import org.springframework.stereotype.Repository;

import com.publiccms.common.base.BaseDao;
import com.publiccms.common.handler.PageHandler;
import com.publiccms.common.handler.QueryHandler;
import com.publiccms.common.tools.CommonUtils;
import com.publiccms.entities.cms.CmsUserVote;

/**
 *
 * CmsUserVoteDao
 * 
 */
@Repository
public class CmsUserVoteDao extends BaseDao<CmsUserVote> {

    /**
     * @param userId
     * @param voteId
     * @param anonymous
     * @param orderType
     * @param pageIndex
     * @param pageSize
     * @return results page
     */
    public PageHandler getPage(Long userId, Long voteId, Boolean anonymous, String orderType, Integer pageIndex,
            Integer pageSize) {
        QueryHandler queryHandler = getQueryHandler("from CmsUserVote bean");
        if (null != userId) {
            queryHandler.condition("bean.id.userId = :userId").setParameter("userId", userId);
        }
        if (null != voteId) {
            queryHandler.condition("bean.id.voteId = :voteId").setParameter("voteId", voteId);
        }
        if (null != anonymous) {
            queryHandler.condition("bean.anonymous = :anonymous").setParameter("anonymous", anonymous);
        }
        if (!ORDERTYPE_ASC.equalsIgnoreCase(orderType)) {
            orderType = ORDERTYPE_DESC;
        }
        queryHandler.order("bean.createDate ").append(orderType);
        return getPage(queryHandler, pageIndex, pageSize);
    }

    @Override
    protected CmsUserVote init(CmsUserVote entity) {
        if (null == entity.getCreateDate()) {
            entity.setCreateDate(CommonUtils.getDate());
        }
        return entity;
    }

}