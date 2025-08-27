package chromis.dummy.PointOfSale.Report;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class ReportServiceImpl implements ReportService{
    private final ReportRepository reportRepository;

    @Override
    public ReportModel create(ReportRequest reportRequest){
        ReportModel reportModel = new ReportModel();
        return reportRepository.save(reportModel);
    }
    @Override
    public List<ReportModel> getAllReports(){
        return reportRepository.findAll();

    }

    @Override
    public ReportModel getReportById(String id){
        return reportRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Report not found by id:"+ id));

    }

    @Override
    public ReportModel update(String id,ReportRequest reportRequest){
        ReportModel existing = reportRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Report not found by id:"+ id));

        existing.setReportType(reportRequest.reportType());

        return reportRepository.save(existing);

    }

    @Override
    public void deleteReportById(String id){
        if (!reportRepository.existsById(id)) {
            throw new RuntimeException("Report not found with ID: " + id);
        }
        reportRepository.deleteById(id);

    }

}
