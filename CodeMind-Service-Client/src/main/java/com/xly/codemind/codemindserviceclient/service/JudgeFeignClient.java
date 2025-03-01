package com.xly.codemind.codemindserviceclient.service;

import com.xly.codemind.codemindmodel.model.bean.QuestionSubmit;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author X-LY。
 * @version 1.0
 * @createtime 2025/3/1 08:44
 * @description 判题服务Feign接口
 **/

@FeignClient(name = "CodeMind-Judge-Service",path = "/api/judge/inner")
public interface JudgeFeignClient {

    /**
     * 执行判题
     * @param questionSubmittedId 题目提交记录的id
     * @return 题目提交记录实体类
     */
    @PostMapping("/do")
    QuestionSubmit doJudge(@RequestParam("questionSubmitId") long questionSubmittedId);

}
