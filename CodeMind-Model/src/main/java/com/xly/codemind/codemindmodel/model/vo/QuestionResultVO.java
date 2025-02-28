package com.xly.codemind.codemindmodel.model.vo;

import cn.hutool.json.JSONUtil;
import com.xly.codemind.codemindmodel.model.bean.QuestionSubmit;
import com.xly.codemind.codemindmodel.model.dto.questionsubmit.JudgeInfo;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * @author X-LY。
 * @version 1.0
 * @createtime 2025/2/22 16:22
 * @description 题目提交结果视图类（脱敏）
 **/
@Data
public class QuestionResultVO implements Serializable {

    /**
     * 题目本身的id
     */
    private long questionId;

    /**
     * 题目标题
     */
    private String questionTitle;

    /**
     * 题目所选的答题语言
     */
    private String questionLanguage;

    /**
     * 判题状态
     */
    private int judgeStatus;

    /**
     * 判题信息
     */
    private JudgeInfo judgeInfo;

    /**
     * 答题者名字
     */
    private String userName;

    /**
     * 更新时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    /**
     * 对象转包装类
     * @param questionSubmit 题目提交类
     * @return 题目提交视图（脱敏）
     */
    public static QuestionResultVO objToVo(QuestionSubmit questionSubmit) {
        if (questionSubmit == null) {
            return null;
        }
        QuestionResultVO questionResultVO = new QuestionResultVO();
        BeanUtils.copyProperties(questionSubmit, questionResultVO);
        String judgeInfoStr = questionSubmit.getJudgeInfo();
        questionResultVO.setJudgeInfo(JSONUtil.toBean(judgeInfoStr, JudgeInfo.class));
        return questionResultVO;
    }

}
