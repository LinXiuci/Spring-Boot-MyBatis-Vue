package com.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QueryInfo {
    private String query;
    private int pageNum=1;
    private int pageSize=1;
}
