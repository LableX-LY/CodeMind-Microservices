package com.xly.codemind.codemindmodel.model.dto.questionsubmit;

import com.xly.codemind.codemindcommon.common.PageRequest;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author X-LY。
 * @version 1.0
 * @createtime 2025/2/22 15:19
 * @description 查询题目提交信息请求类
 **/

@Data
public class QuestionResultQueryPageRequest extends PageRequest implements Serializable {

    /**
     * 题目本身的id
     */
    //private Long questionId;

    /**
     * 答题语言
     */
    private String questionLanguage;

    /**
     * 题目标题
     */
    private String questionTitle;

    /**
     * 判题信息
     */
    private String judgeInfo;

    /**
     * 判题状态
     */
    private int judgeStatus;

    /**
     * 更新时间
     */
    private Date updateTime;


    private static final long serialVersionUID = 1L;

}
