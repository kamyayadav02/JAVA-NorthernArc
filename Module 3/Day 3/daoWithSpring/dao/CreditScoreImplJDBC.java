package dao;

import config.dbManager;
import entity.CreditScore;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CreditScoreImplJDBC implements CreditScoreDao {
    private dbManager dbManager;
//constructor injection
    public CreditScoreImplJDBC(dbManager dbManager) {
        this.dbManager = dbManager;
    }

    @Override
    public int save(CreditScore creditScore) {
        String sql = "INSERT INTO CreditScore(id,score,rating) VALUES (?,?,?)";
        try (Connection con = dbManager.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1,creditScore.getId());

            stmt.setInt(2, creditScore.getScore());
            stmt.setString(3, creditScore.getRating());

            return stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("DB Error: " + e.getMessage());
        }
        return 0;

    }

    @Override
    public CreditScore findById(int id) {
        String sql = "SELECT * FROM CreditScore WHERE id=?";
        try (Connection con = dbManager.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapToCredit(rs);
                }

            }
        } catch (SQLException e) {
            System.out.println("DB Error: " + e.getMessage());
        }
        return null;
    }

    private CreditScore mapToCredit(ResultSet rs) throws SQLException {
        return new CreditScore(
                rs.getInt("id")
        );
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM CreditScore WHERE id=?";
        try (
                Connection con = dbManager.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void updateById(int id, CreditScore creditScore) {
        String sql = "Update CreditScore set score=?,rating=? WHERE id=?";
        try (
                Connection con = dbManager.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, creditScore.getScore());
            stmt.setString(2, creditScore.getRating());
            stmt.setInt(3, id);

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("DB Error: " + e.getMessage());
        }
    }

    @Override
    public void deleteAll() {
        String sql = "DELETE FROM CreditScore";

        try (Connection con = dbManager.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("DB Error: " + e.getMessage());
        }

    }

    @Override
    public Collection<CreditScore> findAll() {
        List<CreditScore> list = new ArrayList<>();
        String sql = "SELECT * FROM CreditScore";

        try (Connection con = dbManager.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                list.add(mapToCredit(rs));
            }

        } catch (SQLException e) {
            System.out.println("DB Error: " + e.getMessage());
        }

        return list;
    }
}
