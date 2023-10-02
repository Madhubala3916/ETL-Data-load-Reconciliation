//package com.sal.service;
//
//import com.sal.model.Transaction;
//import com.sal.repository.TransactionRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class TransactionCsvReaderService {
//    private final TransactionRepository transactionRepository;
//    @Autowired
//    public TransactionCsvReaderService(TransactionRepository transactionRepository) {
//        this.transactionRepository = transactionRepository;
//    }
//    public List<Transaction> getAllTransactions() {
//        return transactionRepository.findAll();
//    }
//    public Optional<Transaction> getTransactionById(Long id) {
//        return transactionRepository.findById(id);
//    }
//    public Transaction createTransaction(Transaction transaction) {
//        // Additional validation or business logic can be added here.
//        return transactionRepository.save(transaction);
//    }
//    public void deleteTransaction(Long id) {
//        transactionRepository.deleteById(id);
//    }
//
//}
