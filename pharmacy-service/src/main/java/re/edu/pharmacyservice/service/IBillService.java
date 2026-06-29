package re.edu.pharmacyservice.service;

import re.edu.pharmacyservice.dto.request.BillRequestDTO;
import re.edu.pharmacyservice.dto.response.BillResponseDTO;

public interface IBillService {
    BillResponseDTO calculateBill(BillRequestDTO requestDTO);
}