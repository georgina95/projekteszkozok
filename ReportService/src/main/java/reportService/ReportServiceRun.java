package reportService;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
public class ReportServiceRun {

    @RequestMapping("/")
    String home() {
        return "Index";
    }
    public static void main(String[] args) throws Exception {
        SpringApplication.run(ReportServiceRun.class, args);
    }
}

