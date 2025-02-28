package com.xly.codemind.codemindmodel.model.dto.questionsubmit;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author X-LY。
 * @version 1.0
 * @createtime 2024/12/14 14:18
 * @description 判题信息（执行时间、内存占用等信息）
 **/
@Data
@AllArgsConstructor
public class JudgeInfo {

    /**
     * 程序执行信息
     */
    private String message;
    /**
     * 程序消耗内存 KB
     */
    private Long memory;
    /**
     * 消耗时间 ms
     */
    private Long time;

//    /**
//     * 具体的判题题目
//     */
//    private Question question;

}
