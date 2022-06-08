package website.CZB.educationsystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import website.CZB.educationsystem.entities.Device;

import java.util.List;
@Mapper
public interface DeviceMapper {

    Device getByDeviceId(String deviceId);

    void addDevice(Device device);

    void deleteDevice(Device device);

    void changeDevice(Device device);

    List<Device> findDeviceList();

}
