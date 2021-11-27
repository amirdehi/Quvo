package com.amirdehi.quvo.service.interfaces;

import com.amirdehi.quvo.dto.request.VoteRequest;
import com.amirdehi.quvo.dto.request.VoteSubmitRequest;
import com.amirdehi.quvo.dto.response.VoteResponse;

import java.util.List;

public interface IVoteService {
    List<VoteResponse> showAll();
    VoteResponse showVote(int uniqueId);
    boolean create(VoteRequest voteRequest);
    boolean edit(VoteRequest voteRequest);
    boolean delete(int uniqueId);
    boolean submit(VoteSubmitRequest voteSubmitRequest);
    VoteResponse showResults(int uniqueId);
}
