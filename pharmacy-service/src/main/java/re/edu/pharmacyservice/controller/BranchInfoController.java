package re.edu.pharmacyservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/branch")
@RefreshScope
public class BranchInfoController {

    @Value("${app.branch-name}")
    private String branchName;

    @Value("${app.hotline}")
    private String hotline;

    @Value("${pharmacy.vat-rate}")
    private Double vatRate;

    @GetMapping("/info")
    public String getInfo() {
        return String.format("Chi nhánh: %s | Hotline: %s | VAT hiện tại: %.2f%%",
                branchName, hotline, vatRate);
    }
}
