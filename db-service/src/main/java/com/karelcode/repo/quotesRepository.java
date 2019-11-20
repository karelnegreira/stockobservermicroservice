package com.karelcode.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karelcode.model.Quote;

public interface quotesRepository extends JpaRepository<Quote, Integer>{
List<Quote>findByUsername(String username);
}
