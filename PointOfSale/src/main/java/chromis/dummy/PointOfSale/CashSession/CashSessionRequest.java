package chromis.dummy.PointOfSale.CashSession;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
public record CashSessionRequest(


        BigDecimal startCash,
        BigDecimal endCash,
        BigDecimal totalCash,
        Boolean isClosed
)
{
    public static CashSessionModel toCashSessionModel(CashSessionRequest cashSessionRequest){
        return CashSessionModel.builder()
                .startCash(cashSessionRequest.startCash())
                .endCash(cashSessionRequest.endCash())
                .totalCash(cashSessionRequest.totalCash())
                .isClosed(cashSessionRequest.isClosed())
                .build();
    }
}

