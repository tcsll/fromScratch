// package com.config;
//
//
// import com.diyi.logisticsservice.annotation.LoginRequired;
// import com.diyi.logisticsservice.entity.token.CookieEntity;
// import com.diyi.logisticsservice.entity.token.TokenValidResult;
// import com.diyi.logisticsservice.service.TokenService;
// import com.diyi.logisticsservice.util.constant.TokenConst;
// import com.diyi.logisticsservice.util.result.ResultGenerator;
// import lombok.extern.slf4j.Slf4j;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.lang.Nullable;
// import org.springframework.web.method.HandlerMethod;
// import org.springframework.web.servlet.HandlerInterceptor;
// import org.springframework.web.servlet.ModelAndView;
//
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
//
// import static com.diyi.logisticsservice.util.constant.ParamConst.*;
//
//
// /**
//  * Controller拦截器
//  *
//  * @author huangsn
//  * @date 2019-05-07 19:16
//  */
// @Slf4j
// public class ControllerInterceptor implements HandlerInterceptor {
//
//     // @Autowired
//     // private TokenService tokenService;
//
//     /**
//      * Controller执行之前调用
//      *
//      * @param request
//      * @param response
//      * @param handler
//      * @return
//      * @throws Exception
//      */
//     @Override
//     public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//         try {
//             if (handler.getClass().equals(HandlerMethod.class)) {
//                 HandlerMethod handlerMethod = (HandlerMethod) handler;
//                 LoginRequired loginRequired = handlerMethod.getMethod().getAnnotation(LoginRequired.class);
//                 if (null != loginRequired) {
//                     // 若方法有@LoginRequired注解，说明需要认证
//                     CookieEntity cookieEntity = tokenService.getCookie(request);
//                     // 校验token
//                     if (cookieEntity.isReady()) {
//                         TokenValidResult tokenValidResult = tokenService.getTokenValidResult(cookieEntity.getClientId(),
//                                 cookieEntity.getToken());
//                         if (tokenValidResult.getResultCode() != TokenConst.TOKEN_STATUS_OK) {
//                             String validResult = "";
//                             if (null != tokenValidResult.getResult()) {
//                                 validResult = tokenValidResult.getResult().toString();
//                             }
//                             response.setHeader("Content-type", "application/json;charset=UTF-8");
//                             response.setCharacterEncoding("UTF-8");
//                             response.getWriter().print(validResult);
//                             return false;
//                         } else {
//                             request.setAttribute(PARAM_USER_ID, tokenValidResult.getUserId());
//                             request.setAttribute(PARAM_STATION_ID, tokenValidResult.getStationId());
//                             request.setAttribute(PARAM_JOB_NUMBER, tokenValidResult.getJobNumber());
//                             request.setAttribute(PARAM_PHONE, tokenValidResult.getPhone());
//                             //request.setAttribute(PARAM_DRIVER_ID, tokenValidResult.getDriverId());
//                             return true;
//                         }
//                     } else {
//                         // Token不存在时直接报认证失败错误
//                         response.setHeader("Content-type", "application/json;charset=UTF-8");
//                         response.setHeader("Access-Control-Allow-Origin", "*");
//                         response.setCharacterEncoding("UTF-8");
//                         response.getWriter().print(ResultGenerator.genUnauthorizedResult());
//                         return false;
//                     }
//                 } else {
//                     // 无@LoginRequired注解则无需认证
//                     return true;
//                 }
//             } else {
//                 // 非HandlerMethod则交由Spring来处理
//                 return true;
//             }
//         } catch (Exception e) {
//             log.error(e.getMessage());
//             response.setHeader("Content-type", "application/json;charset=UTF-8");
//             response.setCharacterEncoding("UTF-8");
//             response.getWriter().print(ResultGenerator.genInnerErrResult(e.getMessage()));
//             e.printStackTrace();
//             return false;
//         }
//     }
//
//     /**
//      * Controller执行之后，页面渲染之前调用
//      *
//      * @param request
//      * @param response
//      * @param handler
//      * @param modelAndView
//      * @throws Exception
//      */
//     @Override
//     public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//                            @Nullable ModelAndView modelAndView) throws Exception {
//     }
//
//     /**
//      * 页面渲染之后调用，一般用于资源清理操作
//      *
//      * @param request
//      * @param response
//      * @param handler
//      * @param ex
//      * @throws Exception
//      */
//     @Override
//     public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
//
//     }
//
// }
