package sg.edu.nus.iss.paf21_jul2023.repo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.paf21_jul2023.model.Customer;

@Repository
public class CustomerRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    // 1st function
    private final String findAllSql = "select id, first_name, last_name from customer";

    // 2nd function
    private final String findByIdSql = "select * from customer where id = ?";

    // 3rd --> u can do yourself (Slide 24)
    private final String findAllLimitOffsetSql = "select * from customer limit ? offset ?";

    public List<Customer> getAllCustomers() {
        List<Customer> customerList = new ArrayList<Customer>();

        SqlRowSet rs = jdbcTemplate.queryForRowSet(findAllSql);

        while (rs.next()) {
            Customer customer = new Customer();
            customer.setId(rs.getInt("id"));
            customer.setFirstName(rs.getString("first_name"));
            customer.setLastName(rs.getString("last_name"));

            customerList.add(customer);
        }

        return Collections.unmodifiableList(customerList);
    }

    public List<Customer> getAllCustomersWithLimitOff(int limit, int offset) {
        List<Customer> customerList = new ArrayList<Customer>();

        SqlRowSet rs = jdbcTemplate.queryForRowSet(findAllLimitOffsetSql, limit, offset);

        while (rs.next()) {
            Customer customer = new Customer();
            customer.setId(rs.getInt("id"));
            customer.setFirstName(rs.getString("first_name"));
            customer.setLastName(rs.getString("last_name"));

            customerList.add(customer);
        }

        return Collections.unmodifiableList(customerList);
    }

    public Customer getCustomerById(int id) {
        Customer customer = new Customer();

        customer = jdbcTemplate.queryForObject(findByIdSql, BeanPropertyRowMapper.newInstance(Customer.class), id);

        return customer;
    }

}
