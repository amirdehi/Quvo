package com.amirdehi.quvo.dto.response;

import com.amirdehi.quvo.model.Option;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class VoteResponse {
    private int uniqueId;
    private String title;
    private String subtitle;
    private String creator;
    private Date creationDate;
    private Date expireDate;
    private List<Option> optionList;
}
