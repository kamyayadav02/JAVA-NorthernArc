package dao;

import entity.CreditScore;

import java.util.Collection;

public interface CreditScoreDao {
    public int save (CreditScore creditScore);
    public CreditScore findById(int id);
    public void deleteById(int id);
    public void updateById(int id, CreditScore creditScore);
    public void deleteAll();
    public Collection<CreditScore> findAll();
}
