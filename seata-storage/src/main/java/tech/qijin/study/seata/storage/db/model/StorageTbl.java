package tech.qijin.study.seata.storage.db.model;

public class StorageTbl {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column storage_tbl.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column storage_tbl.commodity_code
     *
     * @mbg.generated
     */
    private String commodityCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column storage_tbl.count
     *
     * @mbg.generated
     */
    private Integer count;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column storage_tbl.id
     *
     * @return the value of storage_tbl.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column storage_tbl.id
     *
     * @param id the value for storage_tbl.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column storage_tbl.commodity_code
     *
     * @return the value of storage_tbl.commodity_code
     *
     * @mbg.generated
     */
    public String getCommodityCode() {
        return commodityCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column storage_tbl.commodity_code
     *
     * @param commodityCode the value for storage_tbl.commodity_code
     *
     * @mbg.generated
     */
    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode == null ? null : commodityCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column storage_tbl.count
     *
     * @return the value of storage_tbl.count
     *
     * @mbg.generated
     */
    public Integer getCount() {
        return count;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column storage_tbl.count
     *
     * @param count the value for storage_tbl.count
     *
     * @mbg.generated
     */
    public void setCount(Integer count) {
        this.count = count;
    }
}