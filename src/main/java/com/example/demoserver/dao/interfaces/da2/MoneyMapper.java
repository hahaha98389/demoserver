package com.example.demoserver.dao.interfaces.da2;

import com.example.demoserver.dao.po.da2.Money;
import com.example.demoserver.dao.po.da2.MoneyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MoneyMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table money
     *
     * @mbg.generated
     */
    long countByExample(MoneyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table money
     *
     * @mbg.generated
     */
    int deleteByExample(MoneyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table money
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table money
     *
     * @mbg.generated
     */
    int insert(Money record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table money
     *
     * @mbg.generated
     */
    int insertSelective(Money record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table money
     *
     * @mbg.generated
     */
    List<Money> selectByExample(MoneyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table money
     *
     * @mbg.generated
     */
    Money selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table money
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Money record, @Param("example") MoneyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table money
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Money record, @Param("example") MoneyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table money
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Money record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table money
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Money record);
}