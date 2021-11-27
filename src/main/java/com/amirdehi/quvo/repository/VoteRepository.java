package com.amirdehi.quvo.repository;

import com.amirdehi.quvo.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Integer>, JpaSpecificationExecutor<Vote> {

}
