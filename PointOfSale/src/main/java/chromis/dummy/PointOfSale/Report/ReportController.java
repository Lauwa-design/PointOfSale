package chromis.dummy.PointOfSale.Report;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports") // Base URL for this controller
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    // ✅ CREATE
    @PostMapping
    public ResponseEntity<ReportModel> createReport(@RequestBody ReportRequest request) {
        ReportModel response = reportService.create(request);
        return ResponseEntity.ok(response);
    }

    // ✅ READ (Get all)
    @GetMapping
    public ResponseEntity<List<ReportModel>> getAllReports() {
        List<ReportModel> reports = reportService.getAllReports();
        return ResponseEntity.ok(reports);
    }

    // ✅ READ (Get by ID)
    @GetMapping("/{id}")
    public ResponseEntity<ReportModel> getReportById(@PathVariable String id) {
        ReportModel response = reportService.getReportById(id);
        return ResponseEntity.ok(response);
    }

    // ✅ UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<ReportModel> updateReport(
            @PathVariable String id,
            @RequestBody ReportRequest request
    ) {
        ReportModel response = reportService.update(id, request);
        return ResponseEntity.ok(response);
    }

    // ✅ DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReport(@PathVariable String id) {
        reportService.deleteReportById(id);
        return ResponseEntity.ok("Report with id " + id + " deleted successfully");
    }
}

