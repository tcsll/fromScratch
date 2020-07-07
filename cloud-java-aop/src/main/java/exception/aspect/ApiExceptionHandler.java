// package exception.aspect;
//
// import com.demo.util.Response;
// import com.demo.util.ResponseUtil;
// import com.demo.util.ResultEnum;
// import com.demo.util.ServiceException;
// import lombok.extern.slf4j.Slf4j;
// import org.springframework.validation.BindingResult;
// import org.springframework.validation.ObjectError;
// import org.springframework.web.bind.MethodArgumentNotValidException;
// import org.springframework.web.bind.annotation.ExceptionHandler;
// import org.springframework.web.bind.annotation.RestControllerAdvice;
//
// /**
//  * @Created by jiang.jiayang on 2019-05-05.
//  * @Version v1.0
//  * @description 统一异常处理类
//  * # @CopyRight 2003-2019 浩鲸云计算科技股份有限公司 版权所有| All Rights Reserved
//  */
// @Slf4j
// @RestControllerAdvice
// public class ApiExceptionHandler {
//
//     //业务异常
//     @ExceptionHandler(ServiceException.class)
//     public Response serviceExceptionHandler(ServiceException ex) {
//         return new Response(null, ex.getCode() + "", ex.getMessage());
//     }
//     //参数校验异常
//     @ExceptionHandler(MethodArgumentNotValidException.class)
//     public Response argumentExceptionHandler(MethodArgumentNotValidException ex) {
//         StringBuilder message = new StringBuilder();
//         BindingResult bindingResult = ex.getBindingResult();
//         for(ObjectError error:bindingResult.getAllErrors()){
//             message.append(error.getDefaultMessage());
//         }
//         return ResponseUtil.error(ResultEnum.PARAM_ERROR,message.toString());
//     }
// //    //数据库网络异常
// //    @ExceptionHandler(MyBatisSystemException.class)
// //    public Response mybatisExceptionHandler(MyBatisSystemException ex) {
// //        //0、获取日志序列
// //        logger.warn("异常:" + ex.getMessage(), ex);
// //        return ResponseUtil.error(ResultEnum.FAIL);
// //    }
// //
// //    //数据库网络异常
// //    @ExceptionHandler(UncategorizedSQLException.class)
// //    public Response sqlExceptionHandler(UncategorizedSQLException ex) {
// //        //0、获取日志序列
// //        logger.warn("异常:" + ex.getMessage(), ex);
// //        return ResponseUtil.error(ResultEnum.FAIL);
// //    }
// //    //以下为通用异常处理
// //    //运行时异常
// //    @ExceptionHandler(RuntimeException.class)
// //    public Response runtimeExceptionHandler(RuntimeException ex) {
// //        logger.warn(String.format("异常:%s",ex.getMessage()), ex);
// //        return ResponseUtil.error(ResultEnum.RUNTIME_ERROR);
// //    }
// //
//     //空指针异常
//     @ExceptionHandler(NullPointerException.class)
//     public Response nullPointerExceptionHandler(NullPointerException ex) {
// //        logger.warn("异常:" + ex.getMessage(), ex);
//         return ResponseUtil.error(ResultEnum.NULL_POINT);
//     }
//
// //    //类型转换异常
// //    @ExceptionHandler(ClassCastException.class)
// //    public Response classCastExceptionHandler(ClassCastException ex) {
// //        logger.warn("异常:" + ex.getMessage(), ex);
// //        return ResponseUtil.error(ResultEnum.FAIL);
// //    }
// //
// //    //IO异常
// //    @ExceptionHandler(IOException.class)
// //    public Response iOExceptionHandler(ClassCastException ex) {
// //        logger.warn("异常:" + ex.getMessage(), ex);
// //        return ResponseUtil.error(ResultEnum.IO_error);
// //    }
// //
// //    //未知方法异常
// //    @ExceptionHandler(NoSuchMethodException.class)
// //    public Response noSuchMethodExceptionHandler(NoSuchMethodException ex) {
// //        logger.warn("异常:" + ex.getMessage(), ex);
// //        return ResponseUtil.error(ResultEnum.UNKNOW_ERROR);
// //    }
// //
// //    //数组越界异常
// //    @ExceptionHandler(IndexOutOfBoundsException.class)
// //    public Response indexOutOfBoundsExceptionHandler(IndexOutOfBoundsException ex) {
// //        logger.warn("异常:" + ex.getMessage(), ex);
// //        return ResponseUtil.error(ResultEnum.IndexOutOfBounds);
// //    }
// //
// //
// //    //400错误
// //    @ExceptionHandler(HttpMessageNotReadableException.class)
// //    public Response requestNotReadable(HttpMessageNotReadableException ex) {
// //        logger.warn("异常:" + ex.getMessage(), ex);
// //        return ResponseUtil.error(ResultEnum.FAIL);
// //    }
// //
// //    //400错误
// //    @ExceptionHandler(TypeMismatchException.class)
// //    public Response requestTypeMismatch(TypeMismatchException ex) {
// //        logger.warn("异常:" + ex.getMessage(), ex);
// //        return ResponseUtil.error(ResultEnum.FAIL);
// //    }
// //
// //    //400错误
// //    @ExceptionHandler(MissingServletRequestParameterException.class)
// //    public Response requestMissingServletRequest(MissingServletRequestParameterException ex) {
// //        logger.warn("异常:" + ex.getMessage(), ex);
// //        return ResponseUtil.error(ResultEnum.FAIL);
// //    }
// //
// //    //405错误
// //    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
// //    public Response request405(HttpRequestMethodNotSupportedException ex) {
// //        logger.warn("异常:" + ex.getMessage(), ex);
// //        return ResponseUtil.error(ResultEnum.ERROR_405);
// //    }
// //
// //    //406错误
// //    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
// //    public Response request406(HttpMediaTypeNotAcceptableException ex) {
// //        logger.warn("异常:" + ex.getMessage(), ex);
// //        return ResponseUtil.error(ResultEnum.ERROR_406);
// //    }
// //
// //    //500错误
// //    @ExceptionHandler({ConversionNotSupportedException.class, HttpMessageNotWritableException.class})
// //    public Response server500(RuntimeException ex) {
// //        logger.warn("异常:" + ex.getMessage(), ex);
// //        return ResponseUtil.error(ResultEnum.INTERNAL_SERVER_ERROR);
// //    }
//     //以下为通用异常处理
// //    @ExceptionHandler(Exception.class)
// //    public Response otherExceptionHandler(Exception ex) {
// //
// //        return ResponseUtil.error(ResultEnum.FAIL);
// //    }
// }
