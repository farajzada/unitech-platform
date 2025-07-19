package az.unitech.mscurrency.controller;

import az.unitech.mscurrency.dto.request.CreateRateRequest;
import az.unitech.mscurrency.dto.response.ExchangeRateDto;
import az.unitech.mscurrency.service.impl.CurrencyRateServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/rates")
@Validated
public class CurrencyController {

    private final CurrencyRateServiceImpl currencyRateService;

    @PostMapping("/save")
    public ResponseEntity<ExchangeRateDto> save(@Valid @RequestBody CreateRateRequest createRateRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(currencyRateService.createRate(createRateRequest));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ExchangeRateDto>> getAll(){
        return ResponseEntity.ok(currencyRateService.getAllRates());
    }

    @GetMapping
    public ResponseEntity<ExchangeRateDto> getRate(@RequestParam String from,@RequestParam String to){
        return ResponseEntity.ok(currencyRateService.getRate(from, to));
    }

    @PutMapping("/upd")
    public  ResponseEntity<ExchangeRateDto> update(@RequestParam String from,@RequestParam String to,@RequestParam BigDecimal rate){
        return ResponseEntity.ok(currencyRateService.updateRate(from, to, rate));
    }

    @DeleteMapping("/del/{id}")
    public  ResponseEntity<Void> deleteById(@PathVariable Long id){
        currencyRateService.deleteRateById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/del")
    public  ResponseEntity<Void> delete(@RequestParam String from,@RequestParam String to){
        currencyRateService.deleteRate(from,to);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
