package dao;

import config.dbManager;
import entity.LeaseAgreement;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class LeaseDaoImplJDBC implements LeaseDao {

    private dbManager db;

    public LeaseDaoImplJDBC(dbManager db) {
        this.db = db;
    }

    private LeaseAgreement map(ResultSet rs) throws SQLException {
        return new LeaseAgreement(
                rs.getInt("id"),
                rs.getString("asset_name"),
                rs.getString("customer_name"),
                rs.getDouble("lease_amount"),
                rs.getInt("duration"),
                rs.getBoolean("active")
        );
    }

    @Override
    public int save(LeaseAgreement lease) {
        String sql = "INSERT INTO lease(asset_name, customer_name, lease_amount, duration, active) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = db.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, lease.getAssetName());
            stmt.setString(2, lease.getCustomerName());
            stmt.setDouble(3, lease.getLeaseAmount());
            stmt.setInt(4, lease.getDurationMonths());
            stmt.setBoolean(5, lease.isActive());

            return stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("DB Error: " + e.getMessage());
        }
        return 0;
    }

    @Override
    public LeaseAgreement findById(int id) {
        String sql = "SELECT * FROM lease WHERE id=?";

        try (Connection con = db.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) return map(rs);

        } catch (SQLException e) {
            System.out.println("DB Error: " + e.getMessage());
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM lease WHERE id=?";

        try (Connection con = db.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("DB Error: " + e.getMessage());
        }
    }

    @Override
    public void updateById(int id, LeaseAgreement lease) {
        String sql = "UPDATE lease SET asset_name=?, customer_name=?, lease_amount=?, duration=?, active=? WHERE id=?";

        try (Connection con = db.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, lease.getAssetName());
            stmt.setString(2, lease.getCustomerName());
            stmt.setDouble(3, lease.getLeaseAmount());
            stmt.setInt(4, lease.getDurationMonths());
            stmt.setBoolean(5, lease.isActive());
            stmt.setInt(6, id);

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("DB Error: " + e.getMessage());
        }
    }

    @Override
    public Map<Integer, LeaseAgreement> findAll() {
        Map<Integer, LeaseAgreement> map = new HashMap<>();
        String sql = "SELECT * FROM lease";

        try (Connection con = db.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                LeaseAgreement l = map(rs);
                map.put(l.getId(), l);
            }

        } catch (SQLException e) {
            System.out.println("DB Error: " + e.getMessage());
        }

        return map;
    }
}