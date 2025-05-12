package dev.rme.controller.rest;

import dev.rme.model.database.Product;
import dev.rme.model.dto.request.UpdateProductRequest;
import dev.rme.service.rest.MultiLanguageInfoService;
import dev.rme.service.rest.ProductService;
import dev.rme.service.rest.PromotionDisplayService;
import dev.rme.service.xml.XmlValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("api/404rme/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final PromotionDisplayService promotionDisplayService;
    private final MultiLanguageInfoService multiLanguageInfoService;
    private final XmlValidationService xmlValidationService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(productService.findAllProducts());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Product> findById(@PathVariable BigInteger id) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.findProductById(id));
    }

    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> insert(@RequestBody String xml) {
        xmlValidationService.validateWithRngAndInsert(xml);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> update(@RequestBody UpdateProductRequest request) {
        productService.updateProduct(request.getId(), request.getPrice());
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> delete(@PathVariable BigInteger id) {
        promotionDisplayService.delete(id);
        multiLanguageInfoService.delete(id);
        productService.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
