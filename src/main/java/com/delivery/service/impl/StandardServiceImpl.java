package com.delivery.service.impl;

import com.delivery.dao.StaffDao;
import com.delivery.dao.StandardDao;
import com.delivery.entity.Standard;
import com.delivery.service.StandardService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by LEO15 on 2020/10/21.
 */
@Service
public class StandardServiceImpl implements StandardService {
    @Resource
    private StandardDao standardDao;
    @Resource
    private StaffDao staffDao;
    @Override
    public boolean addStandard(Standard standard) {
        if (standardDao.selectStandardByStandardName(standard.getStandardName()).size()>0){
            return false;
        }
        if (standard.getMinWeight()<standard.getMaxWeight()&&standard.getMinWeight()>0&&standard.getMaxWeight()>0){
            return standardDao.addStandard(standard);
        } else{
            return false;
        }
    }

    @Override
    public boolean removeStandardStatus(Standard standard) {
        String standardId=String.valueOf(standard.getId());
        if (staffDao.selectStaffByStandard(standardId).size()>0){
            return false;
        }else{
            return standardDao.removeStandard(standard);
        }
    }

    @Override
    public boolean updateStandard(Standard standard) {
        if (standard.getStatus()!=1){
            return false;
        }else{
            return standardDao.updateStandard(standard);
        }
    }

    @Override
    public List<Standard> selectStandard() {
        return standardDao.selectStandard();
    }

    @Override
    public List<Standard> selectStandardByStatus(int status) {
        return standardDao.selectStandardByStatus(status);
    }


}
