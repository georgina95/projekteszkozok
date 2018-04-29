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

import reportService.service.UserSession;
//import reportService.service.UserService;
import reportService.service.ReportService;
//import reportService.service.StateService;
import reportService.utility.Response;

import java.util.Optional;
import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	UserSession session;
    /*@Autowired
    private UserService userService;*/
	@Autowired
	private ReportService reportService;
	/*
	@Autowired
	private StateService stateService;
	*/
	
	@RequestMapping(value = "/report", method = RequestMethod.GET)
    public Response<Report> report(
        @RequestParam(value = "reportDate") String reportDate,
        @RequestParam(value = "reporter") String reporter,
        @RequestParam(value = "operator") String operator,
        @RequestParam(value = "status") Report.Status status
    ) {
        Optional<Report> optionalReport = reportService.report(reportDate, reporter, operator, status);

		if(session.getUser() != null) {
			Report report = optionalReport.get();
			
			return Response.ok(report);
		}
		return Response.error("You are not logged in!");
    }
}