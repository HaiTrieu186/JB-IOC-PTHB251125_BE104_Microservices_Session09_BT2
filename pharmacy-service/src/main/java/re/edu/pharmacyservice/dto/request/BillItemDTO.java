package re.edu.pharmacyservice.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BillItemDTO {
    private Long medicineId;
    private Integer quantity;
}
