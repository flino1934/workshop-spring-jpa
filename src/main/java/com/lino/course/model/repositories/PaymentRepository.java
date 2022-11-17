package com.lino.course.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lino.course.model.entities.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
