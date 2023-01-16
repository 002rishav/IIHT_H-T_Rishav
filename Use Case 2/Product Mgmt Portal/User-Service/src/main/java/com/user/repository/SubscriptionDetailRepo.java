package com.user.repository;

import com.user.entity.SubscriptionDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubscriptionDetailRepo extends JpaRepository<SubscriptionDetail,Integer> {

    Optional<SubscriptionDetail> findByBookIdAndUserName(String bookId, String userName);

    Optional<List<SubscriptionDetail>> findByUserName(String userName);
}
