package com.dxc.payrollservice.service;

import com.dxc.payrollservice.entity.Payroll;

import java.util.Collection;

public interface PayrollService {

    Payroll create(Payroll payroll);

    Payroll update(Payroll payroll);

    Payroll findById(Long id);

    Collection<Payroll> findAll();

    void deleteById(Long id);

}
