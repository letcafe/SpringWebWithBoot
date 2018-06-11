package com.edoctor.dao.repository;

import com.edoctor.bean.Device;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeviceDao extends JpaRepository<Device, Integer> {

    List<Device> getDevicesByNameEquals(String name);

    Device getDeviceById(Integer id);

    Device getDeviceByBridgeId(String bridgeId);

    List<Device> getDevicesByArea(String area);
}
