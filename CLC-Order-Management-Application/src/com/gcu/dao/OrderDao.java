package com.gcu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import Model.Order;
import Model.User;
import org.springframework.jdbc.core.RowMapper;


public class OrderDao
{
    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template)
    {
        this.template = template;
    }

    public int save(Order order)
    {
        String sql = "INSERT INTO CST323.orders(user_id, description, total, card_last_four, status, item) values('"+order.getUser_id()+"','"+order.getDescription()+"','"+order.getTotal()+"','"+order.getCard_last_four()+"','"+order.getStatus()+"','"+order.getItem()+"');";
        return template.update(sql);
    }

    public int update(Order order)
    {
        String sql = "UPDATE CST323.orders SET user_id'"+order.getId()+"',description='"+order.getDescription()+"',total='"+order.getTotal()+"',card_last_four='"+order.getCard_last_four()+"',status='"+order.getStatus()+"',item='"+order.getItem()+"' WHERE id='"+order.getId()+"';";
        return template.update(sql);
    }

    public int delete(int id)
    {
        String sql = "DELETE FROM CST323.orders WHERE id="+id+"";
        return template.update(sql);
    }

    public List<Order> getOrders()
    {
        String sql = "SELECT * FROM CST323.orders";
        return template.query(sql, new RowMapper<Order>() {
            @Override
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

