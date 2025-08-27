
package chromis.dummy.PointOfSale.CashSession;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
public record CashSessionResponse(

        String sessionId,
        LocalDateTime startTime,
        LocalDateTime endTime,
        BigDecimal startCash,
        BigDecimal endCash,
        BigDecimal totalCash,
        Boolean isClosed
)
{
    public static CashSessionResponse fromCashSessionModel(CashSessionModel cashSessionModel){
        return new CashSessionResponse(
                 cashSessionModel.getSessionId(),
                 cashSessionModel.getStartTime(),
                 cashSessionModel.getEndTime(),
                 cashSessionModel.getStartCash(),
                 cashSessionModel.getEndCash(),
                 cashSessionModel.getTotalCash(),
                 cashSessionModel.getIsClosed());

    }
}


