//package com.sal.service;
//import com.sal.model.Bank;
//import com.sal.repository.BankRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class BankCsvReaderService {
//
//    private final BankRepository bankRepository;
//
//    @Autowired
//    public BankCsvReaderService(BankRepository bankRepository) {
//        this.bankRepository = bankRepository;
//    }
//
//    public List<Bank> getAllBanks() {
//        return bankRepository.findAll();
//    }
//
//    public Bank getBankById(Long id) {
//        return bankRepository.findById(id).orElse(null);
//    }
//
//    public Bank createBank(Bank bank) {
//        return bankRepository.save(bank);
//    }
//
//    public Bank updateBank(Long id, Bank updatedBank) {
//        Bank existingBank = bankRepository.findById(id).orElse(null);
//        if (existingBank != null) {
//            existingBank.setBankName(updatedBank.getBankName());
//            existingBank.setBranchLocation(updatedBank.getBranchLocation());
//            existingBank.setContactNo(updatedBank.getContactNo());
//            existingBank.setEmailID(updatedBank.getEmailID());
//            return bankRepository.save(existingBank);
//        }
//        return null;
//    }
//
//    public void deleteBank(Long id) {
//        bankRepository.deleteById(id);
//    }
//}
