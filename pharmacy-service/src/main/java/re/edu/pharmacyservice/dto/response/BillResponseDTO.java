package re.edu.pharmacyservice.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BillResponseDTO {
    private Double originalPrice;
    private Double vatRate;
    private Double finalPrice;
}