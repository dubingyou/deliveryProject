package com.delivery.service.impl;

import com.delivery.dao.StaffDao;
import com.delivery.entity.Staff;
import com.delivery.service.StaffService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by LEO15 on 2020/10/19.
 */
@Service
public class StaffServiceImpl implements StaffService {
    @Resource
    private StaffDao staffDao;

    @Override
    public boolean addStaff(Staff staff) {
        return staffDao.addStaff(staff);
    }

    @Override
    public boolean removeStaff(Staff staff) {
        return staffDao.removeStaff(staff);
    }

    @Override
    public boolean updateStaff(Staff staff) {
        return staffDao.updateStaff(staff);
    }

    @Override
    public List<Staff> selectStaffDeltagIsYes() {
        return staffDao.selectStaffDeltagIsYes();
    }

    @Override
    public List<Staff> selectAllStaff() {
        return staffDao.selectAllStaff();
    }


    @Override
    public List<Staff> selectStaffByOneElement(Staff staff) {
        return staffDao.selectStaffByOneElement(staff);
    }
}
