package com.diy.lawnmower.dao;

import com.diy.lawnmower.LawnMower;
import org.springframework.data.repository.CrudRepository;

public interface LawnMowerRepo extends CrudRepository<LawnMower, Integer> {
}
