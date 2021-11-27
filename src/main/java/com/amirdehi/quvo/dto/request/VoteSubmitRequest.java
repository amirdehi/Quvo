package com.amirdehi.quvo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class VoteSubmitRequest {
    private int uniqueId;
    private int selectedOptionId;
}
