package re.edu.pharmacyservice.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BillResponseDTO {
    private Double subTotal;     // Tổng tiền thuốc (chưa thuế)
    private Double vatRate;      // % VAT áp dụng tại thời điểm tính (lấy trực tiếp từ config)
    private Double vatAmount;    // Tiền thuế VAT
    private Double totalAmount;  // Tổng tiền sau thuế
    private String branchName;   // Tên chi nhánh (lấy luôn từ config cho tiện kiểm tra)
}
