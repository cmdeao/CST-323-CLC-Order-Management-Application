package com.gcu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import Model.Order;

import org.springframework.jdbc.core.RowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * OrderDao class.
 * @author Cameron Deao & John Harrison
 *
 */
public class OrderDao
{
	//Global variables to be used within this Java Class.
    JdbcTemplate template;
    Logger logger = LoggerFactory.getLogger(OrderDao.class);
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	
	/**
	 * setTemplate() - Establishing the template variable.
	 * @param template
	 */
    public void setTemplate(JdbcTemplate template)
    {
        this.template = template;
    }

    //Methods to insert, update, delete, and retrieve data from the database.
    //Methods utilize SQL statements to insert and retrieve updated information.
    /**
     * save() - stores passed data into the database.
     * @param order
     * @return
     */
    public int save(Order order)
    {
        String sql = "INSERT INTO CST323.orders(user_id, description, total, card_last_four, status, item) values('"+order.getUser_id()+"','"+order.getDescription()+"','"+order.getTotal()+"','"+order.getCard_last_four()+"','"+order.getStatus()+"','"+order.getItem()+"');";
        logger.debug("Added " + order.getItem() + " into database. Timestamp: " + sdf.format(timestamp));
        return template.update(sql);
    }

    /**
     * update() - updates information within the database.
     * @param order
     * @return
     */
    public int update(Order order)
    {
        String sql = "UPDATE CST323.orders SET user_id'"+order.getId()+"',description='"+order.getDescription()+"',total='"+order.getTotal()+"',card_last_four='"+order.getCard_last_four()+"',status='"+order.getStatus()+"',item='"+order.getItem()+"' WHERE id='"+order.getId()+"';";
        logger.debug("Updated " + order.getId() + " within the database. Timestamp: " + sdf.format(timestamp));
        return template.update(sql);
    }

    /**
     * delete() - deletes specific entry in database.
     * @param id
     * @return
     */
    public int delete(int id)
    {
        String sql = "DELETE FROM CST323.orders WHERE id="+id+"";
        logger.debug("Deleted " + id + " from the database. Timestamp: " + sdf.format(timestamp));
        return template.update(sql);
    }

    /**
     * getOrders() - retrieves the table of data from the database.
     * @return
     */
    public List<Order> getOrders()
    {
        String sql = "SELECT * FROM CST323.orders";
        return template.query(sql, new RowMapper<Order>() {
            public Order mapRow(ResultSet resultSet, int i) throws SQLException {
                Order order = new Order();
                order.setId(resultSet.getInt(1));
                order.setUser_id(resultSet.getInt(2));
                order.setDescription(resultSet.getString(3));
                order.setTotal(resultSet.getDouble(4));
                order.setCard_last_four(resultSet.getString(5));
                order.setStatus(resultSet.getString(6));
                order.setItem(resultSet.getString(7));
                return order;
            }
        });
    }

}

