package sample.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import sample.shopping.Cart;
import sample.shopping.Clothes;
import sample.utils.DBUtils;

/**
 *
 * @author truon
 */
public class UserDAO {

    private static final String LOGIN = "SELECT fullName, roleID FROM tblUsers WHERE userID = ? AND password = ?";
    private static final String SEARCH = "SELECT userID, fullName, roleID FROM tblUsers WHERE fullName like ?";
    private static final String DELETE = "DELETE tblUsers WHERE userID = ?";
    private static final String UPDATE = "UPDATE tblUsers SET fullName = ?, roleID = ? WHERE userID = ?";
    private static final String DUPLICATE = "SELECT fullName FROM tblUsers WHERE userID = ?";
    private static final String INSERT = "INSERT INTO tblUsers(userID,fullName,roleID,password) values (?,?,?,?)";
    private static final String GETSTORAGE = "SELECT productID, name, price, quantity FROM tblProduct";
    private static final String INSERTORDER = "INSERT INTO tblOrders(userID,total) values(?,?)";
    private static final String GETORDERID = "SELECT MAX(orderID) As orderID FROM tblOrders";
    private static final String INSERTORDERDETAIL = "INSERT INTO tblOrderDetail(orderID,productID, price, quantity) VALUES (?,?,?,?)";
     private static final String UPDATEQUANTITY = "UPDATE tblProduct SET quantity = quantity - ? WHERE productID = ?";
    public UserDTO checkLogin(String userID, String password) throws SQLException {
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(LOGIN);
                ptm.setString(1, userID);
                ptm.setString(2, password);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    String fullName = rs.getString("fullName");
                    String roleID = rs.getString("roleID");
                    user = new UserDTO(userID, fullName, roleID, "***");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return user;
    }

    public List<UserDTO> getListUser(String search) throws SQLException {
        List<UserDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(SEARCH);
                ptm.setString(1, "%" + search + "%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String userID = rs.getString("userID");
                    String fullName = rs.getString("fullName");
                    String roleID = rs.getString("roleID");
                    String password = "***";
                    list.add(new UserDTO(userID, fullName, roleID, password));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public boolean delete(String userID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn!=null){
                ptm = conn.prepareStatement(DELETE);
                ptm.setString(1, userID);
                check = ptm.executeUpdate()>0?true:false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm!=null) ptm.close();
            if (conn!=null) conn.close();
        }
        return check; 
    }

    public boolean update(UserDTO user) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn!=null){
                ptm = conn.prepareStatement(UPDATE);
                ptm.setString(1, user.getFullName());
                ptm.setString(2, user.getRoleID());
                ptm.setString(3, user.getUserID());
                check = ptm.executeUpdate()>0?true:false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm!=null) ptm.close();
            if (conn!=null) conn.close();
        }
        return check; 
    }

    public boolean checkDuplicate(String userID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DUPLICATE);
                ptm.setString(1, userID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    check = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public boolean insert(UserDTO user) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn!=null){
                ptm = conn.prepareStatement(INSERT);
                ptm.setString(1, user.getUserID());
                ptm.setString(2, user.getFullName());
                ptm.setString(3, user.getRoleID());
                ptm.setString(4, user.getPassword());
                check = ptm.executeUpdate()>0?true:false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm!=null) ptm.close();
            if (conn!=null) conn.close();
        }
        return check; 
        
    }

    public boolean insertv2(UserDTO user) throws SQLException, ClassNotFoundException, NamingException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn!=null){
                ptm = conn.prepareStatement(INSERT);
                ptm.setString(1, user.getUserID());
                ptm.setString(2, user.getFullName());
                ptm.setString(3, user.getRoleID());
                ptm.setString(4, user.getPassword());
                check = ptm.executeUpdate()>0?true:false;
            }
        }  finally {
            if (ptm!=null) ptm.close();
            if (conn!=null) conn.close();
        }
        return check; 
    }

    public Cart getStorage() throws SQLException {
        Cart storage = new Cart();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GETSTORAGE);
                rs = ptm.executeQuery();
                while (rs.next()) {                    
                    String productID = rs.getString("productID");
                    String name = rs.getString("name");
                    float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    storage.add(new Clothes(productID, name, price, quantity));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return storage;
        
    }
    public boolean checkout(UserDTO user, Cart cart, double total) throws SQLException {
        boolean check = false;
        check = insertOrder(user, total);
        int orderID = getOrderID();
        if (check) {
            if (orderID > 0) {
                check = inserOrderDetail(orderID, cart);
            }
            else {
                check = false;
            }
        }
        if (check) {
            check = updateQuantity(cart);
        }
        return check;
    }

    private boolean insertOrder(UserDTO user, double total) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(INSERTORDER);
                ptm.setString(1, user.getUserID());
                ptm.setDouble(2,total);
                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    private int getOrderID() throws SQLException {
        int orderID = 0;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GETORDERID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    orderID = rs.getInt("orderID");
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return orderID;
    }
    private boolean inserOrderDetail(int orderID, Cart cart) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                for (Clothes cloth : cart.getCart().values()) {
                    ptm = conn.prepareStatement(INSERTORDERDETAIL);
                    ptm.setInt(1, orderID);
                    ptm.setString(2, cloth.getId());
                    ptm.setFloat(3, cloth.getPrice());
                    ptm.setInt(4, cloth.getQuantity());
                    check = ptm.executeUpdate() > 0 ? true : false;
                    if (check) {
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }
    private boolean updateQuantity(Cart cart) throws SQLException {
        int orderID = 0;
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        PreparedStatement quantityPtm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                for (Clothes cloth : cart.getCart().values()) {
                    ptm = conn.prepareStatement(GETORDERID);
                    rs = ptm.executeQuery();
                    if (rs.next()) {
                        orderID = rs.getInt("orderID");
                        quantityPtm = conn.prepareStatement(UPDATEQUANTITY);
                quantityPtm.setInt(1, cloth.getQuantity());
                quantityPtm.setString(2, cloth.getId());
                
                check = quantityPtm.executeUpdate()>0?true:false;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (quantityPtm != null) {
                quantityPtm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }
}
