package chromis.dummy.PointOfSale.CashSession;

import chromis.dummy.PointOfSale.Enums.CashSessionStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder


public class CashSessionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String sessionId;

    private LocalDateTime startTime;

    private LocalDateTime endTime;


    @PrePersist
    public void startSession () {
        startTime = LocalDateTime.now();

        isClosed = false;
    }

    public void endSession () {
        endTime = LocalDateTime.now();

        isClosed = false;
    }


    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal startCash;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal endCash;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal totalCash;

    private Boolean isClosed;

    @Enumerated(EnumType.STRING)
    private CashSessionStatus cashSessionStatus;



}
