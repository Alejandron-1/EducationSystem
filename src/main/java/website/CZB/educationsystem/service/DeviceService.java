package website.CZB.educationsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import website.CZB.educationsystem.entities.Device;
import website.CZB.educationsystem.mapper.DeviceMapper;

import java.util.List;

@Service
@Transactional
public class DeviceService {
    private DeviceMapper deviceMapper;

    @Autowired
    public DeviceService(DeviceMapper deviceMapper) {
        this.deviceMapper = deviceMapper;
    }

    public Device getByDeviceId(String deviceId){
        return deviceMapper.getByDeviceId(deviceId);
    }

    public void addDevice(Device device){
        deviceMapper.addDevice(device);
    }

    public void deleteDevice(Device device){
        deviceMapper.deleteDevice(device);
    }

    public void changeDevice(Device device){
        deviceMapper.changeDevice(device);
    }

    public  List<Device> findDeviceList(){
        return deviceMapper.findDeviceList();
    }


}
