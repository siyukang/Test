package com.free.sims.common.validator;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.free.sims.common.Result;

/**
 * @author liuzeke
 * @version 1.0
 */
@Aspect
@Component
public class ValidatorAspect {

	@Pointcut("@annotation(com.free.sims.common.validator.Validate)")
	private void interceptor() {
	}

	/**
	 * @author liuzeke
	 * @param pjp
	 * @param validate
	 * @return
	 * @throws Throwable
	 */
	@Around("interceptor()&&@annotation(validate)")
	public Object interceptor(ProceedingJoinPoint pjp, Validate validate) throws Throwable {
		Object[] objs = pjp.getArgs();
		if (ObjectUtils.isEmpty(objs))
			return pjp.proceed();
		Message result = WebValidator.validate(objs[0], validate.type());
		return result.isInvalid() ? Result.error(result.getMessage()) : pjp.proceed();
	}
}
