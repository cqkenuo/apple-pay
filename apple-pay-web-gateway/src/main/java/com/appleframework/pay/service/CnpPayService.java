package com.appleframework.pay.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.appleframework.pay.common.core.enums.SecurityRatingEnum;
import com.appleframework.pay.common.core.utils.StringUtil;
import com.appleframework.pay.trade.exception.TradeBizException;
import com.appleframework.pay.user.entity.RpUserPayConfig;
import com.appleframework.pay.utils.NetworkUtil;

@Service(value = "cnpPayService")
public class CnpPayService {

    private static final Logger LOG = LoggerFactory.getLogger(CnpPayService.class);

    /**
     *
     * @param rpUserPayConfig
     * @param httpServletRequest
     */
    public void checkIp(RpUserPayConfig rpUserPayConfig, HttpServletRequest httpServletRequest) {
        try {

            if (!SecurityRatingEnum.MD5_IP.name().equals(rpUserPayConfig.getSecurityRating())) {
                return;
            }

            String ip = NetworkUtil.getIpAddress(httpServletRequest);
            if (StringUtil.isEmpty(ip)) {
                throw new TradeBizException(TradeBizException.TRADE_PARAM_ERROR, "获取请求IP错误");
            }

            String merchantServerIp = rpUserPayConfig.getMerchantServerIp();
            if (merchantServerIp.indexOf(ip) < 0) {
                throw new TradeBizException(TradeBizException.TRADE_PARAM_ERROR, "非法IP请求");
            }

        } catch (IOException e) {
            LOG.error("获取请求IP异常:", e);
            throw new TradeBizException(TradeBizException.TRADE_PARAM_ERROR, "获取请求IP异常");
        }
    }

}
