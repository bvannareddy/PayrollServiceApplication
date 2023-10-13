package com.dxc.payrollservice.service.impl;

import com.dxc.payrollservice.constants.PayrollConstants;
import com.dxc.payrollservice.entity.Payroll;
import com.dxc.payrollservice.exception.PayrollDeleteException;
import com.dxc.payrollservice.exception.PayrollNotFoundException;
import com.dxc.payrollservice.repository.PayrollRepository;
import com.dxc.payrollservice.service.PayrollService;
import com.dxc.payrollservice.util.PayrollUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;


@Service
@Transactional
public class PayrollServiceImpl implements PayrollService {

    private final PayrollRepository payrollRepository;

    @Autowired
    public PayrollServiceImpl(PayrollRepository payrollRepository) {
        this.payrollRepository = payrollRepository;
    }


    @Override
    public Payroll create(Payroll payroll) {
        setCode(payroll);
        return payrollRepository.save(payroll);
    }

    @Override
    public Payroll update(Payroll payroll) {
        setCode(payroll);
        return payrollRepository.save(payroll);
    }


    @Override
    public Payroll findById(Long id) throws PayrollNotFoundException {
        Optional<Payroll> optionalPayroll = payrollRepository.findById(id);
        if (optionalPayroll.isPresent()) {
            return optionalPayroll.get();
        } else {
            throw new PayrollNotFoundException(id + " Not found at DB", HttpStatus.NOT_FOUND.value());
        }
    }

    @Override
    public Collection<Payroll> findAll() {
        return payrollRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        try {
            payrollRepository.deleteById(id);
        } catch (Exception exception) {
            throw new PayrollDeleteException(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }

    private void setCode(Payroll payroll) {

        if (payroll == null) {
            return;
        }

        if (payroll.getCode() == null) {
            payroll.setCode(PayrollUtils.PAYROLL_CODE_FOR_LLP);
            payroll.setInternationalPayroll(PayrollConstants.INTERNATION_PAYROLL_NO);
        } else if (payroll.getCode().equalsIgnoreCase(PayrollUtils.PAYROLL_CODE_FOR_LTD)) {
            payroll.setInternationalPayroll(PayrollConstants.INTERNATION_PAYROLL_YES);
        } else {
            payroll.setInternationalPayroll(PayrollConstants.INVALID_INTERNATION_CODE);
        }
    }

}
