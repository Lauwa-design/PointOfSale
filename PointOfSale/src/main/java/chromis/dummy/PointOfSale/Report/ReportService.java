package chromis.dummy.PointOfSale.Report;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReportService {
    ReportModel create(ReportRequest reportRequest);
    List<ReportModel> getAllReports();
    ReportModel getReportById(String id);
    ReportModel update(String id,ReportRequest reportRequest);
    void deleteReportById(String id);

}
