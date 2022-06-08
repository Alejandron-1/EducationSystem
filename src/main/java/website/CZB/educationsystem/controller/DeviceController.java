package website.CZB.educationsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import website.CZB.educationsystem.entities.Device;
import website.CZB.educationsystem.service.DeviceService;
import website.CZB.educationsystem.utils.Result;

import java.util.List;

@RestController
@RequestMapping("/device")
public class DeviceController {
    private DeviceService deviceService;
    private Result result;
    
    @Autowired
    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @RequestMapping("/addDevice")
    public Result addTable(@RequestBody Device device){
        if(deviceService.getByDeviceId(device.getDeviceId())!=null){//id重复！
            result.setInfo("该设备已存在",null);
        }else{
            deviceService.addDevice(device);
            result.setSuccess("增加设备成功！",null);
        }
        return result;
    }

    @RequestMapping("/deleteDevice")
    public Result deleteTable(@RequestBody Device Device){
        if(deviceService.getByDeviceId(Device.getDeviceId())==null){//id重复！
            result.setInfo("该设备不存在",null);
        }else{
            deviceService.deleteDevice(Device);
            result.setSuccess("删除设备成功！",null);
        }
        return result;
    }

    @RequestMapping("/changeDevice")
    public Result changeTable(@RequestBody Device Device){
        if(deviceService.getByDeviceId(Device.getDeviceId())==null){//id重复！
            result.setInfo("该设备不存在",null);
        }else{
            deviceService.changeDevice(Device);
            result.setSuccess("修改设备成功！",null);
        }
        return result;
    }
    
    @RequestMapping("/findDeviceList")
    public Result findTableList(){
        List<Device> tableList = deviceService.findDeviceList();
        result.setSuccess("查询设备成功！",tableList);
        return result;
    }

}
