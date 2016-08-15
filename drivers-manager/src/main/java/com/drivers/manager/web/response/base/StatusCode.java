package com.drivers.manager.web.response.base;

import com.drivers.manager.exceptions.ExistedStatusCodeException;

import java.util.HashMap;
import java.util.Map;

/**
 * @Date: 14-10-8
 * @Time: 下午4:22
 */
public enum StatusCode {
    OK(1000, "操作成功"),
    ValidateError(1001, "数据验证失败"),
    ValidateErrorHttpMessageNotReadable(1002, "数据验证失败,输入数据有误或者格式错误 "),
    ValidateErrorDataHasExisted(1003, "该数据已经存在了，不能重复创建"),
    //pad端变态要求，和1103一个含义
    UnSupportedBusiness(1004, "不支持的业务"),
    //pad端变态要求，和1103一个含义

    BusinessOperationFailed(1100, "业务操作失败"),
    Business_TS_MEGER(1101, "该桌台上有待合并的订单。"),
    BusinessDataHasBeenUpdated(1102, "该数据已经被其他客户端更新"),
    BusinessDataHasExisted(1103, "该数据已经存在了，不能重复创建"),
    BusinessDataHasNotExisted(1109, "该数据不存在。"),
    BusinessTableIsBusy(1104, "该桌台被占用."),
    BusinessTableNotClear(1105, "该桌台未清台."),
    BusinessTableNoEqual(1106, "客户端桌台状态与服务器上不一致"),
    BusinessNoTable(1107, "该桌台不存在."),
    BusinessCashError(1108, "消费储值或优惠劵失败"),
    BusinessPartialFailed(1110, "部分失败"),
    //短信
    BusinessNoSurplusCount(1111, "短信余额不足，请充值"),
    BusinessNoSmsTemplate(1112, "缺少短信模板，请配置"),
    SMS_SEND_ERROR(1113, "发送短信出错"),
    SMS_SEND_FAILED(1114, "发送短信失败"),
    SMS_GALLERY_ERROR(1127, "缺少短信通道或配置错误"),
    //排队业务
    BusinessCantMatchedQueueLine(1120, "不能找到合适的排队代号"),
    
    BusinessNoInDateQueueLine(1129, "排队入场时间不能为空"),

    //新订单业务
    BusinessServerDataError(1115, "服务器数据错误！"),
    BusinessServerTradeItemPropertyDataError(1116, "TradeItemProperty  uuid关联出错！"),
    BusinessServerTradeItemLogDataError(1117, "TradeItemLog  uuid关联出错！"),
    BusinessServerTradeNoDataError(1201, "Trade  该订单号创建重复！"),
    BusinessServerTradePaidError(1202, "Trade  该订单已支付！"),
    BusinessServerTradeStatusError(1203, "订单状态错误"),
    BusinessServerTradeNumLimit(1204, "一台多单设置,该桌台订单超过最大数量"),
    PaymentConfirmed(1205,"已确认收款，不能重复操作"),
    TradePayStatusError(1206,"订单支付状态错误"),
    TradeHasBindable(1207,"订单已绑定桌台"),

    //会员业务
    BusinessPasswordError(1118, "会员消费密码不匹配！"),
    BusinessMoneyLessError(1119, "会员卡上余额不足！"),
    BusinessPhoneNullError(1121, "会员手机号为空！"),
    BusinessDoubleSubmitError(1122, "会员消费重复提交！"),
    BusinessPasswordNullError(1123, "会员消费密码不能为空！"),
    BusinessIsNotMember(1124, "不是会员！"),
    BusinessMemberHasAddValueCard(1125, "会员已充值！"),
    BusinessMemberDisable(1126, "当前帐号已被冻结，请前往后台操作"),
    BusinessCheckCodeError(1130, "验证码错误或过期"),
    BusinessExchangeCashError(1131, "积分抵现失败"),
    BusinessValueCardSubError(1132, "会员卡消费失败"),
    //会员升级失败错误信息
    BusinessMemberUpgradeError(1133, "会员升级失败 ."),
    BusinessMemberUpgradeError_1(1134, "增加customer失败，会员升级失败."),
    BusinessMemberUpgradeError_2(1135, "已经是会员，不可以再进行升级，会员升级失败"),
    BusinessMemberUpgradeError_3(1136, "会员等级表(customer_level)初始化一条记录失败导致会员升级失败。"),

