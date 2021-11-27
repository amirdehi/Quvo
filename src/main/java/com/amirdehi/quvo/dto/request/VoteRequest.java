package com.amirdehi.quvo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class VoteRequest {
    private int uniqueId;
    private String title;
    private String subtitle;
    private int creatorId;
    private int expirePlan;
    private List<String> optionsList;
}
