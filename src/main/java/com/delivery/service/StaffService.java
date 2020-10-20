package com.delivery.service;

import com.delivery.entity.Staff;

import java.util.List;

/**
 * Created by LEO15 on 2020/10/19.
 */
public interface StaffService {

    /**
     * 添加员工
     */
    boolean addStaff(Staff staff);

    /**
     * 移除员工
     * 修改员工Deltag字段 为N
     */
    boolean removeStaff(Staff staff);

    /**
     * 修改员工
     */
    boolean updateStaff(Staff staff);

    /**
     * 查询所有状态为未离职的员工
     * Deltag 为Y 表明未离职
     *        为N 表明离职
     */
    List<Staff> selectStaffDeltagIsYes();

    /**
     * 查询全部员工（包括离职员工）
     */
    List<Staff> selectAllStaff();

    /**
     * 通过任意一个元素查询员工
     */
    List<Staff> selectStaffByOneElement(Staff staff);

}