    UseCouponError(1137, "验券失败"),

    BusinessHasNoHandover(1140, "有未交接的收银记录"),
    BusinessHasNoRepayIfClosing(1141, "已关账订单不允许反结账"),

    //退货退款相关
    BusinessOnlineRefundError(1700, "在线退款失败"),
    BusinessCannotOnlineRefundError(1701, "在线退款失败,该订单无在线支付金额!"),
    BusinessUnSupportedPayModeError(1702, "不支持该在线支付方式!"),
    UnSupportedPayNotify(1703,"订单当前状态不支持处理该支付结果通知"),
    UnSupportedRefund(1704,"订单当前状态不支持处理该退款结果通知"),
    RepeatPayNotify(1705,"重复的支付通知"),
    RepeatRefundNotify(1706,"重复的退款通知"),
    DepositNotExists(1707,"该订单没有押金信息"),
    DepositRefunded(1708,"该订单押金已退还"),
    DepositRefundTooLarge(1709,"退还押金过多，超过了收取的押金总金额"),
    NoDepositPayment(1710,"没有押金支付信息"),
    PaymentItemStatusError(1711,"支付详情状态错误"),
    PaymentItemAmountError(1712,"支付详情金额错误"),
    /**
     * 服务器内部错误
     */
    InternalServerErrorForBusiness(2000, "服务器内部错误"),
    InternalServerErrorForTomcat(2001, "服务器内部错误"),
    InternalServerExceptionForTomcat(2002, "服务器内部错误"),
    InternalServerDataAccessException(2003, "输入数据有误或者数据库错误"),

    //调用h5订单接口业务 added by fw 2015-6-3
    HttpInvokeFailed(3001, "调用ch5接口失败"),
    BusinessTimeoutError(3002, "超时错误"),
    OrderStatusUnSupported(3003,"订单状态不支持"),
    OrderStatusError(3004,"订单状态错误"),
    UnSupportedOperation(3005,"不支持该操作"),
    GatewayHttpInvokedFailed(3006, "调用Gateway接口失败"), //for Gateway error msg
    
    //优惠券相关
    BusinessServerCheckCouponError(1301,"优惠券验证失败！"),
    BusinessServerCheckWxCardError(1302,"微信卡券验证失败！"),

    //手机助手
    UserPasswordError(4001, "用户账号或密码错误"),
    NotOutSeller(4002, "该用户不是外卖员"),
    NotManager(4003, "该用户不是管理员"),
    NotOrderTaker(4004, "该用户不是接单员"),
    NonSupport(4005, "暂不支持管理员登录"),
    
    //RAS加密解密
    RSA_encrypt_error(5001,"rsa加密出错"),
    RSA_decrypt_error(5002,"rsa解密出错"),
    RSA_handle_error(5010,"rsa处理出错"),
    RSA_validate_error(5011,"签名验证不通过"),
    
    //微信被扫支付超过6次需要输入用户名和密码
    GKBS_NEED_PWD(6001,"需要输入用户名和密码"),
    GKBS_UNSUPPORTED(6002, "暂不支持该支付方式"),

    //调用loyal
    BusinessLoyalError(1200,"调用loyal接口错误"),
	
	//onmobile业务码
	BusinessDataTradeStatusHasFinish(7001, "订单已提交"),
	BusinessDataTradeStatusHasInvalid(7002, "订单已作废"),

    //分布式锁
    LOCK_FAIL(8000,"获取锁失败"),
    
    //payment_item_extra.seller_account_type
    SEllER_ACCOUNT_TYPE_EMPTY(9000, "POS没有支付权限");
	

    private int code;
    private String message;
    private static Map<Integer, StatusCode> cachedMap = new HashMap<Integer, StatusCode>();

    static {
        for (StatusCode rc : StatusCode.values()) {
            if (cachedMap.containsKey(rc.code)) {
                throw new ExistedStatusCodeException("重复的状态码: " + rc.toString());
            }
            cachedMap.put(rc.code, rc);
        }
    }

    StatusCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static StatusCode getStatusCode(int code) {
        return valueOf(code);
    }

    public static StatusCode valueOf(int code) {
        return cachedMap.get(code);
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @Override
    public String toString() {
        return "StatusCode:[code=" + code + ",message=" + message + "]";
    }

}
