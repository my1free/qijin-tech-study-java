package tech.qijin.study.seata.order.db.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import tech.qijin.study.seata.order.db.model.OrderTbl;
import tech.qijin.study.seata.order.db.model.OrderTblExample;

public interface OrderTblMapper {
    @SelectProvider(type=OrderTblSqlProvider.class, method="countByExample")
    long countByExample(OrderTblExample example);

    @DeleteProvider(type=OrderTblSqlProvider.class, method="deleteByExample")
    int deleteByExample(OrderTblExample example);

    @Delete({
        "delete from order_tbl",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into order_tbl (user_id, commodity_code, ",
        "count, money)",
        "values (#{userId,jdbcType=VARCHAR}, #{commodityCode,jdbcType=VARCHAR}, ",
        "#{count,jdbcType=INTEGER}, #{money,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(OrderTbl record);

    @InsertProvider(type=OrderTblSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(OrderTbl record);

    @SelectProvider(type=OrderTblSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR),
        @Result(column="commodity_code", property="commodityCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="count", property="count", jdbcType=JdbcType.INTEGER),
        @Result(column="money", property="money", jdbcType=JdbcType.INTEGER)
    })
    List<OrderTbl> selectByExample(OrderTblExample example);

    @Select({
        "select",
        "id, user_id, commodity_code, count, money",
        "from order_tbl",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR),
        @Result(column="commodity_code", property="commodityCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="count", property="count", jdbcType=JdbcType.INTEGER),
        @Result(column="money", property="money", jdbcType=JdbcType.INTEGER)
    })
    OrderTbl selectByPrimaryKey(Integer id);

    @UpdateProvider(type=OrderTblSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OrderTbl record, @Param("example") OrderTblExample example);

    @UpdateProvider(type=OrderTblSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OrderTbl record, @Param("example") OrderTblExample example);

    @UpdateProvider(type=OrderTblSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OrderTbl record);

    @Update({
        "update order_tbl",
        "set user_id = #{userId,jdbcType=VARCHAR},",
          "commodity_code = #{commodityCode,jdbcType=VARCHAR},",
          "count = #{count,jdbcType=INTEGER},",
          "money = #{money,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(OrderTbl record);
}