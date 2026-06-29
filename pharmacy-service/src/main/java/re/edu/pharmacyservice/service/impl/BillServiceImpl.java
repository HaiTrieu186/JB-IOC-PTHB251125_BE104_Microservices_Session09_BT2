package re.edu.pharmacyservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import re.edu.pharmacyservice.dto.request.BillRequestDTO;
import re.edu.pharmacyservice.dto.response.BillResponseDTO;
import re.edu.pharmacyservice.service.IBillService;

@Service
@RefreshScope
@RequiredArgsConstructor
public class BillServiceImpl implements IBillService {

    @Value("${pharmacy.vat-rate}")
    private Double vatRate;

    @Override
    public BillResponseDTO calculateBill(BillRequestDTO requestDTO) {
        Double originalPrice = requestDTO.getTotalMedicinePrice();

        // Công thức: Tiền thuế = Tổng tiền * (VAT / 100)
        Double vatAmount = originalPrice * (vatRate / 100);
        Double finalPrice = originalPrice + vatAmount;

        return BillResponseDTO.builder()
                .originalPrice(originalPrice)
                .vatRate(vatRate)
                .finalPrice(finalPrice)
                .build();
    }
}