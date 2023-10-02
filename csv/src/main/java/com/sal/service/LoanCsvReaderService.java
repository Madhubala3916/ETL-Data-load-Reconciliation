//package com.sal.service;
//
//import com.sal.model.Loan;
//import com.sal.repository.LoanRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class LoanCsvReaderService {
//    private final LoanRepository loanRepository;
//
//    @Autowired
//    public LoanCsvReaderService(LoanRepository loanRepository) {
//        this.loanRepository = loanRepository;
//    }
//
//    public List<Loan> getAllLoans() {
//        return loanRepository.findAll();
//    }
//
//    public Optional<Loan> getLoanById(Long id) {
//        return loanRepository.findById(id);
//    }
//
//    public Loan createLoan(Loan loan) {
//        return loanRepository.save(loan);
//    }
//
//    public void deleteLoan(Long id) {
//        loanRepository.deleteById(id);
//    }
//
//    // You can add more methods as needed for loan-related operations.
//}
