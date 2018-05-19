package reportService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reportService.model.Report;
import reportService.model.User;
import reportService.service.ReportService;
import reportService.service.UserService;
import reportService.service.UserSession;
import reportService.utility.Response;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

//import reportService.service.StateService;

@RestController
@RequestMapping("/api")
public class UserController {
    public static final String SOMEONE_ALREADY_LOGGED_IN = "Someone already logged in!";
    public static final String WRONG_NICKNAME_PASSWORD_PAIR = "Wrong nickname-password pair!";
    public static final String REPORT_IS_NULL = "Repor is null!";
    public static final String EMPTY_STRING = "";
    public static final String YOU_ARE_NOT_LOGGED_IN = "You are not logged in!";
    @Autowired
    UserSession session;
    @Autowired
    private UserService userService;
    @Autowired
    private ReportService reportService;
	/*
	@Autowired
	private StateService stateService;
	*/

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public Response<User> login(
            @RequestParam(value = "nickname") String nickname,
            @RequestParam(value = "password") String password
    ) {
        Optional<User> optionalUser = userService.login(nickname, password);

        if (optionalUser.isPresent()) {
            if (session.getUser() == null) {
                User user = optionalUser.get();

                session.setUser(user);
                return Response.ok(user);
            }
            return Response.error(SOMEONE_ALREADY_LOGGED_IN);
        }
        return Response.error(WRONG_NICKNAME_PASSWORD_PAIR);
    }

    @RequestMapping("/logout")
    public Response logout() {
        session.setUser(null);
        return Response.ok(false);
    }

    @RequestMapping(value = "/report"/*, method = RequestMethod.GET*/)
    public Response<Report> report() {
        SimpleDateFormat formDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date utilDate = new Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        String reportDate = formDate.format(sqlDate);

        if (session.getUser() != null) {
            Optional<Report> optionalReport = reportService.report
                    (reportDate, session.getUser().getNickname(), EMPTY_STRING, Report.Status.OPEN);


            if (optionalReport.isPresent()) {
                Report report = optionalReport.get();
                return Response.ok(report);
            }
            return Response.error(REPORT_IS_NULL);


        }
        return Response.error(YOU_ARE_NOT_LOGGED_IN);
    }
}