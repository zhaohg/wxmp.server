package com.wxmp.oauth.service.security;

/**
 * @author zhaohg
 * @date 2019/06/25.
 */
//@Service
//public class ClientDetailServiceImpl implements ClientDetailsService {
//
//    @Resource
//    private FeignClientService clientService;
//
//    @Override
//    public ClientDetails loadClientByClientId(String clientId) {
//        Result result = clientService.loadClientByClientId(clientId);
//        if (result.getCode() != StatusCode.SUCCESS_CODE) {
//            throw new UsernameNotFoundException("客户端:" + clientId + ", 不存在!");
//        }
//        return JSON.parseObject(JSONObject.toJSONString(result.getData()), ClientDetails.class);
//    }
//
//}
