package com.xly.codemind.codemindserviceclient.service;

import com.xly.codemind.codemindcommon.common.ErrorCode;
import com.xly.codemind.codemindcommon.exception.BusinessException;
import com.xly.codemind.codemindmodel.model.bean.User;
import com.xly.codemind.codemindmodel.model.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.List;

import static com.xly.codemind.codemindcommon.constant.UserConstant.USER_LOGIN_STATE;

/**
 * @author X-LY。
 * @version 1.0
 * @createtime 2025/3/1 08:42
 * @description 用户管理Feign接口
 **/

@FeignClient(name = "CodeMind-User-Service", path = "/api/user/inner")
public interface UserFeignClient {

    /**
     * 根据 id 获取用户
     * @param userId 用户id
     * @return 用户信息
     */
    @GetMapping("/get/id")
    User getById(@RequestParam("userId") long userId);

    /**
     * 根据 id 获取用户列表
     * @param idList 用户列表
     * @return 用户列表
     */
    @GetMapping("/get/ids")
    List<User> listByIds(@RequestParam("idList") Collection<Long> idList);

    /**
     * 获取当前登录用户
     * @param request Http请求
     * @return 登录用户
     */
    default User getLoginUser(HttpServletRequest request) {
        // 先判断是否已登录
        Object userObj = request.getSession().getAttribute(USER_LOGIN_STATE);
        User currentUser = (User) userObj;
        if (currentUser == null || currentUser.getId() == null) {
            throw new BusinessException(ErrorCode.NOT_LOGIN_ERROR);
        }
        // 可以考虑在这里做全局权限校验
        return currentUser;
    }

//    /**
//     * 是否为管理员
//     *
//     * @param user
//     * @return
//     */
//    default boolean isAdmin(User user) {
//        return user != null && UserRoleEnum.ADMIN.getValue().equals(user.getUserRole());
//    }

    /**
     * 获取脱敏的用户信息
     * @param user 用户（未脱敏）
     * @return 脱敏用户信息
     */
    default UserVO getUserVO(User user) {
        if (user == null) {
            return null;
        }
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        return userVO;
    }

}
