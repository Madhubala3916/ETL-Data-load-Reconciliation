package com.sal.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PaymentID")
    private Long paymentID;
    @ManyToOne
    @JoinColumn(name = "LoanID")
    private Loan loan;
    @Column(name = "Amount")
    private Double amount;
    @Column(name = "PaymentDate")
    private LocalDateTime paymentDate;

    public Payment() {
    }

    public Long getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(Long paymentID) {
        this.paymentID = paymentID;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Payment(Long paymentID, Loan loan, Double amount, LocalDateTime paymentDate) {
        this.paymentID = paymentID;
        this.loan = loan;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }
}