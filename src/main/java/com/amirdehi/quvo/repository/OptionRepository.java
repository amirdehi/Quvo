package com.amirdehi.quvo.repository;

import com.amirdehi.quvo.model.Option;
import com.amirdehi.quvo.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OptionRepository extends JpaRepository<Option, Integer>, JpaSpecificationExecutor<Option> {
    List<Option> findOptionsByVoteFK(Vote voteFK);
}
