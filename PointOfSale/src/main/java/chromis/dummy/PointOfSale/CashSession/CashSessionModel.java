package chromis.dummy.PointOfSale.CashSession;

import chromis.dummy.PointOfSale.Enums.CashSessionStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data


public class CashSessionModel {
    @Id
    private String sessionId;

    @PrePersist
    public void generateSessionId() {
        if (sessionId == null) {
            this.sessionId = UUID.randomUUID().toString();
        }
    }
    private LocalDateTime startTime;

    private LocalDateTime endTime;


    public void startSession() {
        startTime = LocalDateTime.now();

        isClosed = false;
    }
    public void endSession() {
        endTime = LocalDateTime.now();

        isClosed = false;
    }

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal startCash;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal endCash;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal totalCash;

    private boolean isClosed;

    @Enumerated(EnumType.STRING)
    private CashSessionStatus cashSessionStatus;



}
