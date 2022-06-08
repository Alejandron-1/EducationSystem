package website.CZB.educationsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import website.CZB.educationsystem.entities.Family;
import website.CZB.educationsystem.mapper.FamilyMapper;

import java.util.List;
@Service
@Transactional
public class FamilyService {

    private FamilyMapper familyMapper;

    @Autowired
    public FamilyService(FamilyMapper familyMapper) {
        this.familyMapper = familyMapper;
    }

    public Family getByFamilyName(String familyName){
        return familyMapper.getByFamilyName(familyName);
    }

    public void addFamily(Family family){
        familyMapper.addFamily(family);
    }

    public void deleteFamily(Family family){
        familyMapper.deleteFamily(family);
    }

    public void changeFamily(Family family){
        familyMapper.changeFamily(family);
    }

    public List<Family> familyList(){
        return familyMapper.familyList();
    }
}
