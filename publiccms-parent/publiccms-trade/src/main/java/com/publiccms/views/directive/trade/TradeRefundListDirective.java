package com.publiccms.views.directive.trade;

// Generated 2019-6-15 20:08:45 by com.publiccms.common.generator.SourceGenerator
import java.io.IOException;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;

import com.publiccms.common.base.AbstractTemplateDirective;
import com.publiccms.common.handler.PageHandler;
import com.publiccms.common.handler.RenderHandler;
import com.publiccms.logic.service.trade.TradeRefundService;

import freemarker.template.TemplateException;

/**
 *
 * tradeRefundList 退款列表查询指令
 * <p>
 * 参数列表
 * <ul>
 * <li><code>userId</code> 用户id
 * <li><code>paymentId</code> 支付id
 * <li><code>refundUserId</code> 退款操作用户id
 * <li><code>status</code> 状态,【0:待处理,1:已退款,2:取消,3:拒绝,4:失败】
 * <li><code>startCreateDate</code> 起始创建日期,【2020-01-01 23:59:59】,【2020-01-01】
 * <li><code>endCreateDate</code> 终止创建日期,【2020-01-01 23:59:59】,【2020-01-01】
 * <li><code>orderType</code> 排序类型,【asc:正序,desc:倒叙】,默认为创建日期倒叙
 * <li><code>pageIndex</code> 页码
 * <li><code>pageSize</code> 每页条数
 * </ul>
 * <p>
 * 返回结果
 * <ul>
 * <li><code>page</code> {@link com.publiccms.common.handler.PageHandler}
 * <li><code>page.list</code> List类型 查询结果实体列表
 * {@link com.publiccms.entities.trade.TradeRefund}
 * </ul>
 * 使用示例
 * <p>
 * &lt;@trade.refundList pageSize=10&gt;&lt;#list page.list as
 * a&gt;${a.amount}&lt;#sep&gt;,&lt;/#list&gt;&lt;/@trade.refundList&gt;
 * 
 * <pre>
&lt;script&gt;
$.getJSON('${site.dynamicPath}api/directive/trade/refundList?pageSize=10&amp;authToken=用户登录Token&amp;authUserId=用户id', function(data){    
 console.log(data.page.totalCount);
});
&lt;/script&gt;
 * </pre>
 */
@Component
public class TradeRefundListDirective extends AbstractTemplateDirective {

    @Override
    public void execute(RenderHandler handler) throws IOException, TemplateException{
        PageHandler page = service.getPage(getSite(handler).getId(), getUserId(handler, "userId"), handler.getLong("paymentId"),
                handler.getLong("refundUserId"), handler.getInteger("status"), handler.getString("orderType"),
                handler.getInteger("pageIndex", 1), handler.getInteger("pageSize", 30));
        handler.put("page", page).render();
    }

    @Override
    public boolean needUserToken() {
        return true;
    }

    @Resource
    private TradeRefundService service;
}