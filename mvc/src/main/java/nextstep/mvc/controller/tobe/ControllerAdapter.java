package nextstep.mvc.controller.tobe;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import nextstep.mvc.HandlerAdapter;
import nextstep.mvc.controller.asis.Controller;
import nextstep.mvc.view.JspView;
import nextstep.mvc.view.ModelAndView;

public class ControllerAdapter implements HandlerAdapter {

    @Override
    public boolean supports(Object handler) {
        return handler instanceof Controller;
    }

    @Override
    public ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        Controller contoller = (Controller) handler;
        return new ModelAndView(new JspView(contoller.execute(request, response)));
    }
}