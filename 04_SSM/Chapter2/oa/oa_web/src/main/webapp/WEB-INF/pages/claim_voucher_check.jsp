<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sping" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.jesse.oa.global.Constant" %>
<jsp:include page="top.jsp"/>

<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> 处理报销单 </h2>
            <p class="lead"></p>
        </div>
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div class="panel heading-border">
                <div class="panel-body bg-light">
                    <div class="section-divider mt20 mb40">
                        <span> 基本信息 </span>
                    </div>
                    <div class="section row">
                        <div class="col-md-2">事由</div>
                        <div class="col-md-6">${claimVoucher.cause}</div>
                    </div>
                    <div class="section row">
                        <div class="col-md-2">创建人</div>
                        <div class="col-md-4">${claimVoucher.creater.name}</div>
                        <div class="col-md-2">创建时间</div>
                        <div class="col-md-4"><sping:eval expression="claimVoucher.createTime"/></div>
                    </div>
                    <div class="section row">
                        <div class="col-md-2">待处理人</div>
                        <div class="col-md-4">${claimVoucher.dealer.name}</div>
                        <div class="col-md-2">状态</div>
                        <div class="col-md-4">${claimVoucher.status}</div>
                    </div>
                    <div class="section-divider mt20 mb40">
                        <span> 费用明细 </span>
                    </div>
                    <div class="section row">
                        <c:forEach items="${items}" var="item">
                        <div class="col-md-3">${item.item}</div>
                        <div class="col-md-3">${item.amount}</div>
                        <div class="col-md-5">${item.comment}</div>
                        </c:forEach>
                    </div>
                    <div class="section row">
                        <div class="col-md-2">总金额</div>
                        <div class="col-md-6">${claimVoucher.totalAmount}</div>
                    </div>
                    <div class="section-divider mt20 mb40">
                        <span> 处理流程 </span>
                    </div>
                    <div class="section row">
                        <c:forEach items="${records}" var="record">
                        <div class="col-md-1">${record.dealer.name}</div>
                        <div class="col-md-3"><sping:eval expression="record.dealTime"/></div>
                        <div class="col-md-1">${record.dealWay}</div>
                        <div class="col-md-2">${record.dealResult}</div>
                        <div class="col-md-5">${record.comment}</div>
                        </c:forEach>
                    </div>
                    <form:form id="admin-form" name="addForm" action="/claim_voucher/check" modelAttribute="record">
                        <form:hidden path="claimVoucherId"/>
                        <input id="dealWay" name="dealWay" type="hidden" value=""/>
                        <div class="panel-body bg-light">
                            <div class="section">
                                <label for="comment" class="field prepend-icon">
                                    <form:input path="comment" cssClass="gui-input" placeholder="备注..."/>
                                    <label for="comment" class="field-icon">
                                        <i class="fa fa-lock"></i>
                                    </label>
                                </label>
                            </div>
                            <div class="panel-footer text-right">

                                <c:if test="${sessionScope.employee.post==Constant.POST_FM || sessionScope.employee.post==Constant.POST_GM}">
                                <button type="button" class="button" onclick="javascript:addForm.dealWay.value='${Constant.DEAL_PASS}'; addForm.submit();">${Constant.DEAL_PASS}</button>
                                <button type="button" class="button" onclick="javascript:addForm.dealWay.value='${Constant.DEAL_BACK}'; addForm.submit();">${Constant.DEAL_BACK}</button>
                                <button type="button" class="button" onclick="javascript:addForm.dealWay.value='${Constant.DEAL_REJECT}'; addForm.submit();">${Constant.DEAL_REJECT}</button>
                                </c:if>

                                <c:if test="${sessionScope.employee.post==Constant.POST_CASHIER}">
                                 <button type="button" class="button" onclick="javascript:addForm.dealWay.value='${Constant.DEAL_PAID}'; addForm.submit();">${Constant.DEAL_PAID}</button>
                                </c:if>

                                <button type="button" class="button" onclick="javascript:window.history.go(-1);"> 返回 </button>
                            </div>
                        </div>
                    </form:form>
                    <div class="panel-footer text-right">
                        <button type="button" class="button" onclick="javascript:window.history.go(-1);"> 返回 </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<jsp:include page="bottom.jsp"/>
