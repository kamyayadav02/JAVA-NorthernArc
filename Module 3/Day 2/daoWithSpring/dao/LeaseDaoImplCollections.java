package dao;

import entity.LeaseAgreement;

import java.util.LinkedHashMap;
import java.util.Map;

public class LeaseDaoImplCollections implements LeaseDao {

    private Map<Integer, LeaseAgreement> leases = new LinkedHashMap<>();

    @Override
    public int save(LeaseAgreement lease) {
        leases.put(lease.getId(), lease);
        return lease.getId();
    }

    @Override
    public void deleteById(int id) {
        leases.remove(id);
    }

    @Override
    public void updateById(int id, LeaseAgreement lease) {
        LeaseAgreement existing = leases.get(id);
        if (existing != null) {
            existing.setAssetName(lease.getAssetName());
            existing.setCustomerName(lease.getCustomerName());
            existing.setLeaseAmount(lease.getLeaseAmount());
            existing.setDurationMonths(lease.getDurationMonths());
            existing.setActive(lease.isActive());
        }
    }

    @Override
    public LeaseAgreement findById(int id) {
        return leases.get(id);
    }

    @Override
    public Map<Integer, LeaseAgreement> findAll() {
        return leases;
    }
}
