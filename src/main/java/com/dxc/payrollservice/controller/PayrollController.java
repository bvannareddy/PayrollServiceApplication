package com.dxc.payrollservice.controller;

import com.dxc.payrollservice.entity.Payroll;
import com.dxc.payrollservice.service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("payroll")
public class PayrollController {

    private final PayrollService payrollService;

    @Autowired
    public PayrollController(PayrollService payrollService) {
        this.payrollService = payrollService;
    }

    @PostMapping
    Payroll create(@RequestBody Payroll payroll) {
        return payrollService.create(payroll);
    }

    @PutMapping
    Payroll update(@RequestBody Payroll payroll) {
        return payrollService.create(payroll);
    }

    @GetMapping("{id}")
    Payroll findById(@PathVariable("id") Long id) {
        return payrollService.findById(id);
    }

    @GetMapping
    Collection<Payroll> findAll() {
        return payrollService.findAll();
    }

    @DeleteMapping("{id}")
    void deleteById(@PathVariable("id") Long id) {
        payrollService.deleteById(id);
    }

}
