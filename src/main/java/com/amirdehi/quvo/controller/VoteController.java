package com.amirdehi.quvo.controller;

import com.amirdehi.quvo.dto.request.VoteRequest;
import com.amirdehi.quvo.dto.request.VoteSubmitRequest;
import com.amirdehi.quvo.dto.response.VoteResponse;
import com.amirdehi.quvo.service.interfaces.IVoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VoteController {

    IVoteService voteService;

    @Autowired
    public VoteController(IVoteService voteService){
        this.voteService = voteService;
    }

    @GetMapping("/showAllVotes")
    public List<VoteResponse> showAll(){
        return voteService.showAll();
    }

    @GetMapping("/showVote/{voteId}")
    public VoteResponse showVote(@PathVariable int voteId){
        return voteService.showVote(voteId);
    }

    @PostMapping("/createVote")
    public boolean createVote(@RequestBody VoteRequest voteRequest){
        return voteService.create(voteRequest);
    }

    @PutMapping("/editVote")
    public boolean editVote(@RequestBody VoteRequest voteRequest){
        return voteService.edit(voteRequest);
    }

    @DeleteMapping("/deleteVote/{voteId}")
    public boolean deleteVote(@PathVariable int voteId){
        return voteService.delete(voteId);
    }

    @PostMapping("/submitVote")
    public boolean submitVote(@RequestBody VoteSubmitRequest voteSubmitRequest){
        return voteService.submit(voteSubmitRequest);
    }

    @GetMapping("/voteResults/{voteId}")
    public VoteResponse showResults(@PathVariable int voteId){
        return voteService.showResults(voteId);
    }
}
