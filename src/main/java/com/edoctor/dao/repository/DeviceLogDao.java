package com.edoctor.dao.repository;

import com.edoctor.bean.DeviceLog;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DeviceLogDao extends MongoRepository<DeviceLog, String> {

    List<DeviceLog> getDeviceLogsByDeviceId(String deviceId);
}
