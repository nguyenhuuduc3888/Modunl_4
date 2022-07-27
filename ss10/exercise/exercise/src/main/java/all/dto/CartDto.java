package all.dto;

import java.util.HashMap;
import java.util.Map;

public class CartDto {
    private Map<ProductDto, Integer> productMap = new HashMap<>();

    public CartDto() {
    }

    public CartDto(Map<ProductDto, Integer> productMap) {
        this.productMap = productMap;
    }

    public Map<ProductDto, Integer> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<ProductDto, Integer> productMap) {
        this.productMap = productMap;
    }

    public void addProduct(ProductDto productDto) {
        //Nếu đã có trong giỏ hàng thì cộng thêm 1
        if (productMap.containsKey(productDto)) {
            Integer currentValue = productMap.get(productDto);
            productMap.replace(productDto, currentValue + 1);
            //Nếu chưa có thì đặt là 1
        } else {
            productMap.put(productDto, 1);
        }
    }
}
