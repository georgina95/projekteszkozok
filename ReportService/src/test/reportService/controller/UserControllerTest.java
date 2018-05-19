package reportService.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import reportService.model.Report;
import reportService.model.User;
import reportService.service.ReportService;
import reportService.service.UserService;
import reportService.service.UserSession;
import reportService.utility.Response;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static reportService.controller.UserController.*;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    @Mock
    private UserSession session;

    @Mock
    private UserService userService;

    @Mock
    private User user;

    @Mock
    private ReportService reportService;

    @Mock
    private Report report;

    @InjectMocks
    private UserController sut;


    @Test
    public void login_someOne_alreay_logged() {
        //fixture
        String nickName = "asd";
        String password = "pass";

        when(userService.login(nickName, password)).thenReturn(Optional.of(user));
        when(session.getUser()).thenReturn(user);

        //excercise
        Response result = sut.login(nickName, password);

        // verify
        assertEquals(SOMEONE_ALREADY_LOGGED_IN, result.getError());

    }

    @Test
    public void login() {
        //fixture
        String nickName = "asd";
        String password = "pass";

        when(userService.login(nickName, password)).thenReturn(Optional.of(user));
        when(session.getUser()).thenReturn(null);

        //excercise
        Response result = sut.login(nickName, password);

        // verify
        verify(session).setUser(user);
        assertEquals(user, result.getData());

    }

    @Test
    public void login_wrong_login_data() {
        //fixture
        String nickName = "asd";
        String password = "pass";

        when(userService.login(nickName, password)).thenReturn(Optional.empty());

        //excercise
        Response result = sut.login(nickName, password);

        // verify
        assertEquals(WRONG_NICKNAME_PASSWORD_PAIR, result.getError());

    }

    @Test
    public void logout() {
        // excercise
        Response result = sut.logout();

        // verify
        verify(session).setUser(eq(null));
        assertEquals(false, result.getData());
    }

    @Test
    public void report() {
        //fixture
        String nickName = "asd";
        String operator = UserController.EMPTY_STRING;

        when(session.getUser()).thenReturn(user);
        when(user.getNickname()).thenReturn(nickName);

        when(reportService.report(
                any(String.class),
                eq(nickName),
                eq(operator),
                eq(Report.Status.OPEN)))
                .thenReturn(Optional.of(report));

        //excercise
        Response<Report> result = sut.report();

        //verify
        assertEquals(report, result.getData());
    }
    @Test
    public void report_is_null() {
        //fixture
        String nickName = "asd";
        String operator = UserController.EMPTY_STRING;

        when(session.getUser()).thenReturn(user);
        when(user.getNickname()).thenReturn(nickName);

        when(reportService.report(
                any(String.class),
                eq(nickName),
                eq(operator),
                eq(Report.Status.OPEN)))
                .thenReturn(Optional.empty());

        //excercise
        Response<Report> result = sut.report();

        //verify
        assertEquals(REPORT_IS_NULL, result.getError());
    }
    @Test
    public void report_user_is_null() {
        //fixture
        when(session.getUser()).thenReturn(null);

        //excercise
        Response<Report> result = sut.report();

        //verify
        assertEquals(YOU_ARE_NOT_LOGGED_IN  , result.getError());
    }
}