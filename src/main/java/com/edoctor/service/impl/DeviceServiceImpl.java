package com.edoctor.service.impl;

import com.edoctor.bean.Device;
import com.edoctor.dao.repository.DeviceDao;
import com.edoctor.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DeviceServiceImpl implements DeviceService {

    DeviceDao deviceDao;

    @Autowired
    public DeviceServiceImpl(DeviceDao deviceDao) {
        this.deviceDao = deviceDao;
    }

    @Override
    public List<Device> getDevicesByArea(String area) {
        return deviceDao.getDevicesByArea(area);
    }

    @Override
    public long count() {
        return deviceDao.count();
    }

    @Override
    public Device getDeviceById(int id) {
        return deviceDao.getDeviceById(id);
    }

    @Override
    public Device save(Device device) {
        return deviceDao.save(device);
    }
}
