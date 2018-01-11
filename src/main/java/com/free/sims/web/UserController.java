package com.free.sims.web;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.free.sims.common.Result;
import com.free.sims.common.validator.Type;
import com.free.sims.common.validator.Validate;
import com.free.sims.domain.User;
import com.free.sims.domain.UserForm;
import com.free.sims.service.UserService;

/**
 * @author liuzeke
 * @version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserService userService;

	/**
	 * @author liuzeke
	 * @param userForm
	 * @return
	 */
	@RequestMapping("/addUser")
	@Validate(type = Type.ADD)
	public Result addUser(UserForm userForm) {
		User user = new User();
		BeanUtils.copyProperties(userForm, user);
		userService.addUser(user);
		return Result.success();
	}

	/**
	 * @author liuzeke
	 * @param userForm
	 * @return
	 */
	@RequestMapping("/updateUser")
	@Validate(type = Type.UPDATE)
	public Result updateUser(UserForm userForm) {
		User user = new User();
		BeanUtils.copyProperties(userForm, user);
		userService.updateUser(user);
		return Result.success();
	}

	/**
	 * @author liuzeke
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteUser")
	public Result deleteUser(String id) {
		if (StringUtils.isEmpty(id))
			return Result.error("id不能为空！");
		userService.deleteUser(Long.valueOf(id));
		return Result.success();
	}

	/**
	 * @author liuzeke
	 * @return
	 */
	@RequestMapping("/getUser")
	public Result getUser() {
		return Result.success(userService.getUser());
	}
}
