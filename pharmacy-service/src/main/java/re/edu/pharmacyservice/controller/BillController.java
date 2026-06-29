package re.edu.pharmacyservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import re.edu.pharmacyservice.dto.request.BillRequestDTO;
import re.edu.pharmacyservice.dto.response.ApiResponse;
import re.edu.pharmacyservice.dto.response.BillResponseDTO;
import re.edu.pharmacyservice.service.IBillService;

@RestController
@RequestMapping("/api/v1/bill")
@RequiredArgsConstructor
@RefreshScope
public class BillController {

    private final IBillService billService;

    @PostMapping
    public ResponseEntity<ApiResponse<BillResponseDTO>> createBill(@RequestBody BillRequestDTO requestDTO) {
        BillResponseDTO data = billService.calculateBill(requestDTO);
        ApiResponse<BillResponseDTO> response = ApiResponse.success("Tính tiền hóa đơn thành công", data);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
