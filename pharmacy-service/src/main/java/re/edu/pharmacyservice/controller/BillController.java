package re.edu.pharmacyservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import re.edu.pharmacyservice.dto.request.BillItemDTO;
import re.edu.pharmacyservice.dto.request.BillRequestDTO;
import re.edu.pharmacyservice.dto.response.BillResponseDTO;
import re.edu.pharmacyservice.entity.Medicine;
import re.edu.pharmacyservice.repository.IMedicineRepository;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@RefreshScope
public class BillController {

    private final IMedicineRepository medicineRepository;
    @Value("${pharmacy.vat-rate}")
    private Double vatRate;

    @Value("${app.branch-name:N/A}")
    private String branchName;

    @PostMapping("/bill")
    public ResponseEntity<BillResponseDTO> createBill(@RequestBody BillRequestDTO requestDTO) {

        double subTotal = 0.0;

        for (BillItemDTO item : requestDTO.getItems()) {
            Medicine medicine = medicineRepository.findById(item.getMedicineId())
                    .orElseThrow(() -> new RuntimeException(
                            "Không tìm thấy thuốc với ID: " + item.getMedicineId()));

            subTotal += medicine.getPrice() * item.getQuantity();
        }

        // Công thức: tổng tiền thuốc + % thuế VAT của tổng tiền thuốc
        double vatAmount = subTotal * (vatRate / 100);
        double totalAmount = subTotal + vatAmount;

        BillResponseDTO response = BillResponseDTO.builder()
                .subTotal(subTotal)
                .vatRate(vatRate)
                .vatAmount(vatAmount)
                .totalAmount(totalAmount)
                .branchName(branchName)
                .build();

        return ResponseEntity.ok(response);
    }
}
