package chromis.dummy.PointOfSale.Report;


import chromis.dummy.PointOfSale.Enums.ReportType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data


public class ReportModel {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    //private UserModel generatedBy;
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
    private ReportType reporttype;

}
