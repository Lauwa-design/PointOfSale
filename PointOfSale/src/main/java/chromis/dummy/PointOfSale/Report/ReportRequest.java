package chromis.dummy.PointOfSale.Report;

import chromis.dummy.PointOfSale.Enums.ReportType;
import lombok.Builder;


@Builder
public record ReportRequest (

        ReportType reportType
)
{
    private static ReportModel toReportModel (ReportRequest reportRequest){
        return ReportModel.builder()
                .reportType(reportRequest.reportType())
                .build();
    }
}
