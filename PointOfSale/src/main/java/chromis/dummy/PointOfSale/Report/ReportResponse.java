package chromis.dummy.PointOfSale.Report;

import chromis.dummy.PointOfSale.Enums.ReportType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;

public record ReportResponse (
         String id,
         LocalDateTime createdOn,
         LocalDateTime updatedOn,
         ReportType reportType
)
{
    public static ReportResponse fromReportModel(ReportModel reportModel) {
        return new ReportResponse(
                reportModel.getId(),
                reportModel.getCreatedOn(),
                reportModel.getUpdatedOn(),
                reportModel.getReportType());

    }
}
