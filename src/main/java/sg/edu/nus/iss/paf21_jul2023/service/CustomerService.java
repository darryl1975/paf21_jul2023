package sg.edu.nus.iss.paf21_jul2023.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.paf21_jul2023.model.Customer;
import sg.edu.nus.iss.paf21_jul2023.repo.CustomerRepository;

@Service
public class CustomerService {
    
    @Autowired
    CustomerRepository custRepo;

    public List<Customer> getAllCustomers() {
        return custRepo.getAllCustomers();
    }

    public List<Customer> getallCustomersWithLimitAndOffset(int limit, int offset) {
        return custRepo.getAllCustomersWithLimitOff(limit, offset);
    }

    public Customer getCustomerById(int id) {
        return custRepo.getCustomerById(id);
    }
}
