package br.com.fiap.checkpoint.controllers;

import br.com.fiap.checkpoint.models.Customer;
import br.com.fiap.checkpoint.models.Genre;
import br.com.fiap.checkpoint.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    private Customer getCustomer(String id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found"));
    }
    @GetMapping
    public Iterable<Customer> listCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("{id}")
    public Customer browseCustomer(@PathVariable String id) {
        return getCustomer(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable String id){
        var fundedCustomer = getCustomer(id);
        customerRepository.delete(fundedCustomer);
        return ResponseEntity.noContent().build();
    }

    @PostMapping ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        customerRepository.save(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(customer);
    }

    @PutMapping("{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable String id, @RequestBody Customer customer) {
        getCustomer(id);
        customer.setEmail(id);
        customerRepository.save(customer);
        return ResponseEntity.ok(customer);
    }

    // Usando o nome
    @GetMapping("/name/{name}")
    public List<Customer> listCustomersByName(@PathVariable String name) {
        List<Customer> customers = customerRepository.findAllByName(name);
        if(customers.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customers not found");
        }
        return customers;
    }

    // Usando o nome
    @GetMapping("/age")
    public List<Customer> listCustomersByAgeMaiority() {
        List<Customer> customers = customerRepository.findAllByAgeMaiority();
        if(customers.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customers not found");
        }
        return customers;
    }
}
