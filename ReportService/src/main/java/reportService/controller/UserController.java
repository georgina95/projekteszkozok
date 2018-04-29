package reportService.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;

import reportService.model.Report;
import reportService.model.User;

import reportService.service.UserSession;
import reportService.service.UserService;
import reportService.service.ReportService;
//import reportService.service.StateService;
import reportService.utility.Response;

import java.text.SimpleDateFormat;
import java.util.Optional;
import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class UserController {
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
			if(session.getUser() == null) {
				User user = optionalUser.get();
            
				session.setUser(user);
				return Response.ok(user);
			}
			return Response.error("Someone already logged in!");
        }
        return Response.error("Wrong nickname-password pair!");
    }
	
	@RequestMapping("/logout")
    public Response logout() {
        session.setUser(null);
        return Response.ok(false);
	}
	
	@RequestMapping(value = "/report"/*, method = RequestMethod.GET*/)
    public Response<Report> report(
    ) {
		SimpleDateFormat formDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        String reportDate = formDate.format(sqlDate);
		
        Optional<Report> optionalReport = reportService.report(reportDate, session.getUser().nickname, "", Report.Status.OPEN);
		
		if(session.getUser() != null) {
			Report report = optionalReport.get();
			
			return Response.ok(report);
		}
		return Response.error("You are not logged in!");
    }
}