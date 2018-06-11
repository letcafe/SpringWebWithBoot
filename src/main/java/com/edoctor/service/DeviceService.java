package com.edoctor.service;

import com.edoctor.bean.Device;

import java.util.List;

public interface DeviceService {

    List<Device> getDevicesByArea(String area);

    long count();

    Device getDeviceById(int id);

    Device save(Device device);
}
