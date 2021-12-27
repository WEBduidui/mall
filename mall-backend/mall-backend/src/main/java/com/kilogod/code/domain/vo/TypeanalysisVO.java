package com.kilogod.code.domain.vo;

import lombok.Data;

import java.util.List;

@Data
public class TypeanalysisVO {
    private List<AnalysisVO> data;
    private List<String> type;
}
