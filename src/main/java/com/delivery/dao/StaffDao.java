package com.delivery.dao;

import com.delivery.entity.Staff;

import java.util.List;

/**
 * Created by LEO15 on 2020/10/20.
 */
public interface StaffDao {
    /**
     * 添加员工
     * @param staff
     * @return boolean
     */
    boolean addStaff(Staff staff);
    /**
     * 废除员工
     * 修改员工Deltag字段 为N
     * @param staff
     * @return boolean
     */
    boolean removeStaff(Staff staff);
    /**
     * 修改员工
     * @param staff
     * @return boolean
     */
    boolean updateStaff(Staff staff);
    /**
     * 查询所有状态为未离职的员工
     * Deltag 为Y 表明未离职
     *        为N 表明离职
     * @param
     * @return list
     */
    List<Staff> selectStaffDeltagIsYes();
    /**
     * 查询全部员工（包括离职员工）
     * @param
     * @return list
     */
    List<Staff> selectAllStaff();
    /**
     * 通过任意一个元素查询员工
     * @param
     * @return list
     */
    List<Staff> selectStaffByOneElement(Staff staff);
}
