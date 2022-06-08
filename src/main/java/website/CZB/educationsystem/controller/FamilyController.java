package website.CZB.educationsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import website.CZB.educationsystem.entities.Family;
import website.CZB.educationsystem.service.FamilyService;
import website.CZB.educationsystem.utils.Result;

import java.util.List;

@RestController
@RequestMapping("/family")
public class FamilyController {
    private FamilyService familyService;
    private Result result;

    @Autowired
    public FamilyController(FamilyService familyService) {
        this.familyService = familyService;
    }
    @RequestMapping("/addFamily")
    public Result addFamily(@RequestBody Family family){
        if(familyService.getByFamilyName(family.getFamilyName()) != null){ // 已存在
            result.setInfo("该家庭已存在",null);
        }else {
            familyService.addFamily(family);
            result.setSuccess("添加家庭成功！",null);
        }
        return result;
    }

    @RequestMapping("/deleteFamily")
    public Result deleteFamily(@RequestBody Family family){
        if(familyService.getByFamilyName(family.getFamilyName()) == null){ // 不存在
            result.setInfo("该家庭不存在",null);
        }else {
            familyService.deleteFamily(family);
            result.setSuccess("删除家庭成功！",null);
        }
        return result;
    }

    @RequestMapping("/changeFamily")
    public Result changeFamily(@RequestBody Family family){
        if(familyService.getByFamilyName(family.getFamilyName()) != null){
            result.setInfo("该家庭已存在",null);
        }else {
            familyService.changeFamily(family);
            result.setSuccess("修改家庭成功！",null);
        }
        return result;
    }

    @RequestMapping("/familyList")
    public Result familyList(){
        List<Family> familyList = familyService.familyList();
        result.setSuccess("查询家庭列表成功",familyList);
        return result;
    }



}
