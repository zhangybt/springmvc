package com.product.exception;

import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created by zhangybt on 2017/5/24.
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {

    private static Logger logger = LoggerFactory.getLogger(CustomExceptionResolver.class);

    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        logger.error(e.getMessage());

        String message = null;
        CustomException customException = null;
        CustomRuntimeException customRuntimeException = null;

        String imformation = "操作失败,请求内容错误";
        String code = "-100";
        //如果ex是系统 自定义的异常，直接取出异常信息
        if (e instanceof CustomException) {
            customException = (CustomException) e;
            message = customException.getMessage();
        } else if (e instanceof CustomRuntimeException) {
            customRuntimeException = (CustomRuntimeException) e;
            message = customRuntimeException.getMessage();
            code = customRuntimeException.getCode();
            imformation = customRuntimeException.getMessage();
        } else {
            //针对非CustomException异常，对这类重新构造成一个CustomException，异常信息为“未知错误”
            customException = new CustomException("未知错误");
            message = customException.getMessage();
        }

        //错误 信息
        httpServletRequest.setAttribute("message", message);

        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json; charset=utf-8");

        try {
            PrintWriter out = httpServletResponse.getWriter();

            JSONObject json = new JSONObject();
            json.put("code", code);
            json.put("information", imformation);
            out.write(json.toString());

        } catch (Exception ex) {
            // TODO Auto-generated catch block
            logger.error(ex.getMessage());
        }

        return new ModelAndView();
    }
}
