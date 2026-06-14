package dao;

import connection.dbManager;
import entity.Loan;

import java.sql.*;
import java.util.*;

public class LoanDaoImpl implements LoanDao {

    private Loan mapToLoan(ResultSet rs) throws SQLException {
        return new Loan(
                rs.getInt("loanid"),
                rs.getString("loanType"),
                rs.getInt("loanAmount"),
                rs.getString("loanStatus"),
                rs.getDouble("interest"),
                rs.getInt("tenure")
        );
    }

    @Override
    public int save(Loan loan) {
        int rows = 0;
        try (Connection con = dbManager.getConnection()) {

            String sql = "INSERT INTO loan(loanType, loanAmount, loanStatus, interest, tenure) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, loan.getLoanType());
            stmt.setInt(2, loan.getLoanAmount());
            stmt.setString(3, loan.getLoanStatus());
            stmt.setDouble(4, loan.getInterest());
            stmt.setInt(5, loan.getTenure());

            rows = stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("DB Error: " + e.getMessage());
        }
        return rows;
    }

    @Override
    public Loan findById(int loanid) {
        try (Connection con = dbManager.getConnection()) {

            String sql = "SELECT * FROM loan WHERE loanid=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, loanid);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return mapToLoan(rs);
            }

        } catch (SQLException e) {
            System.out.println("DB Error: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Collection<Loan> findAll() {
        List<Loan> list = new ArrayList<>();

        try (Connection con = dbManager.getConnection()) {

            String sql = "SELECT * FROM loan";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                list.add(mapToLoan(rs));
            }

        } catch (SQLException e) {
            System.out.println("DB Error: " + e.getMessage());
        }
        return list;
    }

    @Override
    public void deleteById(int loanid) {
        try (Connection con = dbManager.getConnection()) {

            String sql = "DELETE FROM loan WHERE loanid=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, loanid);

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("DB Error: " + e.getMessage());
        }
    }

    @Override
    public void updateById(int loanid, Loan loan) {
        try (Connection con = dbManager.getConnection()) {

            String sql = "UPDATE loan SET loanType=?, loanAmount=?, loanStatus=?, interest=?, tenure=? WHERE loanid=?";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, loan.getLoanType());
            stmt.setInt(2, loan.getLoanAmount());
            stmt.setString(3, loan.getLoanStatus());
            stmt.setDouble(4, loan.getInterest());
            stmt.setInt(5, loan.getTenure());
            stmt.setInt(6, loanid);

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("DB Error: " + e.getMessage());
        }
    }

    @Override
    public Collection<Loan> findByStatus(String status) {
        List<Loan> list = new ArrayList<>();

        try (Connection con = dbManager.getConnection()) {

            String sql = "SELECT * FROM loan WHERE loanStatus=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, status);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                list.add(mapToLoan(rs));
            }

        } catch (SQLException e) {
            System.out.println("DB Error: " + e.getMessage());
        }
        return list;
    }

    @Override
    public Collection<Loan> findByType(String loanType) {
        List<Loan> list = new ArrayList<>();

        try (Connection con = dbManager.getConnection()) {

            String sql = "SELECT * FROM loan WHERE loanType=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, loanType);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                list.add(mapToLoan(rs));
            }

        } catch (SQLException e) {
            System.out.println("DB Error: " + e.getMessage());
        }
        return list;
    }
}