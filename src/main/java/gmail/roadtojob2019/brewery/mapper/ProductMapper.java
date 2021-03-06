package gmail.roadtojob2019.brewery.mapper;

import gmail.roadtojob2019.brewery.dto.ProductDto;
import gmail.roadtojob2019.brewery.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mappings({
            @Mapping(target = "amount", source = "storage.amount"),
    })
    ProductDto productToProductDto(Product product);
}
