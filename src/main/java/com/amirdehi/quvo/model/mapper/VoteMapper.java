package com.amirdehi.quvo.model.mapper;

import com.amirdehi.quvo.dto.request.VoteRequest;
import com.amirdehi.quvo.dto.response.VoteResponse;
import com.amirdehi.quvo.model.Option;
import com.amirdehi.quvo.model.Users;
import com.amirdehi.quvo.model.Vote;
import com.amirdehi.quvo.util.Util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class VoteMapper {
    public static Vote toVote(VoteRequest voteRequest, Users user){
        Vote vote = new Vote();

        vote.setTitle(voteRequest.getTitle());
        vote.setSubtitle(voteRequest.getSubtitle());
        vote.setCreator(user);
        vote.setCreationDate(Calendar.getInstance().getTime());
        vote.setExpireDate(Util.getPlannedDate(voteRequest.getExpirePlan()));

        return vote;
    }

    public static List<Option> toOptionList(List<String> list, Vote voteFK){
        List<Option> optionList = new ArrayList<>();

        for (String s : list) {
            Option option = new Option();
            option.setText(s);
            option.setVoteFK(voteFK);
            option.setVotesCount(0);
            optionList.add(option);
        }

        return optionList;
    }

    public static List<Option> toOptionResponseList(List<Option> options) {
        List<Option> optionList = new ArrayList<>();

        for (Option value : options) {
            Option option = new Option();
            option.setUniqueId(value.getUniqueId());
            option.setText(value.getText());
            optionList.add(option);
        }

        return optionList;
    }

    public static VoteResponse toVoteResponse(Vote vote) {
        VoteResponse voteResponse=new VoteResponse();
        voteResponse.setUniqueId(vote.getUniqueId());
        voteResponse.setTitle(vote.getTitle());
        voteResponse.setSubtitle(vote.getSubtitle());
        voteResponse.setCreator(vote.getCreator().getFullName());
        voteResponse.setCreationDate(vote.getCreationDate());
        voteResponse.setExpireDate(vote.getExpireDate());
        return voteResponse;
    }

    public static Vote updater(Vote oldVote, Vote newVote){
        oldVote.setTitle(newVote.getTitle());
        oldVote.setSubtitle(newVote.getSubtitle());
        oldVote.setExpireDate(newVote.getExpireDate());
        oldVote.setOption(newVote.getOption());
        return oldVote;
    }

}
