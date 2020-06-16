// package com.component.mongodb.util;
//
// import com.alibaba.fastjson.JSONObject;
// import com.entity.Model;
// import com.fzyjftech.logisticsreport.model.CountMongo.ModelMongo;
// import com.fzyjftech.logisticsreport.model.CountMongo.ModelMysql;
// import com.mongodb.client.result.DeleteResult;
// import com.mongodb.client.result.UpdateResult;
// import lombok.extern.slf4j.Slf4j;
// import org.bouncycastle.math.raw.Mod;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Sort;
// import org.springframework.data.geo.Circle;
// import org.springframework.data.geo.Distance;
// import org.springframework.data.geo.Metrics;
// import org.springframework.data.geo.Point;
// import org.springframework.data.mongodb.core.MongoTemplate;
// import org.springframework.data.mongodb.core.query.Criteria;
// import org.springframework.data.mongodb.core.query.Query;
// import org.springframework.data.mongodb.core.query.Update;
// import org.springframework.stereotype.Component;
//
// import javax.jws.WebParam;
// import java.io.Serializable;
// import java.util.List;
// import java.util.Map;
// import java.util.regex.Pattern;
//
//
// /**
//  * @author ：shill
//  * @version : 1.0
//  * @date ：Created in 2019/5/29 14:15
//  * @description : mongodb util类,主要使用MongodbTemplate方法
//  * @modified By : shill
//  */
//
//
// @Slf4j
// @Component
// public class MongoUtil {
//     private final MongoTemplate mongo;
//
//     @Autowired
//     public MongoUtil(MongoTemplate mongoTemplate) {
//         this.mongo = mongoTemplate;
//     }
//
//
//
//     public <T> Object dsd(String key,String value,Class<T> c,Map map){
//         Query query1 = Query.query(Criteria.where(key).is(value));
//         Model o1  =mongo.findOne(query1, Model.class);
//         String field= map.get(c).toString();
//         o1.
//         Query query2 = Query.query(Criteria.where(key).is(value));
//         Object o2  =mongo.findOne(query2, c);
//
//         Query query3 = Query.query(Criteria.where(key).is(value));
//         Object o3 =mongo.findOne(query3, c);
//
//         JSONObject j1=new JSONObject();
//         JSONObject j2=new JSONObject();
//         JSONObject j3=new JSONObject();
//         j1.putAll();
//
//
//
//
//
//
//
//     }
//
//
//
//
//     /**
//      * @description :
//      * insert :主键重复返回DuplicateKeyException
//      * save :主键重复修改document
//      */
//     public void insert(Object o) {
//         mongo.insert(o);
//     }
//
//     public void save(Object o) {
//         mongo.save(o);
//     }
//
//
//     /**
//      * @description : 查询单条记录
//      */
//     public <T> T findOne(String key, Serializable value, Class<T> c) {
//         Query query = Query.query(Criteria.where(key).is(value));
//         return mongo.findOne(query, c);
//     }
//
//
//     /**
//      * @description : 查询所有记录(1个条件)
//      */
//
//     public <T> List<T> findAll(Class<T> c) {
//         return mongo.findAll(c);
//     }
//
//     public <T> List<T> findAll(String key, Serializable value, Class<T> c) {
//         Query query = Query.query(Criteria.where(key).is(value));
//         return mongo.find(query, c);
//     }
//
//
//     /**
//      * @description : 查询所有记录(2个条件)
//      */
//     public <T> List<T> findAll(String k1, Serializable v1, String k2, Serializable v2, Class<T> c) {
//         Query query = Query.query(Criteria.where(k1).is(v1).and(k2).is(v2));
//         return mongo.find(query, c);
//     }
//
//
//     /**
//      * @description : 时间范围查询 大于 &gt 小于&lt
//      */
//
//     public <T> List<T> findByTime(String timeKey, String start, String stop, String k, Serializable v, Class<T> c) {
//         Query query = new Query();
//         query.addCriteria(new Criteria().andOperator(Criteria.where(timeKey).lt(stop).gte(start), Criteria.where(k).is(v)));
//         return mongo.find(query, c);
//     }
//     /**
//      * @description : 时间范围查询 大于 &gt 小于&lt
//      */
//
//     public <T> List<T> findByTime2(String timeKey, String start, String stop, String k, Serializable v, Class<T> c) {
//         Query query = new Query();
//         query.addCriteria(new Criteria().andOperator(Criteria.where(timeKey).lt(stop).gte(start), Criteria.where(k).is(v)));
//         return mongo.find(query, c);
//     }
//
//
//     /**
//      * @description : 更新
//      */
//     public <T> boolean update(String col, String k, Serializable v, String updateK, T updateV) {
//         Query query = Query.query(Criteria.where(k).is(v));
//         Update update = new Update();
//         update.set(updateK, updateV);
//         UpdateResult updateResult = mongo.updateFirst(query, update, col);
//         long modifiedCount = updateResult.getModifiedCount();
//         return modifiedCount > 0;
//     }
//
//
//     //复合查询(单条)
//     public Object selectSingleDocumentByCompound(String col,
//                                                  String key1, Serializable value1,
//                                                  String key2, Serializable value2,
//                                                  Class var) {
//         Query query = new Query();
//         query.addCriteria(new Criteria()
//                 .andOperator(
//                         Criteria.where(key1).is(value1),
//                         Criteria.where(key2).is(value2)
//                 ));
//         //noinspection unchecked
//
//
//         return mongo.findOne(query, var, col);
//
//     }
//
//     //复合查询(多条)
//     public Object selectAllDocumentByCompound(String col,
//                                               String key1, Serializable value1,
//                                               String key2, Serializable value2,
//                                               Class var) {
//         Query query = new Query();
//         query.addCriteria(new Criteria()
//                 //或(||)判断
//                 .orOperator(Criteria.where(key1).is(value1), Criteria.where(key2).is(value2)
//                 ));
//         //noinspection unchecked
//         return mongo.find(query, var, col);
//     }
//
//
//
// }
