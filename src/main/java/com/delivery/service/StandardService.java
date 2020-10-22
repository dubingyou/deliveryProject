package com.delivery.service;

import com.delivery.entity.Standard;

import java.util.List;

/**
 * Created by LEO15 on 2020/10/21.
 */
public interface StandardService {
    /**
     * 添加标准
     * @param standard standard
     * @return boolean
     */
    boolean addStandard(Standard standard);
    /**
     * 添加标准
     * @param standard standard
     * @return boolean
     */
    boolean removeStandardStatus(Standard standard);
    /**
     * 添加标准
     * @param standard standard
     * @return boolean
     */
    boolean updateStandard(Standard standard);
    /**
     * 查询标准
     * @return List
     */
    List<Standard> selectStandard();

    /**
     * 按状态查询标准
     * @param status status
     * @return list
     */
    List<Standard> selectStandardByStatus(int status);
}
