package chromis.dummy.PointOfSale.CashSession;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CashSessionService {
    CashSessionModel create(CashSessionRequest cashSessionRequest);
    List<CashSessionModel> getAll();
    CashSessionModel getSessionById(String sessionId);
    CashSessionModel update(String sessionId, CashSessionRequest cashSessionRequest);
    void deleteSession(String sessionId);
}
