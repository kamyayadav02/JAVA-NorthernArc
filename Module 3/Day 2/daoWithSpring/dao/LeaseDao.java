package dao;

import entity.LeaseAgreement;
import java.util.Map;

public interface LeaseDao {

    int save(LeaseAgreement lease);
    void deleteById(int id);
    void updateById(int id, LeaseAgreement lease);
    LeaseAgreement findById(int id);
    Map<Integer, LeaseAgreement> findAll();
}