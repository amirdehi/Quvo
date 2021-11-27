package com.amirdehi.quvo.service.implementations;

import com.amirdehi.quvo.dto.request.VoteRequest;
import com.amirdehi.quvo.dto.request.VoteSubmitRequest;
import com.amirdehi.quvo.dto.response.VoteResponse;
import com.amirdehi.quvo.model.Option;
import com.amirdehi.quvo.model.Users;
import com.amirdehi.quvo.model.Vote;
import com.amirdehi.quvo.model.mapper.VoteMapper;
import com.amirdehi.quvo.repository.OptionRepository;
import com.amirdehi.quvo.repository.UserRepository;
import com.amirdehi.quvo.repository.VoteRepository;
import com.amirdehi.quvo.service.interfaces.IVoteService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Service
public class VoteServiceImpl implements IVoteService {

    @Autowired
    VoteRepository voteRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    OptionRepository optionRepository;

    @Override
    public List<VoteResponse> showAll() {
        List<VoteResponse> voteResponses = new ArrayList<>();
        List<Vote> voteList = voteRepository.findAll();
        for (Vote vote : voteList) {
            VoteResponse voteResponse = VoteMapper.toVoteResponse(vote);
            List<Option> optionList = VoteMapper.toOptionResponseList(optionRepository.findOptionsByVoteFK(vote));
            voteResponse.setOptionList(optionList);
            voteResponses.add(voteResponse);
        }
        return voteResponses;
    }

    @Override
    public VoteResponse showVote(int uniqueId) {
        VoteResponse voteResponse=new VoteResponse();
        if (voteRepository.findById(uniqueId).isPresent()) {
            Vote vote = voteRepository.getById(uniqueId);
            voteResponse = VoteMapper.toVoteResponse(vote);
            List<Option> optionList = VoteMapper.toOptionResponseList(optionRepository.findOptionsByVoteFK(vote));
            voteResponse.setOptionList(optionList);
        }
        return voteResponse;
    }

    @Override
    public boolean create(VoteRequest voteRequest) {
        Users user=userRepository.getById(voteRequest.getCreatorId());
        if (user.getId()<1)
            return false;
        Vote vote= VoteMapper.toVote(voteRequest,user);
        vote = voteRepository.save(vote);
        List<Option> optionList= VoteMapper.toOptionList(voteRequest.getOptionsList(), vote);
        for (Option option : optionList) {
            optionRepository.save(option);
        }
        return true;
    }

    @Override
    public boolean edit(VoteRequest voteRequest) {
        Users user=userRepository.getById(voteRequest.getCreatorId());
        if (user.getId()<1)
            return false;
        if (voteRepository.findById(voteRequest.getUniqueId()).isPresent()) {
            Vote dbVote = voteRepository.getById(voteRequest.getUniqueId());
            Vote vote = VoteMapper.updater(dbVote,VoteMapper.toVote(voteRequest,user));
            vote = voteRepository.save(vote);
            List<Option> optionList= VoteMapper.toOptionList(voteRequest.getOptionsList(), vote);
            for (Option option : optionList) {
                optionRepository.save(option);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int uniqueId) {
        if (voteRepository.findById(uniqueId).isPresent()){
            Vote vote = voteRepository.getById(uniqueId);
            List<Option> optionList= optionRepository.findOptionsByVoteFK(vote);
            for (Option option: optionList)
                optionRepository.delete(option);
            voteRepository.delete(vote);
            return true;
        }
        return false;
    }

    @Override
    public boolean submit(VoteSubmitRequest voteSubmitRequest) {
        if (voteRepository.findById(voteSubmitRequest.getUniqueId()).isPresent()) {
            if (optionRepository.findById(voteSubmitRequest.getSelectedOptionId()).isPresent()){
                Option option= optionRepository.getById(voteSubmitRequest.getSelectedOptionId());
                option.setVotesCount(option.getVotesCount()+1);
                optionRepository.save(option);
                return true;
            }
        }
        return false;
    }

    @Override
    public VoteResponse showResults(int uniqueId) {
        VoteResponse voteResponse=new VoteResponse();
        if (voteRepository.findById(uniqueId).isPresent()) {
            Vote vote = voteRepository.getById(uniqueId);
            voteResponse = VoteMapper.toVoteResponse(vote);
            voteResponse.setOptionList(optionRepository.findOptionsByVoteFK(vote));
        }
        return voteResponse;
    }
}
