package com.free.sims.common;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author liuzeke
 * @version 1.0
 */
@Component
public class HandlerExcecptionResolverImpl implements HandlerExceptionResolver {

	/**
	 * process exception
	 * 
	 * @author liuzeke
	 * @param request
	 * @param response
	 * @param handler
	 * @param ex
	 * @return
	 */
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		PrintWriter out = null;
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		try {
			out = response.getWriter();
			out.println(Result.error("服务端异常！").toString());
			out.flush();
		} catch (IOException e) {
			return null;
		} finally {
			if (out != null)
				out.close();
		}
		return null;
	}
}
