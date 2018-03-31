package com.edoctor.service;

import com.edoctor.bean.Device;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeviceRepository extends JpaRepository<Device, Integer> {

    List<Device> getDevicesByNameEquals(String name);
}
