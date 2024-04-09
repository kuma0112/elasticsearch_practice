package com.sparta.elasticsearce_practice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Long, Board> {
}
