package dao;

import dbManager.dbManager;
import entity.Flight;
import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FlightDaoImpl implements FlightDao{
    private dbManager dbManager;

    public FlightDaoImpl(dbManager dbManager) {
        this.dbManager = dbManager;
    }

    @Override
    public int save(Flight flight) {
        String sql="INSERT INTO Flight(source,destination,doa,dod,toa,tod,costPerSeat,numOfSeat) VALUES (?,?,?,?,?,?,?,?)";
        try(Connection con=dbManager.getConnection();
            PreparedStatement stmt=con.prepareStatement(sql)){
            stmt.setString(1, flight.getSource());
            stmt.setString(2, flight.getDestination());
            stmt.setDate(3,flight.getDoa());
            stmt.setDate(4,flight.getDod());
            stmt.setTime(5,flight.getToa());
            stmt.setInt(6,flight.getCostPerSeat());
            stmt.setInt(7,flight.getNumOfSeat());

            return stmt.executeUpdate();
        }catch(SQLException e){
            System.out.println("DB Error: " + e.getMessage());
        }
        return 0;
    }

    @Override
    public Flight findByFlightNum(String flightNum) {
        String sql="SELECT * FROM Flight WHERE flightNum=?";
        try(Connection con=dbManager.getConnection();
        PreparedStatement stmt=con.prepareStatement(sql)){
            stmt.setString(1,flightNum);
            try(ResultSet rs=stmt.executeQuery()){
                if(rs.next()){
                    return mapToFlight(rs);
                }
            }
        }catch(SQLException e){
            System.out.println("DB Error: " + e.getMessage());

        }
        return null;
    }

    private Flight mapToFlight(ResultSet rs) throws SQLException {
        return new Flight(
                rs.getString("flightNum"),
                rs.getString("source"),
                rs.getString("destination"),
                rs.getDate("doa"),
                rs.getDate("dod"),
                rs.getTime("toa"),
                rs.getTime("tod"),
                rs.getInt("costPerSeat"),
                rs.getInt("numOfSeat")
        );
    }

    @Override
    public void deleteByFlightNum(String flightNum) {
        String sql="DELETE FROM Flight WHERE flightNum=?";
        try(Connection con= dbManager.getConnection();
        PreparedStatement stmt= con.prepareStatement(sql)){
            stmt.setString(1,flightNum);
            stmt.executeUpdate();
        }catch (SQLException e){
            System.out.println("DB Error: " + e.getMessage());
        }
    }

    @Override
    public void updateByFlightNum(String flightNum, Flight flight) {
        String sql="UPDATE Flight SET source=?,destination=?,doa=?,dod=?,toa=?, tod=?,costPerSeat=?,numOfSeat=?";
        try(Connection con= dbManager.getConnection();
        PreparedStatement stmt= con.prepareStatement(sql)){
            stmt.setString(1,flight.getDestination());
            stmt.setString(2,flight.getSource());
            stmt.setDate(3,flight.getDoa());
            stmt.setDate(4,flight.getDod());
            stmt.setTime(5,flight.getToa());
            stmt.setTime(6,flight.getTod());
            stmt.setInt(7,flight.getCostPerSeat());
            stmt.setInt(8,flight.getNumOfSeat());
            stmt.setString(9,flight.getFlightNum());
            stmt.executeUpdate();
        }catch (SQLException e){
            System.out.println("DB Error: " + e.getMessage());

        }

    }

    @Override
    public void deleteAll() {
        String sql="DELETE FROM Flight";
        try(Connection con= dbManager.getConnection();
        PreparedStatement stmt= con.prepareStatement(sql)){
            stmt.executeUpdate();
        }catch (SQLException e){
            System.out.println("DB Error: " + e.getMessage());
        }
    }

    @Override
    public Collection<Flight> findAll() {
        List<Flight> list=new ArrayList<>();
        String sql="SELECT * FROM Flight";
        try(Connection con= dbManager.getConnection();
        PreparedStatement stmt= con.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                list.add(mapToFlight(rs));
            }
        }catch (SQLException e){
            System.out.println("DB Error: " + e.getMessage());
        }
        return list;
    }

    @Override
    public Collection<Flight> findBySourceAndDestinationAndDepartureDate(String source, String destination, java.util.Date dod) {
        List<Flight> list = new ArrayList<>();
        String sql = "SELECT * FROM book WHERE source=? AND destination=? AND dod=?";

        try (Connection con = dbManager.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, source);
            stmt.setString(2, destination);
            stmt.setDate(3, (Date) dod);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                list.add(mapToFlight(rs));
            }

        } catch (SQLException e) {
            System.out.println("Issue in db connectivity: " + e.getMessage());
        }

        return list;
    }
}
