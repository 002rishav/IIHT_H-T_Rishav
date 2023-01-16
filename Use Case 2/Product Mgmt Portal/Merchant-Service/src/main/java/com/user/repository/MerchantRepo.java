package com.user.repository;

import com.user.entity.Merchant;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantRepo extends MongoRepository<Merchant, String> {
}
