package com.why.start.ssm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Books implements Serializable {
    private         int         bookID;
    private         String      bookName;
    private         int         bookCounts;
    private         String      detail;
}
