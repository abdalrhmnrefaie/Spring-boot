package com.global.book.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.global.book.basic.BasicRepository;
import com.global.book.entity.Auther;

@Repository
public interface AutherRepository extends BasicRepository<Auther, Long> ,JpaSpecificationExecutor<Auther>{

	
	Optional<Auther> findByEmail(String email);

}
