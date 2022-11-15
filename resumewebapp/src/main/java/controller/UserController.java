package controller;

import com.company.JPA.Service.Inter.UserServiceInterface;
import com.company.JPA.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.List;

@SuppressWarnings("ALL")
@Controller
@RequestMapping("/users")
public class UserController {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private UserServiceInterface userService;

//    @RequestMapping(method = RequestMethod.GET)
//    public String index(HttpServletRequest request) throws SQLException {
//        String name = request.getParameter("name");
//        String surname = request.getParameter("surname");
//        String nationalityIdStr = request.getParameter("nationalityId");
//        Integer nationalityId = null;
//        if (nationalityId != null && !nationalityIdStr.trim().isEmpty()) {
//            nationalityId = Integer.parseInt(nationalityIdStr);
//        }
//        List<User> list = userService.getAllInfo(name, surname, nationalityId);
//
//        request.setAttribute("list",list);
//        return "users";
//    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(@RequestParam(value = "name", required = false) String name,
                              @RequestParam(value = "surname", required = false) String surname,
                              @RequestParam(value = "nationalityId", required = false) Integer nationalityId) throws SQLException {

        List<User> list = userService.getAllInfo(name, surname, nationalityId);

        ModelAndView mv = new ModelAndView("users");
        mv.addObject("list", list);
        return mv;
    }
}
