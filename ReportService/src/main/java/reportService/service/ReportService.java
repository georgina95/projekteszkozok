/*package reportService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import reportService.model.Report;

import reportService.repository.ReportRepository;
import reportService.repository.StateRepository;
import reportService.repository.UserRepository;

import java.util.Optional;
import java.util.ArrayList;

@Service
public class ReportService {
    @Autowired
    private ReportRepository reportRepository;
    @Autowired
    private StateRepository stateRepository;
    @Autowired
    private UserRepository userRepository;

    public Optional<Report> report(int id, String reportDate, String reporter, String operator, int state) {
        Optional<Report> optionalReport = reportRepository.findById(id).get();

        if(!optionalReport.isPreset()){
            Report report = new Report();

            report.setReportDate(reportDate);
            report.setReporter(userRepository.findByName(reporter).get());
            report.setOperatort(userRepository.findByName(operator).get());
            report.setStatus(stateRepository.findById(state).get());

            reportRepository.save(report);

            return Optional.of(report);
        }
        return Optional.empty();
    }

    public ArrayList<Report> getList(){
        ArrayList<Report> reportList = reportRepository.findAll();

        return reportList;
    }

    public Optional<Report> getReportById(int id){
        Optional<Report> optionalReport = reportRepository.findById(id);
        if(optionalReport.isPresent()){
            return optionalReport;
        }
        return Optional.empty;
    }

    public void delete(int id) {reportRepository.delete(id);}
}*/