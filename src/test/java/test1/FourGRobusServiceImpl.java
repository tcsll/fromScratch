// package test1;
//
// import com.alibaba.fastjson.JSONArray;
// import com.alibaba.fastjson.JSONObject;
// import com.ffcs.helper.FormatHelper;
// import com.ffcs.helper.StringUtils;
// import com.ffcs.oss.mapper.FourGRobusMappper;
// import com.ffcs.oss.service.FourGRobusService;
// import com.ffcs.oss.web.rest.enums.NumEnum;
// import com.ffcs.oss.web.rest.evt.SaveRmParamEvt;
// import com.ffcs.oss.web.rest.util.DataUtil;
// import com.ffcs.oss.web.rest.util.FlagUtils;
// import com.ffcs.oss.web.rest.util.HttpCallUtils;
// import com.ffcs.oss.web.rest.util.XmlUtil;
// import com.ffcs.oss.web.rest.vm.FourGVm;
// import com.ffcs.oss.web.rest.vm.RruTownVm;
// import net.logstash.logback.encoder.org.apache.commons.lang.StringEscapeUtils;
// import org.apache.commons.collections4.map.HashedMap;
// import org.dom4j.Document;
// import org.dom4j.DocumentHelper;
// import org.dom4j.Element;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.stereotype.Service;
//
// import java.text.SimpleDateFormat;
// import java.util.ArrayList;
// import java.util.Date;
// import java.util.List;
// import java.util.Map;
// import java.util.com.concurrent.*;
// import java.util.regex.Matcher;
// import java.util.regex.Pattern;
//
// @Service
// public class FourGRobusServiceImpl implements FourGRobusService {
//
//  private static Logger logger = LoggerFactory.getLogger(FourGRobusServiceImpl.class);
//
//  @Value("${wsdlUrl.rmUrl}")
//  private String rmUrl;
//
//  @Value("${wsdlUrl.esbUrl}")
//  private String esbUrl;
//
//  @Autowired
//  private HttpCallUtils httpCallUtils;
//
//  @Autowired
//  private FourGRobusMappper fourGRobusMappper;
//
//  private String RM_SOAP_HEAD = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ser=\"http://service.oss.ffcs.com\">\n" +
//   "   <soapenv:Header/>\n" +
//   "   <soapenv:Body>\n" +
//   "      <ser:omsResLteRelays><request>";
//
//  private String RM_SOAP_END = "</request>\n" +
//   "      </ser:omsResLteRelays>\n" +
//   "   </soapenv:Body>\n" +
//   "</soapenv:Envelope>";
//
//
//  private String ESB_SOAP_HEAD = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ser=\"http://server.axis2.support.esb.ztesoft.com\">" +
//   "<soapenv:Header/><soapenv:Body><ser:handler><ser:msg>";
//
//  private String ESB_SOAP_END = "</ser:msg></ser:handler></soapenv:Body></soapenv:Envelope>";
//
//  @Override
//  public void findIntf4g(){
//
//   List<FourGVm> intf4g = fourGRobusMappper.findIntf4g();
//
//   SaveRmParamEvt saveRmEvt;
//
//   if(intf4g.size() > 0){
//
//    // 每10000条数据开启一条线程
//    int threadSize = 10000;
//    // 总数据条数
//    int dataSize = intf4g.size();
//    // 线程数
//    int threadNum = dataSize / threadSize + 1;
//    // 定义标记,过滤threadNum为整数
//    boolean special = dataSize % threadSize == 0;
//
//    // 创建一个线程池
//    ExecutorService selectDate = new ThreadPoolExecutor(threadNum, DataUtil.MAXIMUM_POOL_SIZE, DataUtil.KEEP_ALIVE_TIME, TimeUnit.MILLISECONDS,
//     new LinkedBlockingQueue<Runnable>(),new ThreadPoolExecutor.DiscardPolicy());
//    // 定义一个任务集合
//    List<Callable<Integer>> tasks = new ArrayList<Callable<Integer>>();
//    Callable<Integer> task = null;
//    List<FourGVm> cutList = null;
//    // 确定每条线程的数据
//    for (int i = 0; i < threadNum; i++) {
//     if (i == threadNum - 1) {
//      if (special) {
//       break;
//      }
//      cutList = intf4g.subList(threadSize * i, dataSize);
//     } else {
//      cutList = intf4g.subList(threadSize * i, threadSize * (i + 1));
//     }
//     final List<FourGVm> listStr = cutList;
//     task = new Callable<Integer>() {
//      @Override
//      public Integer call() throws Exception {
//       analysis(listStr);
//       return 1;
//      }
//     };
//     // 这里提交的任务容器列表和返回的Future列表存在顺序对应的关系
//     tasks.add(task);
//    }
//    try {
//     //tasks任务集合，就是所有将在多线程环境下跑的work,向invokeall方法里添加需要运行的任务
//     List<Future<Integer>> results = selectDate.invokeAll(tasks);
//     if(results != null) {
//      for (Future<Integer> future : results) {
//       logger.info(future.get()+"");
//      }
//     }
//    }catch (Exception e){
//     logger.error("任务运行添加失败",e);
//    }
//    // 关闭线程池
//    selectDate.shutdown();
//    logger.info("线程任务执行结束");
//
//    //解析同沟同缆
// //   findRruTownId();
//
//   }else{
//    logger.info("暂时没有数据--------------------------");
//    return;
//   }
//
//  }
//
//  /**
//   * 解析光路编码
//   * @param intf4g
//   */
//  public void analysis(List<FourGVm> intf4g){
//   if(intf4g.size()>0) {
//    for (FourGVm fourGVm : intf4g) {
//     SaveRmParamEvt saveRmEvt = new SaveRmParamEvt();
//     saveRmEvt.setRruId(fourGVm.getRruId());
//
//     //构造RM调用报文
//     String msgId = getMsgId();
//     String rmXml = "<?xml version=\"1.0\" encoding=\"GB2312\"?>\n" +
//      "<Info>\n" +
//      "  <MsgId>#msgId#</MsgId>\n" +
//      "  <WgBbuCsId>#422173#</WgBbuCsId>\n" +
//      "  <WgRruCsId>#422173_51#</WgRruCsId>\n" +
//      "</Info>";
//     rmXml = rmXml.replaceAll("#msgId#", msgId);
//     rmXml = rmXml.replaceAll("#422173#", fourGVm.getEnbId() + "");
//     rmXml = rmXml.replaceAll("#422173_51#", fourGVm.getRruKey());
//
//     String requestXml = RM_SOAP_HEAD + "<![CDATA["
//      + rmXml + "]]>" + RM_SOAP_END;
//
//     logger.info("RM发送报文.");
//     String responseXml = "";
//     try {
//      responseXml = httpCallUtils.httpCilentCall(rmUrl, requestXml);
//
//      //先转义 对正常结果无影响
//      responseXml = StringEscapeUtils.unescapeXml(responseXml);
//
//      //有可能是异常的
//      if (!responseXml.contains("<?xml version=\"1.0\" encoding=\"GB2312\"?>")) {
//       logger.info("接口返回异常，异常参数saveRmEvt：" + saveRmEvt);
//       fourGRobusMappper.updateIntf(saveRmEvt);
//       continue;
//      }
//      responseXml = responseXml.substring(responseXml.indexOf("<?xml version=\"1.0\" encoding=\"GB2312\"?>"), responseXml.indexOf("</return>"));
//      JSONObject jsonObject = XmlUtil.xml2JSON(responseXml.getBytes("GB2312"));
//      JSONObject result = jsonObject.getJSONObject("Result");
//      JSONArray reInfo = result.getJSONArray("ReturnInfo");
//      JSONObject reInfo0 = reInfo.getJSONObject(0);
//      String reCode = FlagUtils.removeSymbol(reInfo0.getString("ReturnCode"));
//      String reMessage = FlagUtils.removeSymbol(reInfo0.getString("ReturnMessage"));
//      if (reCode.equals(NumEnum.ZERO.getValue())) {
//       logger.info("调用失败：" + reMessage);
//       logger.info("入参：" + saveRmEvt.toString());
//       fourGRobusMappper.updateIntf(saveRmEvt);
//       continue;
//      }
//      JSONArray listInfo = result.getJSONArray("ListInfo");
//      for (int i = 0; i < listInfo.size(); i++) {
//       JSONObject listTnfo0 = listInfo.getJSONObject(i);
//       JSONArray dataRelay = listTnfo0.getJSONArray("LteRelay");
//       JSONObject dataRelay0 = dataRelay.getJSONObject(0);
//       String isLoadOTN = FlagUtils.removeSymbol(dataRelay0.getString("IsLoadOTN"));
//       String carInfo = FlagUtils.removeSymbol(dataRelay0.getString("CarInfo"));
//       String issameroom = FlagUtils.removeSymbol(dataRelay0.getString("IsSameRoom"));
//       String opticalInfoLst = FlagUtils.removeSymbol(dataRelay0.getString("OpticalInfoLst"));
//       //解析OTNIdLst
//       String optno = "";
//       if (!StringUtils.empty(opticalInfoLst)) {
//        List<Map<String, Object>> otnList = getOtnList(opticalInfoLst, "\\]\\[", "(\\w+)=([^;]*)(;{0,1})");
//        for (Map<String, Object> otn : otnList) {
//         optno += FormatHelper.stringParse(otn.get("OPTNO")) + ";";
//        }
//       }
//       saveRmEvt.setCarinfo(carInfo);
//       saveRmEvt.setIsLoadOTN(isLoadOTN);
//       saveRmEvt.setIssameroom(issameroom);
//       saveRmEvt.setOpticalCode(optno);
//
//       logger.info("RM解析入库：" + saveRmEvt);
//       try {
//        fourGRobusMappper.updateIntf(saveRmEvt);
//        logger.info("RM解析入库成功。");
//       } catch (Exception e) {
//        logger.error("更新，异常ID：" + saveRmEvt.getRruId(), e);
//       }
//      }
//     } catch (Exception e) {
//      logger.error("解析数据异常", e);
//     }
//    }
//   }
//  }
//
//  public void findRruTownId(){
//   //解析同沟同缆
//    List<RruTownVm> rruTownIds = fourGRobusMappper.findRruTownId();
//    if(rruTownIds.size() > 0){
//     for(RruTownVm rruTownId : rruTownIds){
//      String rruBbuOptical = fourGRobusMappper.findRruBbuOptical(rruTownId.getRruTownId());
//      Document setXMLdocument = DocumentHelper.createDocument();
//      Element requestElement = setXMLdocument.addElement("Entity")
//       .addAttribute("name", "Request");
//      requestElement.addElement("Attribute")
//       .addAttribute("name", "AreaCode").addText("591");
//      requestElement.addElement("Attribute")
//       .addAttribute("name", "RemoteSys").addText("NM");
//      requestElement.addElement("Attribute")
//       .addAttribute("name", "RemoteSysIp").addText("134.128.34.50");
//      requestElement.addElement("Attribute")
//       .addAttribute("name", "Circuits").addText("F1706245146LSC;");
//      String requestXml = ESB_SOAP_HEAD + "<![CDATA["
//       + setXMLdocument.asXML() + "]]>" + ESB_SOAP_END;
//      // 调用接口
//      logger.info("调用ESB接口报文：" + requestXml);
//      String responseXml = "";
//
//      try {
//       responseXml = httpCallUtils.httpCilentCall(esbUrl, requestXml);
//       //有可能是异常的
//       if(!responseXml.contains("<?xml version='1.0' encoding='GBK'?>")){
//        logger.info("接口返回异常");
// //       continue;
//       }
//
//       responseXml = responseXml.substring(
//        responseXml.indexOf("<?xml version='1.0' encoding='GBK'?>"),
//        responseXml.indexOf("]]>"));
//
//       //1：成功 0：失败
//       String procResult2 = responseXml.substring(responseXml.lastIndexOf("<Attribute name=\"Proc_result\">"));
//       String procResult = procResult2.substring(30, procResult2.indexOf("</Attribute>"));
//       String errorInfo2 = responseXml.substring(responseXml.lastIndexOf("<Attribute name=\"Error_info\">"));
//       String errorInfo = errorInfo2.substring(29, errorInfo2.indexOf("</Attribute>"));
//       //如果返回结果为调用失败，则将该条记录result_detail更新为5, IS_CHECK更新为2，IS_NEED_SYN更新为1,
//       if (procResult.equals(NumEnum.ZERO.getValue())) {
//        logger.info("调用失败");
//       }
//
//
//      }catch (Exception e){
//       logger.error("SRM解析异常循环内:"+"异常乡镇ID："+rruTownId.getRruTownId(), e);
//      }
//     }
//    }else{
//     logger.info("暂时没有同沟同缆数据解析--------------------------");
//    }
//  }
//
//  /**
//   * 生成msgId
//   *
//   * @return
//   */
//  public String getMsgId() {
//   Date date = new Date();
//   SimpleDateFormat format = new SimpleDateFormat("YYYYMMdd");
//   String strId = format.format(date);
//   int x = (int) (Math.random() * 100000) + 100000;
//   strId = strId + x;
//   return strId;
//  }
//
//
//  /**
//   * 通过正则解析成list<map>
//   * @param data 数据
//   * @param subSymbol 截取符号
//   * @param compile 解析规则
//   * @return
//   */
//  List<Map<String,Object>> getOtnList(String data,String subSymbol,String compile){
//   String[] otns = data.split(subSymbol);
//   Pattern pattern=Pattern.compile(compile);
//   List<Map<String,Object>> optList = new ArrayList<>();
//   Map<String,Object> map = new HashedMap();
//   for(String str : otns){
//    Matcher matcher=pattern.matcher(str);
//    str = str.replaceAll("\\[","");
//    str = str.replaceAll("\\]","");
//    str = str.replaceAll("\\{","");
//    str = str.replaceAll("\\}","");
//    map = new HashedMap();
//    while (matcher.find()){
//     map.put(matcher.group(1),matcher.group(2));
//    }
//    optList.add(map);
//   }
//   return  optList;
//  }
//
//
// }
//
