package chromis.dummy.PointOfSale.Report;


import chromis.dummy.PointOfSale.Enums.ReportType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder


public class ReportModel {
    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private String id;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

    @PrePersist
    public void onCreate() {

        createdOn = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {

        updatedOn = LocalDateTime.now();
    }

    @Enumerated(EnumType.STRING)
    private ReportType reportType;

}
