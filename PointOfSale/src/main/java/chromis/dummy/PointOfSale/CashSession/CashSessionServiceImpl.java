package chromis.dummy.PointOfSale.CashSession;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CashSessionServiceImpl implements CashSessionService {
    private final CashSessionRepository cashSessionRepository;

    // CREATE
    @Override
    public CashSessionModel create(CashSessionRequest cashSessionRequest) {
        CashSessionModel model = CashSessionRequest.toCashSessionModel(cashSessionRequest);
        return cashSessionRepository.save(model);
    }

    // READ ALL
    @Override
    public List<CashSessionModel> getAll() {

        return cashSessionRepository.findAll();
    }

    // READ BY ID
    @Override
    public CashSessionModel getSessionById(String sessionId) {
        return cashSessionRepository.findById(sessionId)
                .orElseThrow(() -> new RuntimeException("Cash session not found with ID: " + sessionId));
    }

    // UPDATE
    @Override
    public CashSessionModel update(String sessionId, CashSessionRequest cashSessionRequest) {
        CashSessionModel existing = cashSessionRepository.findById(sessionId)
                .orElseThrow(() -> new RuntimeException("Cash session not found with ID: " + sessionId));

        // Update fields from cashSessionRequest
        existing.setEndCash(cashSessionRequest.endCash());
        existing.setTotalCash(cashSessionRequest.totalCash());
        existing.setIsClosed(cashSessionRequest.isClosed());

        return cashSessionRepository.save(existing); // @PreUpdate will set endTime
    }

    // DELETE
    @Override
    public void deleteSession(String sessionId) {
        if (!cashSessionRepository.existsById(sessionId)) {
            throw new RuntimeException("Cash session not found with ID: " + sessionId);
        }
        cashSessionRepository.deleteById(sessionId);
    }
}


