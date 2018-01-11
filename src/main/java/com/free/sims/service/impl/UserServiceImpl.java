package com.free.sims.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.free.sims.common.Model;
import com.free.sims.domain.User;
import com.free.sims.service.UserService;

/**
 * @author liuzeke
 * @version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

	@Resource
	private MongoTemplate mongoTemplate;

	/**
	 * @author liuzeke
	 * @param user
	 */
	@Override
	public void addUser(User user) {
		user.setId(getId());
		mongoTemplate.insert(user);
	}

	/**
	 * @author liuzeke
	 * @param user
	 */
	@Override
	public void updateUser(User user) {
		User dbUser = getUserById(user.getId());
		BeanUtils.copyProperties(user, dbUser);
		mongoTemplate.save(dbUser);
	}

	/**
	 * @author liuzeke
	 * @param id
	 */
	@Override
	public void deleteUser(Long id) {
		mongoTemplate.findAndRemove(Query.query(Criteria.where("id").is(id)), User.class);
	}

	/**
	 * @author liuzeke
	 * @param id
	 * @return
	 */
	@Override
	public User getUserById(Long id) {
		return mongoTemplate.findById(id, User.class);
	}

	/**
	 * @author liuzeke
	 * @return
	 */
	@Override
	public List<User> getUser() {
		return mongoTemplate.findAll(User.class);
	}

	/**
	 * @author liuzeke
	 * @return
	 */
	@Override
	public Long getId() {
		Model model = mongoTemplate.findAndModify(Query.query(Criteria.where("_id").is(User.class.getName())),
				new Update().inc("sequence", 1), Model.class);
		if (model == null) {
			mongoTemplate.insert(new Model().set_id(User.class.getName()).setSequence(1L));
			return 1L;
		}
		return model.getSequence() + 1;
	}
}
