package az.unitech.mscurrency.client;

import az.unitech.mscurrency.dto.response.ApiResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "currency-api",url="https://api.exchangeratesapi.io/v1")
public interface CurrencyApiClient {

    @GetMapping("/latest")
    ApiResponseDto getLatestRates(@RequestParam("access_key") String accessKey,@RequestParam("format") int format);

}
