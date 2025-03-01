package com.xly.codemind.codemindserviceclient.service;

import com.xly.codemind.codemindmodel.model.bean.Question;
import com.xly.codemind.codemindmodel.model.bean.QuestionSubmit;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author X-LY。
 * @version 1.0
 * @createtime 2025/3/1 08:43
 * @description 题目管理Feign接口
 **/

@FeignClient(name = "CodeMind-Question-Service",path = "/api/question/inner")
public interface QuestionFeignClient {

    @GetMapping("/get/id")
    Question getQuestionById(@RequestParam("questionId") long questionId);

    @GetMapping("/question/submit/get/id")
    QuestionSubmit getQuestionSubmitById(@RequestParam("questionId") long questionSubmitId);

    @PostMapping("/question/submit/update")
    boolean updateQuestionSubmitById(@RequestBody QuestionSubmit questionSubmit);

}
