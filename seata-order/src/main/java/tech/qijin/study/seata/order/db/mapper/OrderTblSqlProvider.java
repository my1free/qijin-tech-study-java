package tech.qijin.study.seata.order.db.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import tech.qijin.study.seata.order.db.model.OrderTbl;
import tech.qijin.study.seata.order.db.model.OrderTblExample.Criteria;
import tech.qijin.study.seata.order.db.model.OrderTblExample.Criterion;
import tech.qijin.study.seata.order.db.model.OrderTblExample;

public class OrderTblSqlProvider {
    public String countByExample(OrderTblExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("order_tbl");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(OrderTblExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("order_tbl");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(OrderTbl record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("order_tbl");
        
        if (record.getUserId() != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=VARCHAR}");
        }
        
        if (record.getCommodityCode() != null) {
            sql.VALUES("commodity_code", "#{commodityCode,jdbcType=VARCHAR}");
        }
        
        if (record.getCount() != null) {
            sql.VALUES("count", "#{count,jdbcType=INTEGER}");
        }
        
        if (record.getMoney() != null) {
            sql.VALUES("money", "#{money,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String selectByExample(OrderTblExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("user_id");
        sql.SELECT("commodity_code");
        sql.SELECT("count");
        sql.SELECT("money");
        sql.FROM("order_tbl");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        OrderTbl record = (OrderTbl) parameter.get("record");
        OrderTblExample example = (OrderTblExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("order_tbl");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{record.userId,jdbcType=VARCHAR}");
        }
        
        if (record.getCommodityCode() != null) {
            sql.SET("commodity_code = #{record.commodityCode,jdbcType=VARCHAR}");
        }
        
        if (record.getCount() != null) {
            sql.SET("count = #{record.count,jdbcType=INTEGER}");
        }
        
        if (record.getMoney() != null) {
            sql.SET("money = #{record.money,jdbcType=INTEGER}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("order_tbl");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("user_id = #{record.userId,jdbcType=VARCHAR}");
        sql.SET("commodity_code = #{record.commodityCode,jdbcType=VARCHAR}");
        sql.SET("count = #{record.count,jdbcType=INTEGER}");
        sql.SET("money = #{record.money,jdbcType=INTEGER}");
        
        OrderTblExample example = (OrderTblExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(OrderTbl record) {
        SQL sql = new SQL();
        sql.UPDATE("order_tbl");
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{userId,jdbcType=VARCHAR}");
        }
        
        if (record.getCommodityCode() != null) {
            sql.SET("commodity_code = #{commodityCode,jdbcType=VARCHAR}");
        }
        
        if (record.getCount() != null) {
            sql.SET("count = #{count,jdbcType=INTEGER}");
        }
        
        if (record.getMoney() != null) {
            sql.SET("money = #{money,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, OrderTblExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}