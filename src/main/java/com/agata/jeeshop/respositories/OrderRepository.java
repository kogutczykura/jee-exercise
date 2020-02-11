package com.agata.jeeshop.respositories;

import com.agata.jeeshop.models.Cart;
import com.agata.jeeshop.models.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<PurchaseOrder, Long> {
}
