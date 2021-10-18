/**
 * 
 */
package com.ss.utopia.service;

import com.ss.utopia.dao.*;
import com.ss.utopia.entity.*;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Colin Bradshaw
 *
 */
@Service
public class AdminService {
	ConnectionUtil connUtil = new ConnectionUtil();
	
	// read operations
	public List<Airport> readAirports(String sql, Object[] param) throws SQLException, ClassNotFoundException{
		Connection conn = connUtil.getConnection();
		try {
			AirportDAO aDAO = new AirportDAO(conn);
			ArrayList<Airport> all= (ArrayList<Airport>) aDAO.read(sql, param);
			return all;
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null) {
				conn.rollback();
			}
		} finally {
			if(conn!=null) {
				conn.close();
			}
		}
		return null;
	}
	public List<Route> readRoutes(String sql, Object[] param) throws SQLException, ClassNotFoundException {
		Connection conn = connUtil.getConnection();
		try {
			RouteDAO rDAO = new RouteDAO(conn);
			ArrayList<Route> all= (ArrayList<Route>) rDAO.read(sql, param);
			return all;
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null) {
				conn.rollback();
			}
		} finally {
			if(conn!=null) {
				conn.close();
			}
		}
		return null;
	}
	public List<Airplane_Type> readAirplaneTypes(String sql, Object[] param) throws SQLException, ClassNotFoundException{
		Connection conn = connUtil.getConnection();
		try {
			Airplane_TypeDAO aDAO = new Airplane_TypeDAO(conn);
			ArrayList<Airplane_Type> all= (ArrayList<Airplane_Type>) aDAO.read(sql, param);
			return all;
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null) {
				conn.rollback();
			}
		} finally {
			if(conn!=null) {
				conn.close();
			}
		}
		return null;
	}
	public List<Airplane> readAirplanes(String sql, Object[] param) throws SQLException, ClassNotFoundException {
		Connection conn = connUtil.getConnection();
		try {
			AirplaneDAO aDAO = new AirplaneDAO(conn);
			ArrayList<Airplane> all= (ArrayList<Airplane>) aDAO.read(sql, param);
			return all;
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null) {
				conn.rollback();
			}
		} finally {
			if(conn!=null) {
				conn.close();
			}
		}
		return null;
	}
	public List<Flight> readFlights(String sql, Object[] param) throws SQLException, ClassNotFoundException {
		Connection conn = connUtil.getConnection();
		try {
			FlightDAO fDAO = new FlightDAO(conn);
			ArrayList<Flight> all= (ArrayList<Flight>) fDAO.read(sql, param);
			return all;
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null) {
				conn.rollback();
			}
		} finally {
			if(conn!=null) {
				conn.close();
			}
		}
		return null;
	}
	public List<Flight_Bookings> readFlightBookings(String sql, Object[] param) throws SQLException, ClassNotFoundException {
		Connection conn = connUtil.getConnection();
		try {
			Flight_BookingsDAO fbDAO = new Flight_BookingsDAO(conn);
			ArrayList<Flight_Bookings> all= (ArrayList<Flight_Bookings>) fbDAO.read(sql, param);
			return all;
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null) {
				conn.rollback();
			}
		} finally {
			if(conn!=null) {
				conn.close();
			}
		}
		return null;
	}
	public List<Booking> readBookings(String sql, Object[] param) throws SQLException, ClassNotFoundException{
		Connection conn = connUtil.getConnection();
		try {
			BookingDAO bDAO = new BookingDAO(conn);
			ArrayList<Booking> all= (ArrayList<Booking>) bDAO.read(sql, param);
			return all;
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null) {
				conn.rollback();
			}
		} finally {
			if(conn!=null) {
				conn.close();
			}
		}
		return null;
	}
	public List<Booking_Payment> readBookingPayments(String sql, Object[] param) throws SQLException, ClassNotFoundException{
		Connection conn = connUtil.getConnection();
		try {
			Booking_PaymentDAO bpDAO = new Booking_PaymentDAO(conn);
			ArrayList<Booking_Payment> all= (ArrayList<Booking_Payment>) bpDAO.read(sql, param);
			return all;
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null) {
				conn.rollback();
			}
		} finally {
			if(conn!=null) {
				conn.close();
			}
		}
		return null;
	}
	public List<Booking_Agent> readBookingAgents(String sql, Object[] param) throws SQLException, ClassNotFoundException{
		Connection conn = connUtil.getConnection();
		try {
			Booking_AgentDAO baDAO = new Booking_AgentDAO(conn);
			ArrayList<Booking_Agent> all= (ArrayList<Booking_Agent>) baDAO.read(sql, param);
			return all;
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null) {
				conn.rollback();
			}
		} finally {
			if(conn!=null) {
				conn.close();
			}
		}
		return null;
	}
	public List<Booking_User> readBookingUsers(String sql, Object[] param) throws SQLException, ClassNotFoundException{
		Connection conn = connUtil.getConnection();
		try {
			Booking_UserDAO buDAO = new Booking_UserDAO(conn);
			ArrayList<Booking_User> all= (ArrayList<Booking_User>) buDAO.read(sql, param);
			return all;
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null) {
				conn.rollback();
			}
		} finally {
			if(conn!=null) {
				conn.close();
			}
		}
		return null;
	}
	public List<Booking_Guest> readBookingGuests(String sql, Object[] param) throws SQLException, ClassNotFoundException{
		Connection conn = connUtil.getConnection();
		try {
			Booking_GuestDAO buDAO = new Booking_GuestDAO(conn);
			ArrayList<Booking_Guest> all= (ArrayList<Booking_Guest>) buDAO.read(sql, param);
			return all;
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null) {
				conn.rollback();
			}
		} finally {
			if(conn!=null) {
				conn.close();
			}
		}
		return null;
	}
	public List<User> readUsers(String sql, Object[] param) throws SQLException, ClassNotFoundException{
		Connection conn = connUtil.getConnection();
		try {
			UserDAO uDAO = new UserDAO(conn);
			ArrayList<User> all= (ArrayList<User>) uDAO.read(sql, param);
			return all;
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null) {
				conn.rollback();
			}
		} finally {
			if(conn!=null) {
				conn.close();
			}
		}
		return null;
	}
	public List<User_Role> readUserRoles(String sql, Object[] param) throws SQLException, ClassNotFoundException{
		Connection conn = connUtil.getConnection();
		try {
			User_RoleDAO urDAO = new User_RoleDAO(conn);
			ArrayList<User_Role> all= (ArrayList<User_Role>) urDAO.read(sql, param);
			return all;
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null) {
				conn.rollback();
			}
		} finally {
			if(conn!=null) {
				conn.close();
			}
		}
		return null;
	}
	public List<Passenger> readPassengers(String sql, Object[] param) throws SQLException, ClassNotFoundException{
		Connection conn = connUtil.getConnection();
		try {
			PassengerDAO pDAO = new PassengerDAO(conn);
			ArrayList<Passenger> all= (ArrayList<Passenger>) pDAO.read(sql, param);
			return all;
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null) {
				conn.rollback();
			}
		} finally {
			if(conn!=null) {
				conn.close();
			}
		}
		return null;
	}
	
	// add operations
	public Boolean addAirport(String iata, String city) throws ClassNotFoundException, SQLException {
		Connection conn = connUtil.getConnection();
		try {
			AirportDAO aDAO = new AirportDAO(conn);
			aDAO.save("INSERT INTO airport VALUES (?, ?)", (new Object[] {iata, city}));
			conn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null) {
				conn.rollback();
			}
			return false;
		} finally {
			if(conn!=null) {
				conn.close();
			}
		}
	}
	public Integer addRoute(String ori, String dest) throws ClassNotFoundException, SQLException {
		Connection conn = connUtil.getConnection();
		try {
			RouteDAO rDAO = new RouteDAO(conn);
			Integer ret = rDAO.saveWithPK("INSERT INTO route SET origin_id = (SELECT iata_id FROM airport WHERE iata_id = ?),"
					+ "destination_id = (SELECT iata_id FROM airport WHERE iata_id = ?)", (new Object[] {ori.subSequence(0, 3), dest.subSequence(0, 3)}));
			conn.commit();
			return ret;
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null) {
				conn.rollback();
			}
			return null;
		} finally {
			if(conn!=null) {
				conn.close();
			}
		}
	}
	public Integer addAirplaneType(Integer maxCapacity) throws ClassNotFoundException, SQLException{
		Connection conn = connUtil.getConnection();
		try {
			Airplane_TypeDAO atDAO = new Airplane_TypeDAO(conn);
			Integer ret = atDAO.saveWithPK("INSERT INTO airplane_type(max_capacity) VALUES (?)", (new Object[] {maxCapacity}));
			conn.commit();
			return ret;
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null) {
				conn.rollback();
			}
			return null;
		} finally {
			if(conn!=null) {
				conn.close();
			}
		}
	}
	public Integer addAirplane(Integer type) throws ClassNotFoundException, SQLException{
		Connection conn = connUtil.getConnection();
		try {
			Airplane_TypeDAO atDAO = new Airplane_TypeDAO(conn);
			Integer ret = atDAO.saveWithPK("INSERT INTO airplane(type_id) VALUES (?)", (new Object[] {type}));
			conn.commit();
			return ret;
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null) {
				conn.rollback();
			}
			return null;
		} finally {
			if(conn!=null) {
				conn.close();
			}
		}
	}
	public Boolean addFlight(Integer id, Integer rt_id, Integer air_id, String dateTime, Integer res, Float price) throws ClassNotFoundException, SQLException  {
		Connection conn = connUtil.getConnection();
		try {
			FlightDAO fDAO = new FlightDAO(conn);
			fDAO.save("INSERT INTO flight SET id = ?, route_id = (SELECT id FROM route WHERE id = ?),"
					+ "airplane_id = (SELECT id FROM airplane WHERE id = ?),"
					+ "departure_time = ?, reserved_seats = ?, seat_price = ?",
					(new Object[] {id, rt_id, air_id, dateTime, res, price}));
			conn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null) {
				conn.rollback();
			}
			return false;
		} finally {
			if(conn!=null) {
				conn.close();
			}
		}
	}
	public Boolean addFlightBooking(Integer book_id, Integer flight_id) throws ClassNotFoundException, SQLException {
		Connection conn = connUtil.getConnection();
		try {
			BookingDAO bDAO = new BookingDAO(conn);
			bDAO.save("INSERT INTO flight_bookings SET flight_id = ?, booking_id = ?", (new Object[] { flight_id, book_id}));
			conn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null) {
				conn.rollback();
			}
			return false;
		} finally {
			if(conn!=null) {
				conn.close();
			}
		}
	}
	public Integer addBooking(Boolean isActive, String autoGen) throws ClassNotFoundException, SQLException  {
		Connection conn = connUtil.getConnection();
		try {
			BookingDAO bDAO = new BookingDAO(conn);
			int ret = bDAO.saveWithPK("INSERT INTO booking SET is_active = ?, confirmation_code = ?",
					(new Object[] { (isActive?1:0), autoGen}));
			conn.commit();
			return ret;
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null) {
				conn.rollback();
			}
			return null;
		} finally {
			if(conn!=null) {
				conn.close();
			}
		}
	}
	public Boolean addBookingPayment(Integer bookingID, String stripe, Boolean refunded) throws ClassNotFoundException, SQLException{
		Connection conn = connUtil.getConnection();
		try {
			Booking_PaymentDAO bpDAO = new Booking_PaymentDAO(conn);
			bpDAO.save("INSERT INTO booking_payment SET booking_id = ?, stripe_id = ?, refunded = ?",
					(new Object[] { bookingID, stripe, (refunded?1:0)}));
			conn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null) {
				conn.rollback();
			}
			return false;
		} finally {
			if(conn!=null) {
				conn.close();
			}
		}
	}
	public Boolean addBookingAgent(Integer bookingID, Integer agentID) throws ClassNotFoundException, SQLException{
		Connection conn = connUtil.getConnection();
		try {
			Booking_AgentDAO baDAO = new Booking_AgentDAO(conn);
			baDAO.save("INSERT INTO booking_agent SET booking_id = ?, agent_id = ?",
					(new Object[] { bookingID, agentID}));
			conn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null) {
				conn.rollback();
			}
			return false;
		} finally {
			if(conn!=null) {
				conn.close();
			}
		}
	}
	public Boolean addBookingUser(Integer bookingID, Integer userID) throws ClassNotFoundException, SQLException{
		Connection conn = connUtil.getConnection();
		try {
			Booking_UserDAO buDAO = new Booking_UserDAO(conn);
			buDAO.save("INSERT INTO booking_user SET booking_id = ?, user_id = ?",
					(new Object[] { bookingID, userID}));
			conn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null) {
				conn.rollback();
			}
			return false;
		} finally {
			if(conn!=null) {
				conn.close();
			}
		}
	}
	public Boolean addBookingGuest(Integer bookingID, String email, String phone) throws ClassNotFoundException, SQLException{
		Connection conn = connUtil.getConnection();
		try {
			Booking_GuestDAO bgDAO = new Booking_GuestDAO(conn);
			bgDAO.save("INSERT INTO booking_guest SET booking_id = ?, contact_email = ?, contact_phone = ?",
					(new Object[] { bookingID, email, phone}));
			conn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null) {
				conn.rollback();
			}
			return false;
		} finally {
			if(conn!=null) {
				conn.close();
			}
		}
	}
	public Boolean addUser(Integer role, String fName, String lName, String uName, String email, String password, String phone) throws ClassNotFoundException, SQLException {
		Connection conn = connUtil.getConnection();
		try {
			FlightDAO fDAO = new FlightDAO(conn);
			fDAO.saveWithPK("INSERT INTO user SET  role_id = ?, given_name = ?, family_name = ?, username = ?, email = ?, password = ?, phone = ?", 
					(new Object[] {role, fName, lName, uName, email, password, phone}));
			conn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null) {
				conn.rollback();
			}
			return false;
		} finally {
			if(conn!=null) {
				conn.close();
			}
		}
	}
	public Integer addUserRole(String name) throws ClassNotFoundException, SQLException {
		Connection conn = connUtil.getConnection();
		try {
			User_RoleDAO urDAO = new User_RoleDAO(conn);
			Integer ret = urDAO.saveWithPK("INSERT INTO user_role VALUES (?)", (new Object[] {name}));
			conn.commit();
			return ret;
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null) {
				conn.rollback();
			}
			return null;
		} finally {
			if(conn!=null) {
				conn.close();
			}
		}
	}
	public Boolean addPassenger(Integer book_id, String fName, String lName, String dob, String gender, String address) throws ClassNotFoundException, SQLException {
		Connection conn = connUtil.getConnection();
		try {
			PassengerDAO pDAO = new PassengerDAO(conn);
			pDAO.saveWithPK("INSERT INTO passenger SET  booking_id = ?, given_name = ?, family_name = ?, dob = ?, gender = ?, address = ?", 
					(new Object[] {book_id, fName, lName, dob, gender, address}));
			conn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null) {
				conn.rollback();
			}
			return false;
		} finally {
			if(conn!=null) {
				conn.close();
			}
		}
	}

	// delete operations
	public Boolean deleteAirport(String iata) throws ClassNotFoundException, SQLException {
		Connection conn = connUtil.getConnection();
		try {
			AirportDAO aDAO = new AirportDAO(conn);
			aDAO.save("DELETE FROM airport WHERE iata_id = ?", new Object[] {iata});
			conn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null) {
				conn.rollback();
			}
			return false;
		} finally {
			if(conn!=null) {
				conn.close();
			}
		}
	}
	public Boolean deleteRoute(String ori, String dest) throws ClassNotFoundException, SQLException {
		Connection conn = connUtil.getConnection();
		try {
			RouteDAO rDAO = new RouteDAO(conn);
			rDAO.save("DELETE FROM route WHERE origin_id = ?, AND destination_id = ?",  new Object[] {ori, dest});
			conn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null) {
				conn.rollback();
			}
			return false;
		} finally {
			if(conn!=null) {
				conn.close();
			}
		}
	}
	public Boolean deleteAirplaneType(Integer id) throws ClassNotFoundException, SQLException {
		Connection conn = connUtil.getConnection();
		try {
			Airplane_TypeDAO atDAO = new Airplane_TypeDAO(conn);
			atDAO.save("DELETE FROM airplane_type WHERE id = ?", new Object[] {id});
			conn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null) {
				conn.rollback();
			}
			return false;
		} finally {
			if(conn!=null) {
				conn.close();
			}
		}
	}
	public Boolean deleteAirplane(Integer id) throws ClassNotFoundException, SQLException {
		Connection conn = connUtil.getConnection();
		try {
			AirplaneDAO aDAO = new AirplaneDAO(conn);
			aDAO.save("DELETE FROM airplane WHERE id = ?", new Object[]{id});
			conn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null) {
				conn.rollback();
			}
			return false;
		} finally {
			if(conn!=null) {
				conn.close();
			}
		}
	}
	public Boolean deleteFlight(Integer id)  throws ClassNotFoundException, SQLException{
		Connection conn = connUtil.getConnection();
		try {
			FlightDAO fDAO = new FlightDAO(conn);
			fDAO.save("DELETE FROM flight WHERE id = " + "'" + id + "'", null);
			conn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null) {
				conn.rollback();
			}
			return false;
		} finally {
			if(conn!=null) {
				conn.close();
			}
		}
	}
	public Boolean deleteFlightBooking(Integer flightID, Integer bookingID) throws ClassNotFoundException, SQLException{
		Connection conn = connUtil.getConnection();
		try {
			Flight_BookingsDAO fbDAO = new Flight_BookingsDAO(conn);
			fbDAO.save("DELETE FROM flight_bookings WHERE flight_id = ? AND booking_id = ?",
					new Object[]{flightID, bookingID});
			conn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null) {
				conn.rollback();
			}
			return false;
		} finally {
			if(conn!=null) {
				conn.close();
			}
		}
	}
	public Boolean deleteBooking(Integer id) throws ClassNotFoundException, SQLException{
		Connection conn = connUtil.getConnection();
		try {
			BookingDAO bDAO = new BookingDAO(conn);
			bDAO.save("DELETE FROM booking WHERE id = ?", new Object[]{id});
			conn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null) {
				conn.rollback();
			}
			return false;
		} finally {
			if(conn!=null) {
				conn.close();
			}
		}
	}
	public Boolean deleteBookingPayment(Integer id) throws ClassNotFoundException, SQLException{
		Connection conn = connUtil.getConnection();
		try {
			Booking_PaymentDAO bpDAO = new Booking_PaymentDAO(conn);
			bpDAO.save("DELETE FROM booking_payment WHERE booking_id = ?", new Object[]{id});
			conn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null) {
				conn.rollback();
			}
			return false;
		} finally {
			if(conn!=null) {
				conn.close();
			}
		}
	}
	public Boolean deleteBookingAgent(Integer id) throws ClassNotFoundException, SQLException{
		Connection conn = connUtil.getConnection();
		try {
			Booking_AgentDAO baDAO = new Booking_AgentDAO(conn);
			baDAO.save("DELETE FROM booking_agent WHERE booking_id = ?", new Object[]{id});
			conn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null) {
				conn.rollback();
			}
			return false;
		} finally {
			if(conn!=null) {
				conn.close();
			}
		}
	}
	public Boolean deleteBookingUser(Integer id) throws ClassNotFoundException, SQLException{
		Connection conn = connUtil.getConnection();
		try {
			Booking_UserDAO buDAO = new Booking_UserDAO(conn);
			buDAO.save("DELETE FROM booking_user WHERE booking_id = ?", new Object[]{id});
			conn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null) {
				conn.rollback();
			}
			return false;
		} finally {
			if(conn!=null) {
				conn.close();
			}
		}
	}
	public Boolean deleteBookingGuest(Integer id) throws ClassNotFoundException, SQLException{
		Connection conn = connUtil.getConnection();
		try {
			Booking_GuestDAO bgDAO = new Booking_GuestDAO(conn);
			bgDAO.save("DELETE FROM booking_guest WHERE booking_id = ?", new Object[]{id});
			conn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null) {
				conn.rollback();
			}
			return false;
		} finally {
			if(conn!=null) {
				conn.close();
			}
		}
	}
	public Boolean deleteUser(Integer id)  throws ClassNotFoundException, SQLException {
		Connection conn = connUtil.getConnection();
		try {
			UserDAO uDAO = new UserDAO(conn);
			uDAO.save("DELETE FROM user WHERE id = " + "'" + id + "'", null);
			conn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null) {
				conn.rollback();
			}
			return false;
		} finally {
			if(conn!=null) {
				conn.close();
			}
		}
	}
	public Boolean deleteUserRole(Integer id) throws ClassNotFoundException, SQLException{
		Connection conn = connUtil.getConnection();
		try {
			User_RoleDAO urDAO = new User_RoleDAO(conn);
			urDAO.save("DELETE FROM user_role WHERE id = ?", new Object[]{id});
			conn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null) {
				conn.rollback();
			}
			return false;
		} finally {
			if(conn!=null) {
				conn.close();
			}
		}
	}
	public Boolean deletePassenger(Integer id)  throws ClassNotFoundException, SQLException{
		Connection conn = connUtil.getConnection();
		try {
			PassengerDAO pDAO = new PassengerDAO(conn);
			pDAO.save("DELETE FROM passenger WHERE id = " + "'" + id + "'", null);
			conn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null) {
				conn.rollback();
			}
			return false;
		} finally {
			if(conn!=null) {
				conn.close();
			}
		}
	}

	// update operations
	public Boolean updateAirport(Airport original, Airport updated) throws ClassNotFoundException, SQLException {
		Connection conn = connUtil.getConnection();
		try {
			AirportDAO aDAO = new AirportDAO(conn);
			aDAO.save("UPDATE airport SET iata_id ?, city = ? WHERE iata_id = ?",
					new Object[]{updated.getIata_ID(), updated.getCity(), original.getIata_ID()});
			conn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null) {
				conn.rollback();
			}
			return false;
		} finally {
			if(conn!=null) {
				conn.close();
			}
		}
	}
	public Boolean updateRoute(Route r) throws ClassNotFoundException, SQLException {
		Connection conn = connUtil.getConnection();
		try {
			RouteDAO rDAO = new RouteDAO(conn);
			rDAO.save("UPDATE route SET origin_id = (SELECT iata_id FROM airport WHERE iata_id = ?)," +
					"destination_id = (SELECT iata_id FROM airport WHERE iata_id = ?) WHERE id = ?",
					(new Object[] {r.getOrigin_ID(), r.getDestination_ID(), r.getId()}));
			conn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null) {
				conn.rollback();
			}
			return false;
		} finally {
			if(conn!=null) {
				conn.close();
			}
		}
	}
	public Boolean updateAirplaneType(Airplane_Type a) throws ClassNotFoundException, SQLException{
		Connection conn = connUtil.getConnection();
		try {
			Airplane_TypeDAO atDAO = new Airplane_TypeDAO(conn);
			atDAO.save("UPDATE airplane_type SET max_capacity = ? WHERE id = ?",
					(new Object[] {a.getMax_capacity(), a.getId()}));
			conn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null) {
				conn.rollback();
			}
			return false;
		} finally {
			if(conn!=null) {
				conn.close();
			}
		}
	}
	public Boolean updateAirplane(Airplane a) throws ClassNotFoundException, SQLException{
		Connection conn = connUtil.getConnection();
		try {
			Airplane_TypeDAO atDAO = new Airplane_TypeDAO(conn);
			atDAO.save("UPDATE airplane SET type_id = (SELECT id FROM airplane_type WHERE id = ?) WHERE id = ?",
					(new Object[] {a.getType_id(), a.getId()}));
			conn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null) {
				conn.rollback();
			}
			return false;
		} finally {
			if(conn!=null) {
				conn.close();
			}
		}
	}
	public Boolean updateFlight(Flight f) throws ClassNotFoundException, SQLException {
		Connection conn = connUtil.getConnection();
		try {
			FlightDAO fDAO = new FlightDAO(conn);
			fDAO.save("UPDATE flight SET route_id = (SELECT id FROM route WHERE id = ?),"
					+ "airplane_id = (SELECT id FROM airplane WHERE id = ?),"
					+ "departure_time = ?, reserved_seats = ?, seat_price = ? WHERE id = ?",
					(new Object[] {f.getRoute_ID(), f.getAirplane_ID(),
							f.getDeparture_Time().toLocalDate() + " " + f.getDeparture_Time().toLocalTime(),
							f.getReservedSeats(), f.getseatPrice(), f.getId()}));
			conn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null) {
				conn.rollback();
			}
			return false;
		} finally {
			if(conn!=null) {
				conn.close();
			}
		}
	}
	public Boolean updateFlightBookings(Flight_Bookings original, Flight_Bookings updated) throws ClassNotFoundException, SQLException{
		Connection conn = connUtil.getConnection();
		try {
			Flight_BookingsDAO fbDAO = new Flight_BookingsDAO(conn);
			fbDAO.save("UPDATE flight_bookings SET flight_id = ?, booking_id = ? " +
							"WHERE flight_id = ? AND booking_id = ?",
					(new Object[] {updated.getFlight_ID(), updated.getBooking_ID(),
							original.getFlight_ID(), original.getBooking_ID()}));
			conn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null) {
				conn.rollback();
			}
			return false;
		} finally {
			if(conn!=null) {
				conn.close();
			}
		}
	}
	public Boolean updateBooking(Booking b) throws ClassNotFoundException, SQLException{
		Connection conn = connUtil.getConnection();
		try {
			BookingDAO bDAO = new BookingDAO(conn);
			bDAO.save("UPDATE booking SET is_active = ?, confirmation_code = ? WHERE id = ?",
					(new Object[] {(b.getIsActive()?1:0), b.getConfirmation_Code(), b.getId() }));
			conn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null) {
				conn.rollback();
			}
			return false;
		} finally {
			if(conn!=null) {
				conn.close();
			}
		}
	}
	public Boolean updateBookingPayment(Booking_Payment bp) throws ClassNotFoundException, SQLException{
		Connection conn = connUtil.getConnection();
		try {
			Booking_PaymentDAO bpDAO = new Booking_PaymentDAO(conn);
			bpDAO.save("UPDATE booking_payment SET stripe_id = ?, refunded = ? WHERE booking_id = " +
							"(SELECT id FROM booking WHERE id = ?",
					(new Object[] {bp.getStripe_ID(), bp.getRefunded(), bp.getBooking_ID()}));
			conn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null) {
				conn.rollback();
			}
			return false;
		} finally {
			if(conn!=null) {
				conn.close();
			}
		}
	}
	public Boolean updateBookingAgent(Booking_Agent ba) throws ClassNotFoundException, SQLException{
		Connection conn = connUtil.getConnection();
		try {
			Booking_AgentDAO baDAO = new Booking_AgentDAO(conn);
			baDAO.save("UPDATE booking_agent SET agent_id = (SELECT id FROM user WHERE id = ?)" +
							"WHERE booking_id = (SELECT id FROM booking WHERE id = ?)",
					(new Object[] {ba.getAgent_ID(), ba.getBooking_ID()}));
			conn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null) {
				conn.rollback();
			}
			return false;
		} finally {
			if(conn!=null) {
				conn.close();
			}
		}
	}
	public Boolean updateBookingUser(Booking_User bu) throws ClassNotFoundException, SQLException{
		Connection conn = connUtil.getConnection();
		try {
			Booking_UserDAO buDAO = new Booking_UserDAO(conn);
			buDAO.save("UPDATE booking_user SET user_id = (SELECT id FROM user WHERE id = ?)" +
							"WHERE booking_id = (SELECT id FROM booking WHERE id = ?)",
					(new Object[] {bu.getUser_ID(), bu.getBooking_ID()}));
			conn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null) {
				conn.rollback();
			}
			return false;
		} finally {
			if(conn!=null) {
				conn.close();
			}
		}
	}
	public Boolean updateBookingGuest(Booking_Guest bg) throws ClassNotFoundException, SQLException{
		Connection conn = connUtil.getConnection();
		try {
			Booking_GuestDAO bgDAO = new Booking_GuestDAO(conn);
			bgDAO.save("UPDATE booking_guest SET contact_email = ?, contact_phone = ?) " +
							"WHERE booking_id = (SELECT id FROM booking WHERE id = ?)",
					(new Object[] {bg.getContact_email(), bg.getContact_Phone(), bg.getBooking_ID()}));
			conn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null) {
				conn.rollback();
			}
			return false;
		} finally {
			if(conn!=null) {
				conn.close();
			}
		}
	}
	public Boolean updateUser(User u) throws ClassNotFoundException, SQLException {
		Connection conn = connUtil.getConnection();
		try {
			UserDAO uDAO = new UserDAO(conn);
			uDAO.save("UPDATE user SET role_id = (SELECT id FROM role WHERE id = ?), given_name = ?," +
							"family_name = ?, username = ?, email = ?, password = ?, phone =? WHERE id = ?",
					(new Object[] {u.getRole_ID(), u.getGiven_Name(), u.getFamily_Name(), u.getUsername(), u.getEmail(),
							u.getPassword(), u.getPhone(), u.getId()}));
			conn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null) {
				conn.rollback();
			}
			return false;
		} finally {
			if(conn!=null) {
				conn.close();
			}
		}
	}
	public Boolean updateUserRole(User_Role ur) throws ClassNotFoundException, SQLException{
		Connection conn = connUtil.getConnection();
		try {
			User_RoleDAO urDAO = new User_RoleDAO(conn);
			urDAO.save("UPDATE user_role SET name = ? WHERE id = ?)", (new Object[] {ur.getName(), ur.getId()}));
			conn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null) {
				conn.rollback();
			}
			return false;
		} finally {
			if(conn!=null) {
				conn.close();
			}
		}
	}
	public Boolean updatePassenger(Passenger p)  throws ClassNotFoundException, SQLException {
		Connection conn = connUtil.getConnection();
		try {
			PassengerDAO pDAO = new PassengerDAO(conn);
			pDAO.save("UPDATE passenger SET booking_id = (SELECT id FROM booking WHERE id = ?)," +
					"given_name = ?, family_name = ?, dob = ?, gender = ?, address = ? WHERE id = ?",
					(new Object[] {p.getBooking_ID(), p.getGiven_Name(), p.getFamily_Name(), p.getDob(), p.getGender(),
							p.getAddress(), p.getId()}));
			conn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null) {
				conn.rollback();
			}
			return false;
		} finally {
			if(conn!=null) {
				conn.close();
			}
		}
	}





}
