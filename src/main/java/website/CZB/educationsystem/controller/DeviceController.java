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
    private Result result = new Result();
    
    @Autowired
    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @RequestMapping("/addDevice")
    public Result addDevice(@RequestBody Device device){
        System.out.println(device);
        if(deviceService.getByDeviceId(device.getDeviceId())!=null){//id重复！
            result.setInfo("该设备已存在",deviceService.getByDeviceId(device.getDeviceId()));
        }else{
            deviceService.addDevice(device);
            result.setSuccess("增加设备成功！",device);
        }
        return result;
    }

    @RequestMapping("/deleteDevice")
    public Result deleteDevice(@RequestBody Device device){
        Device device1 = deviceService.getByDeviceId(device.getDeviceId());
        System.out.println(device1);
        if(device1 != null){//找到该设备
            System.out.println("nullID -- ");
            deviceService.deleteDevice(device);
            result.setSuccess("删除设备成功！",device1);
        }else{
            result.setInfo("该设备不存在",null);
        }
        return result;
    }

    @RequestMapping("/changeDevice")
    public Result changeDevice(@RequestBody Device device){
        System.out.println(device);
        Device device1 = deviceService.getByDeviceId(device.getDeviceId());
        System.out.println(deviceService.getByDeviceId(device.getDeviceId()));
        if(deviceService.getByDeviceId(device.getDeviceId())==null){//id重复！
            result.setInfo("该设备不存在",null);
        }else{
            deviceService.changeDevice(device);
            result.setSuccess("修改设备成功！",device1);
        }
        return result;
    }
    
    @RequestMapping("/findDeviceList")
    public Result findDeviceList(){
        List<Device> deviceList = deviceService.findDeviceList();
        result.setSuccess("查询设备成功！",deviceList);
        return result;
    }

}
