package exception.consts;

/**
 * <p>Title:BSS3.0</p>
 * <p>Description: ApiExceptionConsts</p>
 * <p>Company: ztesoft</p>
 * <p>Created Date: 2019-03-09</p>
 *
 * @author zhengqian <br/>
 * @version 1.0 <br/>
 */
public class ApiExceptionConsts {

    /**
     * 接口请求结果代码
     */
    public static final String API_ERROR_CODE = "-1"; //请求失败代码
    public static final String API_SUCCESS_CODE = "0"; //请求成功代码

    public static final String API_ERRORCODE_TIMEOUT = "11700";          //接口响应超时
    public static final String API_ERRORCODE_FORMAT = "11701";           //报文格式错误
    public static final String API_ERRORCODE_URL = "11703";              //请求地址找不到
    public static final String API_ERRORCODE_NETWORK = "11704";          //网络中断，网络异常
    public static final String API_ERRORCODE_PARSE = "11705";            //解析报文异常
    public static final String API_ERRORCODE_NOT_FOUND = "11733";        //查询不到记录
    public static final String API_ERRORCODE_NOT_FOUND_MULTIPLE = "11734";        //Found multiple MaxNum in the system
    public static final String API_ERRORCODE_NULL_PARAMETERS = "11735";  //请求字段值有空值
    public static final String API_ERRORCODE_INVALID_VALUE = "11736";    //请求字段值数据不对
    public static final String API_ERRORCODE_OUT_RANGE = "11737";        //请求字段入参个数超出范围

    public static final String API_ERRORCODE_NO_TARIFFPLAN_FOUND = "11739"; //查询到了OFFER，但没有找到对应的TariffPlan


    /**
     * queryPaymentTypeByMedia
     */
    public static final String API_CONTENT_TYPE = "application/json";
    public static final String API_TIMEOUT = "11700";  //接口响应超时
    public static final String API_INCORRECT_REQUEST_FORMAT = "11701";  //报文格式错误
    public static final String API_ADDRESS_NOT_FOUND = "11702";  //请求地址找不到
    public static final String API_NETWORK_ABNORMAL = "11703";  //网络中断，网络异常
    public static final String API_INCORRENT_REQUEST_CONTENT = "11704";  //解析报文异常
    public static final String API_MISSING_NECESSARY_PARAMETERS = "11706";  //请求字段值有空值，而API要求不能为空
    public static final String API_INVALID_PARAMETER = "11707";  //请求字段值数据不对或值没找到, 返回具体的字段名
    /**
     * queryOfferCatalogInfo
     */
    public static final String API_OFFER_CATALOG_NOT_FOUND = "11711";  //查找不到OfferCatalog
    /**
     * queryCampaignMappingByCondition
     */
    public static final String API_TVS_OFFER_NOT_FOUND = "11714";  //查询不到TVSOffer


    public static final String API_INVALID_VALUE_OF_MEDIA = "11727";  //Media值不合法
    public static final String API_OFFERGROUP_NOT_FOUND = "11709";  //查找不到OfferGroup
    public static final String API_FOUND_MULTIPLE_OFFERGROUP = "11719";  //查找到多个OfferGroup
    public static final String API_MAXNUM_NOT_FOUND = "11710";  //查找不到MaxNum
    public static final String API_FOUND_MULTIPLE_MAXNUM = "11718";  //查找到多个MaxNum
    public static final String API_PRODUCTCATALOG_NOT_FOUND = "11712";  //查询不到ProductCatalog





    /**
     * 接口请求结果信息
     */
    public static final String API_ERROR_MSG = "Failed";    //请求失败信息
    public static final String API_SUCCESS_MSG = "Success"; //请求成功信息
    public static final String API_NETWORK_ABNORMAL_MESSAGE = "Network abnormal";  //网络中断，网络异常

    public static final String QRUN_SUCCESS_CODE = "0000";



}