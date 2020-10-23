package com.delivery.dao;

import com.delivery.entity.Provinces;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Yvan
 * @Description provinces 的 dao 层
 * @Classname ProvincesDao
 * @Date 2020/10/20 16:43
 */
@Repository
public interface ProvincesDao {

    /**
     * 查询 所有 省
     *
     * @return List<Provinces>
     */
    @Select("select id, province_name from provinces")
    List<Provinces> selectAll();
}
