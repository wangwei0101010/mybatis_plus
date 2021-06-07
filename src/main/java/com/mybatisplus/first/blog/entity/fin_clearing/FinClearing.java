package com.mybatisplus.first.blog.entity.fin_clearing;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author wangwei
 * @since 2021-06-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="FinClearing对象", description="")
public class FinClearing implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "清分数据id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "父级清分单id")
    private Long parentFinId;

    @ApiModelProperty(value = "清分规则编号")
    private Long clearingRuleId;

    @ApiModelProperty(value = "付款方商户编号")
    private String payerOuCode;

    @ApiModelProperty(value = "机构编码")
    private String ouCode;

    @ApiModelProperty(value = "业务类型： 1.清分 2.分润")
    private Integer bussType;

    @ApiModelProperty(value = "产权单位")
    private String stakeOuCode;

    @ApiModelProperty(value = "本次清分周期日")
    private String thisClearingDay;

    @ApiModelProperty(value = "上个清分周期日")
    private String prevClearingDay;

    @ApiModelProperty(value = "清分时间")
    private Date clearingTime;

    @ApiModelProperty(value = "清分月份")
    private String clearingMonth;

    @ApiModelProperty(value = "清分方式（手动、自动）")
    private Integer clearingWay;

    @ApiModelProperty(value = "清分数据类型 1-本月汇总  2-历史汇总")
    private Integer clearingDataType;

    @ApiModelProperty(value = "清分子类型 1.普通清分 2.车电包清分3.社会共享桩")
    private Integer finSubType;

    @ApiModelProperty(value = "交易笔数")
    private Integer clearingTradeCount;

    @ApiModelProperty(value = "汇总的交易电量")
    private BigDecimal clearingTotalElecty;

    @ApiModelProperty(value = "汇总电费")
    private BigDecimal clearingElecAmount;

    @ApiModelProperty(value = "汇总服务费")
    private BigDecimal clearingServiceAmount;

    @ApiModelProperty(value = "汇总交易金额")
    private BigDecimal clearingAmount;

    @ApiModelProperty(value = "汇总抄表电量")
    private BigDecimal clearingStakeRunElecty;

    @ApiModelProperty(value = "差额电量")
    private BigDecimal clearingDiffElecty;

    @ApiModelProperty(value = "该收单机构承担的电子券费用")
    private BigDecimal clearingCouAmount;

    @ApiModelProperty(value = "清分电量=汇总电量*****差异电量")
    private BigDecimal settleTotalElecty;

    @ApiModelProperty(value = "清分电费=汇总电费--商户应承担电子券费用")
    private BigDecimal settleElecAmount;

    @ApiModelProperty(value = "清分服务费=汇总服务费--商户应承担电子券费用")
    private BigDecimal settleServiceAmount;

    @ApiModelProperty(value = "清分金额")
    private BigDecimal settleAmount;

    @ApiModelProperty(value = "1-待提交  2-已提交  3-待商户确认  4-商户已确认")
    private Integer status;

    @ApiModelProperty(value = "提交人员id【电动汽车】")
    private Long applyOperator;

    @ApiModelProperty(value = "提交时间")
    private Date applyTime;

    @ApiModelProperty(value = "提交人员的机构编码")
    private String applyOuCode;

    @ApiModelProperty(value = "结算单id")
    private Long finSettleId;

    @ApiModelProperty(value = "来源结算单id")
    private Long originalSettleId;

    @ApiModelProperty(value = "清算单位")
    private String clearingUnitCode;

    @ApiModelProperty(value = "汇总优惠后交易金额")
    private BigDecimal clearingActAmount;

    @ApiModelProperty(value = "汇总优惠金额")
    private BigDecimal clearingDiscountAmount;

    @ApiModelProperty(value = "汇总优惠后服务费")
    private BigDecimal clearingActServiceAmount;

    @ApiModelProperty(value = "清分优惠笔数")
    private Integer clearingActCount;

    @ApiModelProperty(value = "服务费清分比例")
    private BigDecimal servicePercent;

    @ApiModelProperty(value = "电费清分比例")
    private BigDecimal electricPercent;

    @ApiModelProperty(value = "服务费比例，各级")
    private String servicePercentStr;

    @ApiModelProperty(value = "电费比例，各级")
    private String electricPercentStr;

    @ApiModelProperty(value = "本级优惠金额")
    private BigDecimal currentDiscountAmount;

    @ApiModelProperty(value = "本级电费优惠金额")
    private BigDecimal currentElecDiscountAmount;

    @ApiModelProperty(value = "本级服务费优惠金额")
    private BigDecimal currentServiceDiscountAmount;

    @ApiModelProperty(value = "下级优惠金额")
    private BigDecimal lowerDiscountAmount;

    @ApiModelProperty(value = "下级电费优惠金额")
    private BigDecimal lowerElecDiscountAmount;

    @ApiModelProperty(value = "下级服务费优惠金额")
    private BigDecimal lowerServiceDiscountAmount;

    @ApiModelProperty(value = "退补电费")
    private BigDecimal retreatElecAmount;

    @ApiModelProperty(value = "退补服务费")
    private BigDecimal retreatServiceAmount;

    @ApiModelProperty(value = "退补金额")
    private BigDecimal retreatAmount;

    @ApiModelProperty(value = "清分退补电费")
    private BigDecimal clearingRetreatElecAmount;

    @ApiModelProperty(value = "清分退补服务费")
    private BigDecimal clearingRetreatServiceAmount;

    @ApiModelProperty(value = "清分退补金额")
    private BigDecimal clearingRetreatAmount;

    @ApiModelProperty(value = "政策性退补订单数")
    private Integer retreatCount;

    @ApiModelProperty(value = "分润服务费比例")
    private BigDecimal profitServicePercent;

    @ApiModelProperty(value = "分润电费比例")
    private BigDecimal profitElectricPercent;

    @ApiModelProperty(value = "划拨单id")
    private String finTransferId;

    @ApiModelProperty(value = "业务类型 1.充值 2.充电 3.换电 4.岸电 2001.合作建桩")
    private Integer chargBussType;

    @ApiModelProperty(value = "标记异常电费金额")
    private BigDecimal markOrderElecAmount;

    @ApiModelProperty(value = "标记异常服务费金额")
    private BigDecimal markOrderServiceAmount;

    @ApiModelProperty(value = "标记异常金额")
    private BigDecimal markOrderAmount;

    @ApiModelProperty(value = "车电包本部承担属地优惠")
    private BigDecimal bearDiscount;

    @ApiModelProperty(value = "标记异常表车电包本部承担属地优惠")
    private BigDecimal markOrderBearDiscount;

    @ApiModelProperty(value = "8001社区共享 0非社区共享")
    private Integer orderChannel;


}
